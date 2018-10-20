package com.turingoal.common.android.util.net;

import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.locator.BaseLocator;
import com.serotonin.modbus4j.msg.ModbusResponse;
import com.serotonin.modbus4j.msg.WriteCoilRequest;
import com.serotonin.modbus4j.msg.WriteCoilResponse;
import com.serotonin.modbus4j.msg.WriteCoilsRequest;
import com.serotonin.modbus4j.msg.WriteCoilsResponse;
import com.serotonin.modbus4j.msg.WriteRegisterRequest;
import com.serotonin.modbus4j.msg.WriteRegisterResponse;
import com.serotonin.modbus4j.msg.WriteRegistersRequest;
import com.serotonin.modbus4j.sero.util.queue.ByteQueue;
import com.turingoal.common.android.util.system.TgLogUtil;

import java.math.BigInteger;
import java.text.DecimalFormat;

/**
 * Modbus4jUtil。普通地址从0开始，PLC地址从1开始，读写PLC地址发送的offset需要减1
 */
public final class TgModbus4jUtil {
    public static final int BYTE_QUEUE_INIT_SIZE = 12;
    public static final int HEX = 16;

    private TgModbus4jUtil() {
        throw new Error("工具类不能实例化");
    }

    /**
     * 获取TcpMaster
     */
    public static ModbusMaster getTcpMaster(final String ip, final int port) throws ModbusInitException {
        IpParameters params = new IpParameters();
        params.setHost(ip);
        params.setPort(port);
        ModbusMaster master = new ModbusFactory().createTcpMaster(params, false);
        master.setTimeout(1000); // 超时时间
        master.setRetries(3); // 重试次数
        master.init();
        return master;
    }

    /**
     * 获取RtuOverTcpMaster
     */
    public static ModbusMaster getRtuOverTcpMaster(final String ip, final int port) throws ModbusInitException {
        IpParameters params = new IpParameters();
        params.setHost(ip);
        params.setPort(port);
        params.setEncapsulated(true); // 加上这一行传输的时候就用的rtu格式
        ModbusMaster master = new ModbusFactory().createTcpMaster(params, false); // true的话保持连接激活
        master.setTimeout(1000); // 超时时间
        master.setRetries(3); // 重试次数
        master.init();
        return master;
    }

    /**
     * 获取UdpMaster
     */
    public static ModbusMaster getUdpMaster(final String ip, final int port) throws ModbusInitException {
        IpParameters params = new IpParameters();
        params.setHost(ip);
        params.setPort(port);
        ModbusMaster master = new ModbusFactory().createUdpMaster(params);
        master.setTimeout(1000); // 超时时间
        master.setRetries(3); // 重试次数
        master.init();
        return master;
    }

    /**
     * 获取RtuOverUdpMaster
     */
    public static ModbusMaster getRtuOverUdpMaster(final String ip, final int port) throws ModbusInitException {
        IpParameters params = new IpParameters();
        params.setHost(ip);
        params.setPort(port);
        params.setEncapsulated(true); // 加上这一行传输的时候就用的rtu格式
        ModbusMaster master = new ModbusFactory().createUdpMaster(params);
        master.setTimeout(1000); // 超时时间
        master.setRetries(3); // 重试次数
        master.init();
        return master;
    }

