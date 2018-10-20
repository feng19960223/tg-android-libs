package com.turingoal.android.things.rfid;

/**
 * PICC命令字<br>
 * Mifare_One卡片命令字<br>
 * PICC是接近式卡(分为A型和B型)。<br>
 * 在通信过程中实际上是使用PCD命令控制RC522发出PICC命令与卡进行交互。<br>
 */
public interface TgConstantPiccCCW {
    byte PICC_REQIDL = 0x26; // 寻天线区内未进入休眠状态。读取完卡后还会再次读取。（除非在某次读取完成后系统进入休眠（Halt））
    byte PICC_REQALL = 0x52; // 寻天线区内全部卡。读取完卡后会等待卡离开开线作用范围，直到再次进入
    byte PICC_ANTICOLL = (byte) 0x93; // 防冲撞
    byte PICC_SElECTTAG = (byte) 0x93; // 选卡
    byte PICC_AUTHENT1A = 0x60; // 验证A密钥
    byte PICC_AUTHENT1B = 0x61; // 验证B密钥
    byte PICC_READ = 0x30; // 读块。读（Read）：读一个块；
    byte PICC_WRITE = (byte) 0xA0; // 写块。写（Write）：写一个块；
    byte PICC_DECREMENT = (byte) 0xC0; // 扣款。减值（Decrement）：对数值块进行减值；
    byte PICC_INCREMENT = (byte) 0xC1; // 充值。加值（Increment）：对数值块进行加值；
    byte PICC_RESTORE = (byte) 0xC2; // 调块数据到缓冲区。存储（Restore）：将块中数据保存到数据寄存器中；
    byte PICC_TRANSFER = (byte) 0xB0; // 保存缓冲区中数据。传输（Transfer）：将数据寄存器中内容写入到块中；
    byte PICC_HALT = 0x50; // 休眠。终止（Halt）：将卡置于暂停工作状体。
}













