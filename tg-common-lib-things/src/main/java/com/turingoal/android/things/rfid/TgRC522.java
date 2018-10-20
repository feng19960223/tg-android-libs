package com.turingoal.android.things.rfid;

import android.util.Log;

import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.SpiDevice;

import java.io.IOException;

/**
 * MFRC522非接触式读写卡芯片、最大通信速率13.56MHz<br>
 * 支持接口：UART、SPI(Speed_max=10Mbit/s)、IIC(快速:400Kbit/s,高速:3400Kbit/s)<br>
 * 通信协议：ISO-14443A 或者叫 MIFARE<br>
 * 收发缓冲：64字节<br>
 * 支持中断模式、可编程定时器、CRC协处理器<br>
 * ATQ：对请求的应答、ATQA 对A型卡请求的应答、ATQB 对B型卡请求的应答.REQA：对A型卡的请求、REQB：对B型卡的请求<br>
 * MIFARE卡(M1卡)：兼具读写功能，主要是非接触式，有快速防冲突机制 – 处理多卡同时进入感应区的机制，其特殊的存储结构适合一卡多用，目前主要芯片philip mifare1 S50、 S70等;<br>
 * M1卡结构：共16个扇区，每个扇区4块（块0～3），共64块，按块号编址为0～63。第0扇区的块0（即绝对地址0块）用于存放厂商代码，已经固化，不可更改。其他各扇区：块0、块1、块2为数据块，用于存贮数据；块3为控制块，存放密码A、存取控制、密码B。<br>
 * 寻卡---------->防冲突---------->选卡--------->操作卡<br>
 * 工作原理：<br>
 * 通过对读卡器芯片内寄存器的读写来控制读卡器芯片，读卡器芯片收到MCU发来的命令后，按照非接触式射频卡协议格式，通过天线及其匹配电路向附近发出一组固定频率的调制信号（13.56MHz）进行寻卡。<br>
 * 若此范围内有卡片存在，卡片内部的LC谐振电路（谐振频率与读卡器发送的电磁波频率相同）在电磁波的激励下，产生共振，在卡片内部电压泵的作用下不断为其另一端的电容充电，获得能量，当该电容电压达到2V时，即可作为电源为卡片的其他电路提供工作电压。<br>
 * 　当有卡片处在读卡器的有效工作范围内时，MCU向卡片发出寻卡命令，卡片将回复卡片类型，建立卡片与读卡器的第一步联系。<br>
 * 若同时有多张卡片在天线的工作范围内，读卡器通过启动防冲撞机制，根据卡片序列号来选定一张卡片。<br>
 * 被选中的卡片再与读卡器进行密码校验，确保读卡器对卡片有操作权限以及卡片的合法性，而未被选中的则仍然处在闲置状态，等待下一次寻卡命令。<br>
 * 密码验证通过之后，就可以对卡片进行读写等应用操作。<br>
 * <p>
 * （1）M1卡得电复位(RPO:Power-On Restset)，是MFRC522天线发出电磁波导致，意味着有命令REQA过来，称为标准的请求，这种情况是M1卡进入感应区后首次与MFRC522通信。<br>
 * 其他情况，M1卡进入休眠状态或之前的操作已经终止，Halt之后被WUPA命令再次唤醒，称为获得所有的请求。<br>
 * 获得请求之后M1卡发送回应ATQA码。ATQA是卡的类型码：S50的类型码是0x04，S70的类型码是0x02。<br>
 * (2)M1卡获得请求后再次获得防冲突命令执行防冲突机制。<br>
 * 情景分析：有这么一种情况，一个时刻多张卡同时出现在MFRC522感应区，这时候RC522必须要专一，同时和几张卡发生关系早晚都是要出事的，那么RC522必须要认定其中一张卡。<br>
 * 当然事情还要讲究两厢情愿是吧，522问人家了，这就要求M1卡能够主动告知RC522“我就是你的唯一的标识”。<br>
 * 于是，事情就变成了这样：RC522获得最先主动告诉它的M1卡的UID，即卡的SN(4Bytes)+校验(1Byte) ，作为下一步选择通信卡的依据，这个SN需要主机从MFRC522中读出来暂时保存<br>
 * (3)选卡：在主机控制下MFRC522需要把选卡的命令和上一步获取的卡SN依次发送给M1卡，卡收到信息之后很老实，是选自己的信息就主动返回SAK信息，1Byte，实际上就是卡片的容量。<br>
 * (4)验证密码：这是极其关键的一步了，里面涉及比较多比较复杂的协议。<br>
 * 在PCD选中卡之后，接着主机控制他指出将要访问的存储器位置，然后连同验证密码命令、验证秘钥A|B一起发送给卡，三次密码确认(硬件)成功之后，MFRC522的Status2Reg的Bit_4置位，之后的数据传输都是经过加密的。<br>
 * （对一个扇区一次验证密码成功之后根据控制字的设置可以对该扇区的数据块进行相应读写操作直到执行Halt终止或验证其他扇区的密码，在选择另一扇区时，需要先进行这一扇区密码校验。细心观察上面那幅流程图的箭头也可以发现这个要求）<br>
 * 此外，有一点必须要说明的就是：默认控制下FF07806时A秘钥：不可读出，具有所有权限；B秘钥：可读出，没有任何权限。<br>
 * 控制字和秘钥之间的联系，推荐使用这个软件：<a href="http://pan.baidu.com/s/1eQuCCvw">http://pan.baidu.com/s/1eQuCCvw</a> <br>
 * (5)存储器操作：最终目的。<br>
 * 数据块写、数据块读：通过向M1卡发送WRITE、READ命令，分别是0xA0、0x30；<br>
 * 数据块增值、数据块减值：通过发M1卡的INCREMENT、DECREMENT指令，分别是0xC1、0xC0；（写数据块时命令连同数据值一块发送。）<br>
 * (6)终止卡操作：HALT指令进入终止休眠模式。<br>
 * (7)数据完整性措施：PCD和PICC之间的数据传输<br>
 * 每个块16位CRC校验、每个字节都有奇偶校验位、位计数检查、位编码区别“1”“0”“无信息”、信道监控。<br>
 * CRC16校验： MFRC522内部有CRC16协处理器，主机通过软件设置CRC初始值，然后把要发送的数据发送给MFRC522，激活CRC16协处理器后，等待一小会读取CRCResultReg寄存器值即CRC16校验值，然后把这个16位的校验值附加到数据值后再通过MFRC522发送给M1卡片。<br>
 * 至于其他校验是硬件自动完成的，我们只需要自己去读取MFRC522的Status1Reg寄存器看检验完成情况，读ErrorReg寄存器就可知道成功与否。<br>
 * <p>
 * S50卡的初始密码A和B是12个F<br>
 * 选中卡之后，首先要知道这个扇区的控制字，标准MF卡的控制字缺省值是0xFF078069，然后根据控制字要求验证扇区的密码A或密码B，验证成功之后就可以进行读写数据块操作了。<br>
 * 扇区的秘钥AB存放在该扇区的数据块3，因此要修改扇区的密码事先就要先知道这个扇区的控制字和原先的秘钥A或B，根据控制字的要求验证秘钥A或B成功之后即可对存放在数据块3的秘钥AB进行修改<br>
 * 控制字是该扇区的各个数据块的读写权限控制中心。控制字的修改和修改秘钥的方法步骤一样，只要根据控制字的需要密码验证成功之后即可对数据块3的控制字域的值进行修改。这里先推测，修改密码和控制字时，都是一起进行写操作的，因为他们在同一个数据区。<br>
 * Based on <a href="https://github.com/ondryaso/pi-rc522/" target="blank">pi-rc22 by ondryaso</a>
 *
 * @see <a href="https://www.nxp.com/documents/data_sheet/MFRC522.pdf" target="blank">MFRC522 Reference</a>
 * @see <a href="http://www.nxp.com/docs/en/data-sheet/MF1S50YYX_V1.pdf" target="blank">MIFARE Classic Reference/a>
 */