    /**
     * 功能码：01，读取线圈状态，寄存器PLC地址：00001-09999，位操作，单个或多个，类型：开关数据。<br/>
     * 本功能可使主站获得被编址从站的开关量输出的通断状态。起始地址是指从哪一路开关量开始（编号从 0开始），数据线圈数是指读取几路。应答帧中的数据是按上述要求读取的开关量数据(每路一位,每8位 组成一个字节，最后一个字节的不足部分补0). <br/>
     * 指令：从站地址+功能码（01）+起始地址高位 起始地址低位+数据线圈数高位 数据线圈数低位（由于这里只查一个地址，所以为 00 01）+校验和CRC。如：03 01 01 8D 00 01 6D FF （397 转16进制为：01 8D）<br/>
     * 响应：从站地址+功能码（01）+ 字节计数（由于这里只查一个地址，多个地址除以8，不足的补齐，所以这里为01）+数据（由于这里只查询一个地址，所以只返回一个字节）+校验和CRC。如：03 01 01 00 50 30
     *
     * @param slaveId slaveId
     * @param offset  位置
     * @return 读取值
     * @throws ModbusTransportException 异常
     * @throws ErrorResponseException   异常
     * @throws ModbusInitException      异常
     */
    public static Boolean readCoilStatus(final ModbusMaster master, final int slaveId, final int offset) throws ModbusTransportException, ErrorResponseException, ModbusInitException {
        BaseLocator<Boolean> loc = BaseLocator.coilStatus(slaveId, offset); // 01 Coil Status
        Boolean value = master.getValue(loc);
        return value;
    }

    /**
     * 功能码：02，读离散输入状态，寄存器PLC地址：10001-19999，位操作，单个或多个，类型：开关数据。<br/>
     * 本功能可使主站获得被编址从站的开关量输入的通断状态。起始地址是指从哪一路开关量开始(编号从 0开始)，数据线圈数是指读取几路。应答帧中的数据是按上述要求读取的开关量数据(每路一位，每8位 组成一个字节，最后一个字节的不足部分补0).<br/>
     * 指令：从站地址+功能码（02）+起始地址高位 起始地址低位+数据线圈数高位 数据线圈数低位（由于这里只查一个地址，所以为 00 01）+校验和CRC。如：03 02 01 8D 00 01 29 FF （397 转16进制为：01 8D）<br/>
     * 响应：从站地址+功能码（02）+ 字节计数（由于这里只查一个地址，多个地址除以8，不足的补齐，所以这里为01）+数据（由于这里只查询一个地址，所以只返回一个字节）+校验和CRC。如：03 02 01 00 A0 30
     *
     * @param slaveId
     * @param offset
     * @return
     * @throws ModbusTransportException
     * @throws ErrorResponseException
     * @throws ModbusInitException
     */
    public static Boolean readInputStatus(final ModbusMaster master, final int slaveId, final int offset) throws ModbusTransportException, ErrorResponseException, ModbusInitException {
        BaseLocator<Boolean> loc = BaseLocator.inputStatus(slaveId, offset); // 02 Input Status
        Boolean value = master.getValue(loc);
        return value;
    }

    /**
     * 功能码：03，读保持寄存器，寄存器PLC地址：40001-49999，字操作，单个或多个，类型：模拟量数据。<br/>
     * 本功能可使主站获得被编址从站的模拟量输出的通断状态。起始地址是指从哪一路模拟量开始（编号从 0开始），寄存器数是指读取几路模拟量（每路模拟量2个字节，高位在前，低位在后）。应答帧中的数 据是按上述要求读取的模拟量数据。<br/>
     * 指令：从站地址+功能码（03）+起始地址高位 起始地址低位+寄存器数高位 寄存器数低位（根据查询数据类型DataType计算，TWO_BYTE_INT_SIGNED 寄存器数为1，FOUR_BYTE_INT_SIGNED为2）+校验和CRC。如：03 03 01 8D 00 02 54 3E （397 转16进制为：01 8D，FOUR_BYTE_INT_SIGNED为00 02）<br/>
     * 响应：从站地址+功能码（03）+ 字节计数（根据查询数据类型DataType计算，TWO_BYTE_INT_SIGNED 字节数为2，FOUR_BYTE_INT_SIGNED为41）+数据（根据查询数据类型返回字节）+校验和CRC。如：03 03 04 73 56 FF E5 A3 1C ，返回值为1935081445。
     *
     * @param slaveId  slave Id
     * @param offset   位置
     * @param dataType 数据类型,来自com.serotonin.modbus4j.code.DataType. DataType.TWO_BYTE_INT_SIGNED 寄存器数为1，应答字节为2，以此类推。需要根据具体类型选择不然会出错<br/>
     *                 四字节的默认：AB CD，SWAPPED：CD AB，INVERTED：DC BA， 八字节的类似
     * @return
     * @throws ModbusTransportException 异常
     * @throws ErrorResponseException   异常
     * @throws ModbusInitException      异常
     */
    public static Number readHoldingRegister(final ModbusMaster master, final int slaveId, final int offset, final int dataType) throws ModbusTransportException, ErrorResponseException, ModbusInitException {
        // 03 Holding Register类型数据读取
        BaseLocator<Number> loc = BaseLocator.holdingRegister(slaveId, offset, dataType);
        Number value = master.getValue(loc);
        return value;
    }

