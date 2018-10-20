package com.turingoal.android.things.rfid;

/**
 * RC522芯片的操作命令。<br>
 * MFRC522 commands, found in Table 149, page 70<br>
 * PCD是接近式耦合设备.<br>
 * 在通信过程中实际上是使用PCD命令控制RC522发出PICC命令与卡进行交互。<br>
 */
public interface TgConstantPcdCCW {
    byte PCD_IDLE = 0x00; // 取消当前命令
    byte PCD_CALCULATE_CRC = 0x03; // CRC计算
    byte PCD_TRANSMIT = 0x04; // 发送数据
    byte PCD_RECEIVE = 0x08; // 接收数据
    byte PCD_TRANSCEIVE = 0x0C; // 发送并接收数据
    byte PCD_AUTHENT = 0x0E; // 验证密钥
    byte PCD_RESETPHASE = 0x0F; // 复位
}