public class TgRC522 {
    private static final String TAG = "tgRC522";
    private static final byte MAX_LENGTH = 16; //扇区字节数。当前为RC522的卡片 , 共有16个扇区 , 4个块 . 每块最大支持的字节数就是 16
    // 默认密码
    public byte[] defaultKey = new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF};
    private boolean debugging = false; // debug模式
    private SpiDevice device; // SPI 端口
    private Gpio resetPin; // RST引脚 默认 22
    private int busSpeed = 1000000; // 频率
    private byte[] uid; // 卡的UID
    private byte[] backData; // 返回数据
    private int backDataLength; // 返回数据长度
    private int backLength;
    private ErrorType error; // 错误类型

    /**
     * 初始化RC522
     *
     * @param spiDevice SPI 端口
     * @param resetPin  RST引脚
     */
    public TgRC522(final SpiDevice spiDevice, final Gpio resetPin) throws IOException {
        this.device = spiDevice;  // SPI 端口
        this.resetPin = resetPin; // RST引脚
        initializePeripherals(); // 初始化外部设备
    }

    /**
     * 初始化外部设备
     */
    private void initializePeripherals() throws IOException {
        device.setFrequency(busSpeed); // 设置频率
        resetPin.setDirection(Gpio.DIRECTION_OUT_INITIALLY_HIGH); // 输出并且初始化为高电平
        initializeDevice();  //  初始化设备
    }

    /**
     * 设置debug模式
     */
    public void setDebugging(boolean debugging) {
        this.debugging = debugging; // debug
    }

    /**
     * 初始化设备
     */
    private void initializeDevice() {
        reset(); // 复位
        writeRegister(TgConstantRC522Register.REGISTER_TIMER_MODE, (byte) 0x8D);
        writeRegister(TgConstantRC522Register.REGISTER_TIMER_PRESCALER_MODE, (byte) 0x3E);
        writeRegister(TgConstantRC522Register.REGISTER_TIMER_RELOAD_LOW, (byte) 30);
        writeRegister(TgConstantRC522Register.REGISTER_TIMER_RELOAD_HIGH, (byte) 0);
        writeRegister(TgConstantRC522Register.REGISTER_TX_MODE, (byte) 0x40);
        writeRegister(TgConstantRC522Register.REGISTER_MODE, (byte) 0x3D);
        setAntenna(true); // 开启天线
    }

    /**
     * 复位。使用RC522的RESET引脚配合PCD_RESETPHASE复位命令实现对于RC522芯片的复位操作
     */
    private void reset() {
        writeRegister(TgConstantRC522Register.REGISTER_COMMAND, TgConstantPcdCCW.PCD_RESETPHASE); // 复位
    }

    /**
     * （1）寻卡。寻天线区内未进入休眠状态
     */
    public boolean request() {
        return this.request(TgConstantPiccCCW.PICC_REQIDL); // 寻天线区内未进入休眠状态。读取完卡后还会再次读取。（除非在某次读取完成后系统进入休眠（Halt））
    }

    /**
     * （1）寻卡
     *
     * @param requestMode 寻卡方式 TgConstantPiccCCW.PICC_REQIDL或者TgConstantPiccCCW.PICC_REQALL
     */
    public boolean request(byte requestMode) {
        boolean success = true;
        writeRegister(TgConstantRC522Register.REGISTER_BIT_FRAMING, (byte) 0x07);
        byte tagType[] = new byte[]{requestMode}; // 寻卡方式 TgConstantPiccCCW.PICC_REQIDL或者TgConstantPiccCCW.PICC_REQALL
        success = execute(TgConstantPcdCCW.PCD_TRANSCEIVE, tagType);  // 发送并接收数据
        if (backLength != 0x10) {
            backLength = 0;
            success = false;
        }
        return success;
    }

    /**
     * （2） 防冲突检测<br>
     * 防冲突操作就是将防冲突命令通过PcdComMF522函数与PICC卡进行交互。防冲突命令是两个字节，其中第一字节为Mifare_One卡的防冲突命令字PICC_ANTICOLL1 （0x93），第二个字节为0x20。<br>
     * 一个时刻多张卡同时出现在MFRC522感应区，那么RC522必须要认定其中一张卡。RC522获得最先主动告诉它的M1卡的UID，即卡的SN(4Bytes)+校验(1Byte) ，作为下一步选择通信卡的依据<br>
     *
     * @return 没有冲突错误返回ture
     */
    public boolean antiCollisionDetect() {
        boolean success = true;
        int serial_number_check = 0;
        int i;
        writeRegister(TgConstantRC522Register.REGISTER_BIT_FRAMING, (byte) 0x00);
        byte[] serial_number = new byte[]{TgConstantPiccCCW.PICC_ANTICOLL, 0x20};  // 防冲撞
        success = execute(TgConstantPcdCCW.PCD_TRANSCEIVE, serial_number);  // 发送并接收数据
        if (success) {
            if (backDataLength == 5) {
                for (i = 0; i < 4; i++) {
                    serial_number_check ^= backData[i];
                }
                if (serial_number_check != backData[4]) {
                    return false;
                }
            }
            uid = backData;
        }
        return success;
    }

    /**
     * 计算  CRC <br>
     * CRC16校验： MFRC522内部有CRC16协处理器，主机通过软件设置CRC初始值，然后把要发送的数据发送给MFRC522。<br>
     * 激活CRC16协处理器后，等待一小会读取CRCResultReg寄存器值即CRC16校验值，然后把这个16位的校验值附加到数据值后再通过MFRC522发送给M1卡片。<br>
     * 至于其他校验是硬件自动完成的，我们只需要自己去读取MFRC522的Status1Reg寄存器看检验完成情况，读ErrorReg寄存器就可知道成功与否。<br>
     *
     * @param data the data the crc value wil lbe generated for
     * @return 2-byte array containing the crc value or null if something failed
     */
    private byte[] calculateCrc(byte[] data) {
        writeRegister(TgConstantRC522Register.REGISTER_COMMAND, TgConstantPcdCCW.PCD_IDLE); // 取消当前命令
        writeRegister(TgConstantRC522Register.REGISTER_DIV_IRQ, (byte) 0x04);
        writeRegister(TgConstantRC522Register.REGISTER_FIFO_LEVEL, (byte) 0x80);
        for (int i = 0; i < data.length - 2; i++) {
            writeRegister(TgConstantRC522Register.REGISTER_FIFO_DATA, data[i]);
        }
        writeRegister(TgConstantRC522Register.REGISTER_COMMAND, TgConstantPcdCCW.PCD_CALCULATE_CRC); // CRC计算
        long start = System.nanoTime(); // 开始时间
        long end = 0; // 结束时间
        do {
            byte n = readRegister(TgConstantRC522Register.REGISTER_DIV_IRQ);
            //Check if CRCIRq bit is set
            if ((n & 0x04) != 0) {
                writeRegister(TgConstantRC522Register.REGISTER_COMMAND, TgConstantPcdCCW.PCD_IDLE); // 取消当前命令
                return new byte[]{readRegister(TgConstantRC522Register.REGISTER_CRC_RESULT_LOW), readRegister(TgConstantRC522Register.REGISTER_CRC_RESULT_HIGH)};
            }
            end = System.nanoTime(); // 结束时间
        } while (start + 89000000L >= end);
        error = ErrorType.ERROR_TIMEOUT;
        Log.w(TAG, "计算CRC超时");
        return null;
    }

    /**
     * （3）选卡<br>
     * 在主机控制下MFRC522需要把选卡的命令和上一步获取的卡SN依次发送给M1卡，卡收到信息之后选自己的信息就主动返回SAK信息，1Byte，实际上就是卡片的容量。<br>
     * 向 FIFO 中写入 PICC_SElECTTAG＋0x70＋卡序列号，通过 PCD_TRANSCEIVE 命令将 FIFO 中数据通过天线发送出去，卡返回卡容量（对于 MIFARE 1 卡来说，可能为 88H 或 08H）；
     *
     * @param uid 标签的 uid
     */
    public boolean selectTag(byte[] uid) {
        boolean success;
        byte data[] = new byte[9];
        data[0] = TgConstantPiccCCW.PICC_SElECTTAG; // 选卡命令
        data[1] = 0x70; // 地址
        int i, j;
        for (i = 0, j = 2; i < 5; i++, j++) { // 添加卡序列号到命令数据
            data[j] = uid[i];
        }
        byte[] crc = calculateCrc(data); // 计算  CRC
        if (crc == null) {
            success = false;
        } else {
            data[7] = crc[0]; // 添加CRC到命令数据
            data[8] = crc[1]; // 添加CRC到命令数据
            success = execute(TgConstantPcdCCW.PCD_TRANSCEIVE, data); // 发送并接收数据
            if (backLength != 0x18) {
                success = false;
            }
        }
        return success;
    }


    /**
     * （4）授权，需要提前选择标签<br>
     * 在PCD选中卡之后，接着主机控制他指出将要访问的存储器位置，然后连同验证密码命令、验证秘钥A|B一起发送给卡。<br>
     * 三次密码确认(硬件)成功之后，MFRC522的Status2Reg的Bit_4置位，之后的数据传输都是经过加密的。<br>
     * （对一个扇区一次验证密码成功之后根据控制字的设置可以对该扇区的数据块进行相应读写操作直到执行Halt终止或验证其他扇区的密码，在选择另一扇区时，需要先进行这一扇区密码校验。<br>
     * 默认控制下FF07806时A秘钥：不可读出，具有所有权限；B秘钥：可读出，没有任何权限。<br>
     * 向 FIFO 中写入 AUTH_A/AUTH_B＋块地址＋扇区密码＋卡序列号，通过 PCD_TRANSCEIVE 命令将 FIFO 中数据通过天线发送出去<br>
     * Authenticates the use of a specific address. The tag must be selected before.
     * For reference, see section 10.3.1.9 MFAuthent in MFRC522's datasheet
     *
     * @param authMode 授权方式 {AUTH_A} or {AUTH_B}
     * @param address  地址
     * @param key      6 byte array  key
     */
    public boolean authenticateCard(byte authMode, byte address, byte[] key) {
        debugLog("authenticateCard: authMode: %s, address: %d, key: %s", (authMode == TgConstantAuthTypes.AUTH_A ? "A" : "B"), address, TgConvertUtil.dataToHexString(key));
        boolean success = true;
        byte data[] = new byte[12];
        data[0] = authMode; // 授权方式 AUTH_A/AUTH_B
        data[1] = address; //  地址
        int i, j;
        for (i = 0, j = 2; i < 6; i++, j++) { // 添加扇区密码到命令数据
            data[j] = key[i];
        }
        for (i = 0, j = 8; i < 4; i++, j++) {  // 添加卡序列号到命令数据
            data[j] = uid[i];
        }
        success = execute(TgConstantPcdCCW.PCD_AUTHENT, data);  // 验证密钥
        if ((readRegister(TgConstantRC522Register.REGISTER_RXTX_STATUS) & 0x08) == 0) {
            return false;
        }
        return success;
    }

    /**
     * （4）授权，A。需要提前选择标签<br>
     */
    public boolean authenticateCardByA(byte address, byte[] key) {
        return authenticateCard(TgConstantPiccCCW.PICC_AUTHENT1A, address, key);
    }

    /**
     * （4）授权，B。需要提前选择标签<br>
     */
    public boolean authenticateCardByB(byte address, byte[] key) {
        return authenticateCard(TgConstantPiccCCW.PICC_AUTHENT1B, address, key);
    }

    /**
     * Ends operations that use crypto and cleans up
     */
    public void stopCrypto() {
        clearBitMask(TgConstantRC522Register.REGISTER_RXTX_STATUS, (byte) 0x08); // 寄存器包含接收器和发送器和数据模式检测器的状态标志
    }

    /**
     * 读取标签块的数据。必须授权
     *
     * @param address 地址
     * @param buffer  用来存储数据的 byte array , 长度必须为16
     */
    public boolean readBlock(final byte address, final byte[] buffer) {
        debugLog("readBlock: address: %d", address);
        boolean success = true;
        byte data[] = new byte[4];
        data[0] = TgConstantPiccCCW.PICC_READ; // 读块命令
        data[1] = address; // 地址
        byte[] crc = calculateCrc(data); // 计算  CRC
        if (crc == null) {
            success = false;
        } else {
            data[2] = crc[0]; // 添加CRC到命令数据
            data[3] = crc[1]; // 添加CRC到命令数据
            success = execute(TgConstantPcdCCW.PCD_TRANSCEIVE, data); // 发送并接收数据
            if (backDataLength != 16) {
                success = false;
            } else {
                System.arraycopy(backData, 0, buffer, 0, 16);
            }
        }
        return success;
    }

    /**
     * 写数据到标签块。必须授权
     *
     * @param address 地址
     * @param data    数据
     */
    public boolean writeBlock(final byte address, final byte[] data) {
        debugLog("writeBlock: address: %d, data: %s", address, TgConvertUtil.dataToHexString(data));
        boolean success = true;
        byte buff[] = new byte[4];
        buff[0] = TgConstantPiccCCW.PICC_WRITE; // 写块命令
        buff[1] = address; // 地址
        byte[] crc = calculateCrc(buff); // 计算  CRC
        if (crc == null) {
            success = false;
        } else {
            buff[2] = crc[0]; // 添加CRC到命令数据
            buff[3] = crc[1]; // 添加CRC到命令数据
            success = execute(TgConstantPcdCCW.PCD_TRANSCEIVE, buff); // 发送并接收数据
            if (backLength != 4 || (backData[0] & 0x0F) != 0x0A) {
                success = false;
            } else {
                byte buffWrite[] = new byte[data.length + 2];
                System.arraycopy(data, 0, buffWrite, 0, data.length);
                crc = calculateCrc(buffWrite); // 计算  CRC
                if (crc == null) {
                    success = false;
                } else {
                    buffWrite[buffWrite.length - 2] = crc[0]; // 添加CRC到命令数据
                    buffWrite[buffWrite.length - 1] = crc[1]; // 添加CRC到命令数据
                    success = execute(TgConstantPcdCCW.PCD_TRANSCEIVE, buffWrite); // 发送并接收数据
                    if (backLength != 4 || (backData[0] & 0x0F) != 0x0A) {
                        success = false;
                    }
                }
            }
        }
        return success;
    }

    /**
     * 充值一个块的值。块必须是值块，需要提前选择标签并授权
     * Increases the value of a block by the specified operand.
     * The data is stored in the internal transfer buffer.
     *
     * @param address 地址
     * @param operand 加和操作 the sum's operand
     */
    public boolean increaseBlock(final byte address, final int operand) {
        debugLog("increaseBlock: address %d, operand %d", address, operand);
        boolean success = true;
        byte buff[] = new byte[4];
        buff[0] = TgConstantPiccCCW.PICC_INCREMENT; // 充值命令
        buff[1] = address; // 地址
        byte[] crc = calculateCrc(buff); // 计算  CRC
        if (crc == null) {
            success = false;
        } else {
            buff[2] = crc[0]; // 添加CRC到命令数据
            buff[3] = crc[1]; // 添加CRC到命令数据
            success = execute(TgConstantPcdCCW.PCD_TRANSCEIVE, buff); // 发送并接收数据
            if (backLength != 4 || (backData[0] & 0x0F) != 0x0A) {
                success = false;
            } else {
                byte buffWrite[] = new byte[6];
                System.arraycopy(TgConvertUtil.intToByteArray(operand), 0, buffWrite, 0, 4);
                crc = calculateCrc(buffWrite); // 计算  CRC
                if (crc == null) {
                    success = false;
                } else {
                    buffWrite[buffWrite.length - 2] = crc[0]; // 添加CRC到命令数据
                    buffWrite[buffWrite.length - 1] = crc[1]; // 添加CRC到命令数据
                    execute(TgConstantPcdCCW.PCD_TRANSCEIVE, buffWrite); // 发送并接收数据
                }
            }
        }
        return success;
    }

    /**
     * 扣款一个块的值。块必须是值块，需要提前选择标签并授权
     * The data is stored in the internal transfer buffer.
     *
     * @param address 地址
     * @param operand 减法操作 the substraction's operand
     */
    public boolean decreaseBlock(byte address, int operand) {
        debugLog("increaseBlock: address %d, operand %d", address, operand);
        boolean success = true;
        byte buff[] = new byte[4];
        buff[0] = TgConstantPiccCCW.PICC_DECREMENT; // 扣款命令
        buff[1] = address; // 地址
        byte[] crc = calculateCrc(buff); // 计算  CRC
        if (crc == null) {
            success = false;
        } else {
            buff[2] = crc[0]; // 添加CRC到命令数据
            buff[3] = crc[1]; // 添加CRC到命令数据
            success = execute(TgConstantPcdCCW.PCD_TRANSCEIVE, buff); // 发送并接收数据
            if (backLength != 4 || (backData[0] & 0x0F) != 0x0A) {
                success = false;
            } else {
                byte buffWrite[] = new byte[6];
                System.arraycopy(TgConvertUtil.intToByteArray(operand), 0, buffWrite, 0, 4);
                crc = calculateCrc(buffWrite); // 计算  CRC
                if (crc == null) {
                    success = false;
                } else {
                    buffWrite[buffWrite.length - 2] = crc[0]; // 添加CRC到命令数据
                    buffWrite[buffWrite.length - 1] = crc[1]; // 添加CRC到命令数据
                    execute(TgConstantPcdCCW.PCD_TRANSCEIVE, buffWrite); // 发送并接收数据
                }
            }
        }
        return success;
    }

    /**
     * 缓冲区中数据写入块
     *
     * @param address 地址
     */
    public boolean transferBlock(byte address) {
        debugLog("transferBlock: address: %d", address);
        boolean success = true;
        byte buff[] = new byte[4];
        buff[0] = TgConstantPiccCCW.PICC_TRANSFER; // 保存缓冲区中数据命令
        buff[1] = address; // 地址
        byte[] crc = calculateCrc(buff); // 计算  CRC
        if (crc == null) {
            success = false;
        } else {
            buff[2] = crc[0]; // 添加CRC到命令数据
            buff[3] = crc[1]; // 添加CRC到命令数据
            success = execute(TgConstantPcdCCW.PCD_TRANSCEIVE, buff); // 发送并接收数据
        }
        return success;
    }

    /**
     * 调块数据到缓冲区
     *
     * @param address 地址
     */
    public boolean restoreBlock(byte address) {
        debugLog("transferBlock: address: %d", address);
        boolean success = true;
        byte buff[] = new byte[4];
        buff[0] = TgConstantPiccCCW.PICC_RESTORE; // 调块数据到缓冲区命令
        buff[1] = address; // 地址
        byte[] crc = calculateCrc(buff); // 计算  CRC
        if (crc == null) {
            success = false;
        } else {
            buff[2] = crc[0]; // 添加CRC到命令数据
            buff[3] = crc[1]; // 添加CRC到命令数据
            success = execute(TgConstantPcdCCW.PCD_TRANSCEIVE, buff); // 发送并接收数据
            if (backLength != 4 || (backData[0] & 0x0F) != 0x0A) {
                success = false;
            } else {
                byte buffWrite[] = {0, 0, 0, 0, 0, 0};
                crc = calculateCrc(buffWrite); // 计算  CRC
                if (crc == null) {
                    success = false;
                } else {
                    buffWrite[buffWrite.length - 2] = crc[0];
                    buffWrite[buffWrite.length - 1] = crc[1];
                    execute(TgConstantPcdCCW.PCD_TRANSCEIVE, buffWrite); // 发送并接收数据
                }
            }
        }
        return success;
    }

    /**
     * 写有符号的 32-bit Integer 到一个值块
     * 需要提前选择标签并授权
     * Writes a 32-bit signed integer to a value block in the required format
     * The format is specified in section 8.6.2.1 in MIFARE 1k's datasheet
     *
     * @param address 地址
     * @param value   值
     */
    public boolean writeValue(final byte address, final int value) {
        debugLog("writeValue: address: %d, value: %d", address, value);
        byte buffer[] = new byte[16];
        buffer[0] = (byte) (value & 0xFF);
        buffer[1] = (byte) ((value & 0xFF00) >> 8);
        buffer[2] = (byte) ((value & 0xFF0000) >> 16);
        buffer[3] = (byte) ((value & 0xFF000000) >> 24);
        buffer[4] = (byte) ~buffer[0];
        buffer[5] = (byte) ~buffer[1];
        buffer[6] = (byte) ~buffer[2];
        buffer[7] = (byte) ~buffer[3];
        buffer[8] = buffer[0];
        buffer[9] = buffer[1];
        buffer[10] = buffer[2];
        buffer[11] = buffer[3];
        buffer[12] = address;
        buffer[13] = (byte) ~address;
        buffer[14] = address;
        buffer[15] = (byte) ~address;
        return writeBlock(address, buffer);
    }

    /**
     * 读取值块的值并转换成存储值
     *
     * @param address 地址
     * @return 读取失败返回null, 否则返回有符号的 32-bit Integer
     */
    public Integer readValue(byte address) {
        debugLog("readValue: address: %s", address);
        byte buffer[] = new byte[16];
        if (!readBlock(address, buffer)) {
            return null;
        }
        return ((buffer[0] & 0xFF) | ((buffer[1] & 0xFF) << 8) | ((buffer[2] & 0xFF) << 16) | ((buffer[3] & 0xFF) << 24));
    }

    /**
     * 写扇区的尾数据
     * This block contains the access configuration for the entire sector, caution must be taken when
     * modifying its contents as it can lead to inaccessible sectors. Please refer to the tag's documentation
     * Tag must be selected and sector authenticated first
     *
     * @param sector     扇区
     * @param keyA       the new key A that will be set
     * @param accessBits the access bits that will be set.
     * @param userData   a single byte containing user data
     * @param keyB       the new key B that will be set
     * @see <a href="http://www.nxp.com/docs/en/data-sheet/MF1S50YYX_V1.pdf#page=12" target="blank">Reference sheet</a>
     */
    public boolean writeTrailer(byte sector, byte[] keyA, byte[] accessBits, byte userData, byte[] keyB) {
        debugLog("writeTrailer: address: %d, keyA: %s, accessBits: %s, userData: %d, keyB: %s", sector, TgConvertUtil.dataToHexString(keyA), TgConvertUtil.dataToHexString(accessBits), userData, TgConvertUtil.dataToHexString(keyB));
        byte address = getBlockAddress(sector, 3); // 地址
        if (keyA.length != 6 || keyB.length != 6 || accessBits.length != 3) {
            Log.e(TAG, "writeTrailer: Parameter with incorrect length");
            return false;
        }
        byte[] trailer = new byte[16];
        System.arraycopy(keyA, 0, trailer, 0, 6);
        System.arraycopy(accessBits, 0, trailer, 6, 3);
        trailer[9] = userData;
        System.arraycopy(keyB, 0, trailer, 10, 6);
        return writeBlock(address, trailer);
    }

    /**
     * 写数据到地址<br>
     * 写字节数据：也是先串行写目的地址到MOSI引脚，然后同样再串行写数据到MOSI引脚，MSB位为起始发送位。<br>
     * <p>
     * 写操作（主机最先发送字节的最高位为0）：同样首先将NSS拉低，将目标地址字节按数据表中规定的格式进行编码；<br>
     * 然后循环8次将地址发送出去后，再进行8次循环，将所需写入的数据仍通过MOSI发送过去，MFRC522对应地址的字节数据即可实现更新。<br>
     *
     * @param address 地址
     * @param value   值
     */
    private void writeRegister(byte address, byte value) {
        byte buffer[] = new byte[2];
        buffer[0] = (byte) ((address << 1) & 0x7E);
        buffer[1] = value;
        byte response[] = new byte[buffer.length];
        try {
            device.transfer(buffer, response, buffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从地址读数据<br>
     * 读字节数据：主机写地址---先发要读的数据字节地址的MSB位放到MOSI引脚，直到LSB位发完，SCK=1时RC522模块获取MOSI引脚值作为其中一地址位，SCK=0时RC522准备读下一位地址；<br>
     * 主机读数据---写完地址之后即可开始读MISO引脚数据，先从这个引脚读取电平当做数据的MSB位，SCK = 1时，MISO数据保持不变，SCK = 0时，MISO切换到下一位的值。<br>
     * <p>
     * 读操作（主机最先发送字节的最高位为1）：首先将NSS拉低（使能通信），将要读出数据的MFRC522地址字节按数据表规定的格式进行编码；<br>
     * 然后循环8次，按编码后的字节逐位将MOSI线上数据置一或清零；<br>
     * 地址发出去之后，MFRC522收到读命令，会将对应地址值通过MISO发回主机，所以主机只需循环8次，把MISO上的数据逐位读出，存入临时变量中。最后将NSS拉高，一字节的读操作完成。<br>
     *
     * @param address 地址
     */
    public byte readRegister(byte address) {
        byte result = 0; // 结果
        byte buffer[] = new byte[2];
        buffer[0] = (byte) (((address << 1) & 0x7E) | 0x80);
        buffer[1] = 0;
        byte response[] = new byte[buffer.length];
        try {
            device.transfer(buffer, response, buffer.length);
            result = response[1];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 开启或关闭天线
     */
    public void setAntenna(boolean enabled) {
        if (enabled) { // 开启天线
            byte currentState = readRegister(TgConstantRC522Register.REGISTER_TX_CONTROL);
            if ((currentState & 0x03) != 0x03) {
                setBitMask(TgConstantRC522Register.REGISTER_TX_CONTROL, (byte) 0x03); //TX1、TX2输出信号将传递经发送数据调制的13.56MHz的能量载波信号
            }
        } else { // 关闭天线
            clearBitMask(TgConstantRC522Register.REGISTER_TX_CONTROL, (byte) 0x03);
        }
    }

    /**
     * 设置天线增益
     */
    public void setAntennaGain(final RxGain rxGain) {
        clearBitMask(TgConstantRC522Register.REGISTER_RF_CONFIG, (byte) 0x70);
        setBitMask(TgConstantRC522Register.REGISTER_RF_CONFIG, rxGain.getValue());
    }

    /**
     * 设置位掩码
     * This allows turning on only specific bytes of a register without altering the rest
     *
     * @param address 地址
     * @param mask    掩码
     */
    private void setBitMask(byte address, byte mask) {
        byte value = readRegister(address); // 从地址读数据
        writeRegister(address, (byte) (value | mask));
    }

    /**
     * 清除位掩码
     * This allows turning off only specific bytes of a register without altering the rest
     *
     * @param address 地址
     * @param mask    T掩码
     */
    private void clearBitMask(byte address, byte mask) {
        byte value = readRegister(address); // 从地址读数据
        writeRegister(address, (byte) (value & (~mask)));
    }

    /**
     * 执行命令。写数据到FIFO缓存<br>
     * 64字节的FIFO负责缓冲RC522接收(来自主机)和发送的数据。<br>
     * 访问FIFO缓冲区主要通过其内部FIFODataReg寄存器，由于主机一次操作只能是读或者是写，FIFO缓冲区中数据要么就是主机写进去的内容，要不就是主机即将读出来的内容—IC卡片发送给RC522模块的数据。<br>
     * 相关操作：FIFO清除----操作FIFOLevelReg寄存器的bit7-FlushBuffer。查看FIFO中数据量----访问FIFOLevelReg寄存器的FIFOLevel段，主机往FIFODataReg写数据时，FIFOLevel自动加1，相反，减1.<br>
     * 主要状态：空状态警告----FIFO数据空间小于等于WaterLevelReg的WaterLevel值时，Status1Reg的LoAlert置1。满状态警告----FIFO剩余空间小于等于WaterLevelReg的WaterLevel值时，Status1Reg的HiAlert置1
     * Executes a command by writing data to the FIFO buffer and calling the command.
     * It waits for the command to complete and then reads the FIFO buffer again
     *
     * @param command 命令
     * @param data    需要写到 FIFO buffer的数据
     * @return 执行命令后返回的数据
     */
    private boolean execute(byte command, byte[] data) {
        boolean success = false;
        backData = new byte[16];
        backLength = 0;
        byte irq = 0, irqWait = 0, lastBits = 0;
        if (command == TgConstantPcdCCW.PCD_AUTHENT) {  // 验证密钥
            irq = 0x12;
            irqWait = 0x10;
        } else if (command == TgConstantPcdCCW.PCD_TRANSCEIVE) { // 发送并接收数据
            irq = 0x77;
            irqWait = 0x30;
        }
        writeRegister(TgConstantRC522Register.REGISTER_COMMAND, TgConstantPcdCCW.PCD_IDLE); // 取消当前命令
        writeRegister(TgConstantRC522Register.REGISTER_COM_IRQ, (byte) 0x7F);
        writeRegister(TgConstantRC522Register.REGISTER_FIFO_LEVEL, (byte) 0x80);
        writeRegister(TgConstantRC522Register.REGISTER_INTERRUPT_ENABLE, (byte) (irq | 0x80));
        if (data != null && data.length > 0) {
            for (byte d : data) {
                writeRegister(TgConstantRC522Register.REGISTER_FIFO_DATA, d);
            }
        }
        writeRegister(TgConstantRC522Register.REGISTER_COMMAND, command);
        if (command == TgConstantPcdCCW.PCD_TRANSCEIVE) { // 发送并接收数据
            setBitMask(TgConstantRC522Register.REGISTER_BIT_FRAMING, (byte) 0x80);
        }
        long start = System.nanoTime(); // 开始时间
        long end = 0; // 结束时间
        do {
            byte n = readRegister(TgConstantRC522Register.REGISTER_COM_IRQ);
            if ((n & irqWait) != 0) {
                success = true;
                break;
            }
            if ((n & 0x01) != 0) {
                return false;
            }
            end = System.nanoTime();  // 结束时间
        } while (start + 35700000L > end);
        if (success) {
            byte errorValue = readRegister(TgConstantRC522Register.REGISTER_ERROR);
            if ((errorValue & 0x13) != 0) {
                success = false;
            } else {
                clearBitMask(TgConstantRC522Register.REGISTER_BIT_FRAMING, (byte) 0x80);
                if (command == TgConstantPcdCCW.PCD_TRANSCEIVE) { // 发送并接收数据
                    byte n = readRegister(TgConstantRC522Register.REGISTER_FIFO_LEVEL);
                    lastBits = (byte) (readRegister(TgConstantRC522Register.REGISTER_CONTROL) & 0x07);
                    if (lastBits != 0) {
                        backLength = (n - 1) * 8 + lastBits;
                    } else {
                        backLength = n * 8;
                    }
                    if (n == 0) {
                        n = 1;
                    } else if (n > MAX_LENGTH) {
                        n = MAX_LENGTH;
                    }
                    for (byte i = 0; i < n; i++) {
                        backData[i] = readRegister(TgConstantRC522Register.REGISTER_FIFO_DATA);
                        backDataLength = i + 1;
                    }
                }
            }
        }
        return success;
    }

    /**
     * 获得块的地址
     *
     * @param sector 扇区
     * @param block  扇区块
     * @return 块的绝对地址
     */
    public static byte getBlockAddress(byte sector, byte block) {
        if (sector < 0 || sector > 15 || block < 0 || block > 3) {
            return (byte) (-1);
        } else {
            return (byte) (sector * 4 + block);
        }
    }

    /**
     * 获得块的地址
     *
     * @param sector 扇区
     * @param block  扇区块
     */
    public static byte getBlockAddress(int sector, int block) {
        return getBlockAddress((byte) sector, (byte) block);
    }


    /**
     * 导出1K字节,64个扇区
     * Dumps all the data in all data blocks in MIFARE 1K cards with default authentication keys.
     * Card must be selected using {@link #selectTag(byte[])} before
     * This won't work if a sector's KEY A or access bits have been changed
     *
     * @return string containing all the data
     */
    public String dumpMifare1k() {
        byte[] key = {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF};
        StringBuilder sb = new StringBuilder();
        for (byte i = 0; i <= 15; i++) {
            for (byte j = 0; j <= 3; j++) {
                sb.append("S").append(i).append("B").append(j).append(": ");
                byte block = getBlockAddress(i, j);
                byte[] buffer = new byte[16];
                boolean success = authenticateCard(TgConstantAuthTypes.AUTH_A, block, key);
                if (!success) {
                    sb.append("Could not authenticate\n");
                    continue;
                }
                success = readBlock(block, buffer);
                if (!success) {
                    sb.append("Could not read");
                } else {
                    sb.append(TgConvertUtil.dataToHexString(buffer));
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /**
     * 获得最后成功读取的卡的UID，没如果没有卡读取返回空<br>
     * UID即卡的SN(4Bytes)+校验(1Byte)
     */
    public byte[] getUid() {
        return uid;
    }

    /**
     * 读取的标签的UID字符串，用separator分隔<br>
     * UID即卡的SN(4Bytes)+校验(1Byte)
     */
    public String getUidString(final String separator) {
        return TgRc522Util.getUidString(this.uid, separator);
    }

    /**
     * 读取的标签的UID字符串，用"-"分隔<br>
     * UID即卡的SN(4Bytes)+校验(1Byte)
     */
    public String getUidString() {
        return TgRc522Util.getUidString(this.uid);
    }

    /**
     * 获得最后的错误
     */
    public ErrorType getError() {
        return error;
    }

    private void debugLog(String message) {
        if (debugging) {
            Log.d(TAG, message);
        }
    }

    private void debugLog(String format, Object... args) {
        debugLog(String.format(format, args));
    }

    /**
     * Enum that defines possible values in decibels for RxGain bits on the RFCfgReg register
     */
    public enum RxGain {
        DB_18(0x0),
        DB_23(0b1 << 4),
        DB_33(0b100 << 4),
        DB_38(0b101 << 4),
        DB_43(0b110 << 4),
        DB_48(0b111 << 4);

        private byte value;

        RxGain(int i) {
            value = (byte) i;
        }

        public byte getValue() {
            return value;
        }
    }

    /**
     * Enum of possible error types
     */
    enum ErrorType {
        ERROR_TIMEOUT
    }
}