    /**
     * 功能码：04，读输入寄存器，寄存器PLC地址：30001-39999，字操作，单个或多个，类型：模拟量数据。<br/>
     * 本功能可使主站获得被编址从站的模拟量输出的通断状态。起始地址是指从哪一路模拟量开始（编号从 0开始），寄存器数是指读取几路模拟量（每路模拟量2个字节，高位在前，低位在后）。应答帧中的数 据是按上述要求读取的模拟量数据。<br/>
     * 指令：从站地址+功能码（04）+起始地址高位 起始地址低位+寄存器数高位 寄存器数低位（根据查询数据类型DataType计算，TWO_BYTE_INT_SIGNED 寄存器数为1，FOUR_BYTE_INT_SIGNED为2）+校验和CRC。如：03 04 01 8D 00 02 E1 FE （397 转16进制为：01 8D，FOUR_BYTE_INT_SIGNED为00 02）<br/>
     * 响应：从站地址+功能码（04）+ 字节计数（根据查询数据类型DataType计算，TWO_BYTE_INT_SIGNED 字节数为2，FOUR_BYTE_INT_SIGNED为41）+数据（根据查询数据类型返回字节）+校验和CRC。如：03 04 04 73 56 FF E5 A2 AB ，返回值为1935081445。
     *
     * @param slaveId  slaveId
     * @param offset   位置
     * @param dataType 数据类型,来自com.serotonin.modbus4j.code.DataType。四字节的默认：AB CD，SWAPPED：CD AB，INVERTED：DC BA， 八字节的类似
     * @return 返回结果
     * @throws ModbusTransportException 异常
     * @throws ErrorResponseException   异常
     * @throws ModbusInitException      异常
     */
    public static Number readInputRegisters(final ModbusMaster master, final int slaveId, final int offset, final int dataType) throws ModbusTransportException, ErrorResponseException, ModbusInitException {
        // 04 Input Registers类型数据读取
        BaseLocator<Number> loc = BaseLocator.inputRegister(slaveId, offset, dataType);
        Number value = master.getValue(loc);
        return value;
    }

    /**
     * 功能码：05，写单个线圈，寄存器PLC地址：00001-09999，位操作，单个<br/>
     * 本功能可使主站强行设定被编址从站某路开关量输出的通断状态。从站内部的任何一路开关量均能被强 制。起始地址是指设定开关量的哪一路（编号从0开始），数据用于设定开或关：FF为开，0为关，其他 值为非法值。正常应答是将报文原文发回。<br/>
     * 指令：从站地址+功能码（05）+起始地址高位 起始地址低位+数据（FF为开，00为关，其他 值为非法值）+开关原状态+校验和CRC。如：03 05 01 8D FF 00 1C 0F （397 转16进制为：01 8D, true为FF）<br/>
     * 响应：正常应答是将报文原文发回。
     *
     * @param slaveId     slave的ID
     * @param writeOffset 位置
     * @param writeValue  值
     * @return 是否写入成功
     * @throws ModbusTransportException
     * @throws ModbusInitException
     */
    public static boolean writeCoil(final ModbusMaster master, final int slaveId, final int writeOffset, final boolean writeValue) throws ModbusTransportException, ModbusInitException {
        WriteCoilRequest request = new WriteCoilRequest(slaveId, writeOffset, writeValue); // 创建请求
        WriteCoilResponse response = (WriteCoilResponse) master.send(request); // 发送请求并获取响应对象
        TgLogUtil.d("功能码:" + request.getFunctionCode() + " " + "从站地址:" + request.getSlaveId());
        ByteQueue byteQueue = new ByteQueue(BYTE_QUEUE_INIT_SIZE);
        response.write(byteQueue);
        TgLogUtil.d("收到的响应信息大小:" + byteQueue.size() + " " + "收到的响应信息值:" + byteQueue);
        if (response.isException()) {
            TgLogUtil.e(response.getExceptionMessage());
            return false;
        } else {
            return true;
        }
    }

    /**
     * 功能码：15，写多个线圈，寄存器PLC地址：00001-09999，位操作，多个<br/>
     * 本功能可使主站强行设定被编址从站一组连续开关量输出的通断状态。从站内部的任何开出量均能被强 制。起始地址是从哪一路开关量开始（编号从0开始），寄存器数是指设定几路。字节计数是指随后的 线圈状态（开关量设定值）的字节数。线圈状态是设定的开出值，每一路开出占用一位（1为开，0为 关），从右至左每八位组成一个字节，字节从左至右，最后一个字节的不足部分补0。正常应答内容是回送从站地址、功能码、 起始地址和强置的开关量数。<br/>
     * 指令：从站地址+功能码（15，既0F）+起始地址高位 起始地址低位+寄存器数高位 寄存器数低位+字节计数+数据(1为true，0为 false，每八位组成一个字节，最后一个字节的不足部分补0)+校验和CRC。如：03 0F 01 8D 00 03 01 05 E3 43 （397 转16进制为：01 8D，5为00000101,位从右至左，多个字节的话字节从左至右）<br/>
     * 响应：从站地址+功能码（15，既0F）+起始地址高位 起始地址低位+寄存器数高位 寄存器数低位+校验和CRC。如：03 0F 01 8D 00 03 E3 43 （397 转16进制为：01 8D，FOUR_BYTE_INT_SIGNED为00 02）<br/>
     *
     * @param slaveId     slaveId
     * @param startOffset 开始位置
     * @param bdata       写入的数据
     * @return 是否写入成功
     * @throws ModbusTransportException
     * @throws ModbusInitException
     */
    public static boolean writeCoils(final ModbusMaster master, final int slaveId, final int startOffset, final boolean[] bdata) throws ModbusTransportException, ModbusInitException {
        WriteCoilsRequest request = new WriteCoilsRequest(slaveId, startOffset, bdata); // 创建请求
        WriteCoilsResponse response = (WriteCoilsResponse) master.send(request); // 发送请求并获取响应对象
        TgLogUtil.d("功能码:" + request.getFunctionCode() + " " + "从站地址:" + request.getSlaveId());
        ByteQueue byteQueue = new ByteQueue(BYTE_QUEUE_INIT_SIZE);
        response.write(byteQueue);
        TgLogUtil.d("收到的响应信息大小:" + byteQueue.size() + " " + "收到的响应信息值:" + byteQueue);
        if (response.isException()) {
            TgLogUtil.e(response.getExceptionMessage());
            return false;
        } else {
            return true;
        }
    }

    /***
     * 功能码：6，写单个保持寄存器，寄存器PLC地址：40001-49999，字操作，单个<br/>
     * 本功能可使主站强行设定被编址从站某路模拟量输出的值。从站内部的任何一路模拟量均能被强制。起 始地址是指设定哪一路模拟量(编号从0开始)，数据用于设定该模拟量的值(高位在前，低位在 后)。正常应答是将报文原文发回。<br/>
     * 指令：从站地址+功能码（05）+起始地址高位 起始地址低位+数据高位 数据低位+校验和CRC。如：03 06 01 8D 0B 51 DF 33 （397 转16进制为：01 8D, 数据2897为0B 51）<br/>
     * 响应：正常应答是将报文原文发回。
     *
     * @param slaveId
     * @param writeOffset
     * @param writeValue
     * @return
     * @throws ModbusTransportException
     * @throws ModbusInitException
     */
    public static boolean writeRegister(final ModbusMaster master, final int slaveId, final int writeOffset, final int writeValue) throws ModbusTransportException, ModbusInitException {
        WriteRegisterRequest request = new WriteRegisterRequest(slaveId, writeOffset, writeValue);  // 创建请求对象
        WriteRegisterResponse response = (WriteRegisterResponse) master.send(request);
        TgLogUtil.d("功能码:" + request.getFunctionCode() + " " + "从站地址:" + request.getSlaveId());
        ByteQueue byteQueue = new ByteQueue(BYTE_QUEUE_INIT_SIZE);
        response.write(byteQueue);
        TgLogUtil.d("收到的响应信息大小:" + byteQueue.size() + " " + "收到的响应信息值:" + byteQueue);
        if (response.isException()) {
            TgLogUtil.e(response.getExceptionMessage());
            return false;
        } else {
            return true;
        }
    }

    /**
     * 功能码：16，写多个保持寄存器，寄存器PLC地址：40001-49999，字操作，多个<br/>
     * 本功能可使主站强行设定被编址从站一组连续模拟量输出的值。从站内部的任何模出量均能被强制。起 始地址是从哪一路模拟量开始（编号从0开始），寄存器数是指设定几路。字节计数是指随后的数据 （模拟量设定值）的字节数。数据是设定的模出值，每一路模出两个字节（高位在前，低位在后）。正 常应答内容是回送从站地址、功能码、起始地址和强置的模拟量数。<br/>
     * 指令：从站地址+功能码（16，既10）+起始地址高位 起始地址低位+寄存器数高位 寄存器数低位+字节计数(每一路数据2个字节)+数据(每一路数据2个字节)+校验和CRC。如：03 10 01 8D 00 03 06 FF FD 00 03 01 66 7B 4D（397 转16进制为：01 8D，3路数据，6个字节）<br/>
     * 响应：从站地址+功能码（16，既10）+起始地址高位 起始地址低位+寄存器数高位 寄存器数低位+校验和CRC。如：03 10 01 8D 00 03 7B 4D<br/>
     *
     * @param slaveId     modbus的slaveID
     * @param startOffset 起始位置偏移量值
     * @param sdata       写入的数据
     * @return 返回是否写入成功
     * @throws ModbusTransportException
     * @throws ModbusInitException
     */
    public static boolean writeRegisters(final ModbusMaster master, final int slaveId, final int startOffset, final short[] sdata) throws ModbusTransportException, ModbusInitException {
        WriteRegistersRequest request = new WriteRegistersRequest(slaveId, startOffset, sdata);  // 创建请求对象
        ModbusResponse response = master.send(request); // 发送请求并获取响应对象
        TgLogUtil.d("功能码:" + request.getFunctionCode() + " " + "从站地址:" + request.getSlaveId());
        ByteQueue byteQueue = new ByteQueue(BYTE_QUEUE_INIT_SIZE);
        response.write(byteQueue);
        TgLogUtil.d("收到的响应信息大小:" + byteQueue.size() + " " + "收到的响应信息值:" + byteQueue);
        if (response.isException()) {
            TgLogUtil.e(response.getExceptionMessage());
            return false;
        } else {
            return true;
        }
    }

    /**
     * 销毁
     */
    public static void destroy(final ModbusMaster master) {
        master.destroy();
    }

    /**
     * short 10进制转4位数的16进制
     */
    public static String short2Hex4Nums(final short shortValue) {
        String result = short2Hex(shortValue); // short转成16进制
        if (result.length() == 1) {
            result = "000" + result;
        } else if (result.length() == 2) {
            result = "00" + result;
        } else if (result.length() == 3) {
            result = "0" + result;
        }
        return result;
    }

    /**
     * int 10进制转16进制
     */
    public static String int2Hex(final int intValue) {
        return Integer.toHexString(intValue);
    }

    /**
     * short 10进制转16进制
     */
    public static String short2Hex(final short shortValue) {
        return Integer.toHexString(shortValue & 0xffff); // java没有提供Short.toHexString, 所以这样处理
    }

    /**
     * 16进制转10进制 int
     */
    public static int hex2Int(final String hexValue) {
        // return Integer.parseUnsignedInt(hexValue, HEX); // android API 26 以上才可以使用
        return new BigInteger(hexValue, HEX).intValue();
    }

    /**
     * 16进制转10进制 short
     */
    public static int hex2Short(final String hexValue) {
        // return Short.parseUnsignedShort(hexValue, HEX); // android API 26 以上才可以使用
        return new BigInteger(hexValue, HEX).shortValue();
    }

    /**
     * 高位地位分离转short，如时间18:59，18和59分别转成12、3B，123B转为int 4667。
     */
    public static int twoByteHexSplit2ShortValue(final short high, final short low) {
        String highHex = short2Hex(high);
        String lowHex = short2Hex(low);
        if (lowHex.length() == 1) {
            lowHex = "0" + lowHex;
        }
        return hex2Short(highHex + lowHex);
    }

    /**
     * 保留小数位工具
     *
     * @param number    需要保留的数字
     * @param precision 需要保留的位数
     * @return 返回处理好的数字
     */
    public static String keepPrecision(final float number, final int precision) {
        StringBuffer pattern = new StringBuffer("0.");
        for (int i = 0; i < precision; i++) {
            pattern.append("0");
        }
        DecimalFormat df = new DecimalFormat(pattern.toString());
        return df.format(number);
    }

    /**
     * 测试
     */
    // public static void main(final String[] args) {
    // try {
    // 01测试
    // ModbusMaster master = getMaster("192.168.1.109", 502);
    // Boolean v011 = readCoilStatus(master, 1, 0);
    // Boolean v012 = readCoilStatus(master, 1, 1);
    // Boolean v013 = readCoilStatus(master, 1, 6);
    // System.out.println("v011:" + v011);
    // System.out.println("v012:" + v012);
    // System.out.println("v013:" + v013);
    // 02测试
    // Boolean v021 = readInputStatus(master, 1, 0);
    // Boolean v022 = readInputStatus(master, 1, 1);
    // Boolean v023 = readInputStatus(master, 1, 2);
    // System.out.println("v021:" + v021);
    // System.out.println("v022:" + v022);
    // System.out.println("v023:" + v023);
    // 03测试
    // Number v031 = readHoldingRegister(1, 1, DataType.FOUR_BYTE_FLOAT);// 注意,float
    // Number v032 = readHoldingRegister(1, 3, DataType.FOUR_BYTE_FLOAT);// 同上
    // System.out.println("v031:" + v031);
    // System.out.println("v032:" + v032);
    // 04测试
    // Number v041 = readInputRegisters(1, 1, DataType.FOUR_BYTE_FLOAT);//
    // Number v042 = readInputRegisters(1, 3, DataType.FOUR_BYTE_FLOAT);//
    // System.out.println("v041:" + v041);
    // System.out.println("v042:" + v042);
    // 批量读取
    // batchRead();
    // destroy(master); // 销毁
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // // 测试01
    // boolean t01 = writeCoil(1, 0, true);
    // System.out.println("T01:" + t01);
    //
    // // 测试02
    // boolean t02 = writeCoils(1, 0, new boolean[] { true, false, true });
    // System.out.println("T02:" + t02);
    //
    // // 测试03
    // short v = -3;
    // boolean t03 = writeRegister(1, 0, v);
    // System.out.println("T03:" + t03);
    // // 测试04
    // boolean t04 = writeRegisters(1, 0, new short[] { -3, 3, 9 });
    // System.out.println("t04:" + t04);
    // 批量读取使用方法
    // BatchRead<Integer> batch = new BatchRead<Integer>();
    // batch.addLocator(0, BaseLocator.holdingRegister(1, 1, DataType.FOUR_BYTE_FLOAT));
    //// batch.setContiguousRequests(false);
    // BatchResults<Integer> results = master.send(batch);
    // System.out.println(results.getValue("hr1"));
    // System.out.println(results.getValue("hr2"));
    // }
}
