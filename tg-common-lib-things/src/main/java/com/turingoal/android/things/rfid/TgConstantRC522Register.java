package com.turingoal.android.things.rfid;


public interface TgConstantRC522Register {
    byte Reserved00 = 0x00;
    byte CommandReg = 0x01;
    byte CommIEnReg = 0x02;
    byte DivlEnReg = 0x03;
    byte CommIrqReg = 0x04;
    byte DivIrqReg = 0x05;
    byte ErrorReg = 0x06;
    byte Status1Reg = 0x07;
    byte Status2Reg = 0x08;
    byte FIFODataReg = 0x09;
    byte FIFOLevelReg = 0x0A;
    byte WaterLevelReg = 0x0B;
    byte ControlReg = 0x0C;
    byte BitFramingReg = 0x0D;
    byte CollReg = 0x0E;
    byte Reserved01 = 0x0F;

    byte Reserved10 = 0x10;
    byte ModeReg = 0x11;
    byte TxModeReg = 0x12;
    byte RxModeReg = 0x13;
    byte TxControlReg = 0x14;
    byte TxAutoReg = 0x15;
    byte TxSelReg = 0x16;
    byte RxSelReg = 0x17;
    byte RxThresholdReg = 0x18;
    byte DemodReg = 0x19;
    byte Reserved11 = 0x1A;
    byte Reserved12 = 0x1B;
    byte MifareReg = 0x1C;
    byte Reserved13 = 0x1D;
    byte Reserved14 = 0x1E;
    byte SerialSpeedReg = 0x1F;

    byte Reserved20 = 0x20;
    byte CRCResultRegM = 0x21;
    byte CRCResultRegL = 0x22;
    byte Reserved21 = 0x23;
    byte ModWidthReg = 0x24;
    byte Reserved22 = 0x25;
    byte RFCfgReg = 0x26;
    byte GsNReg = 0x27;
    byte CWGsPReg = 0x28;
    byte ModGsPReg = 0x29;
    byte TModeReg = 0x2A;
    byte TPrescalerReg = 0x2B;
    byte TReloadRegH = 0x2C;
    byte TReloadRegL = 0x2D;
    byte TCounterValueRegH = 0x2E;
    byte TCounterValueRegL = 0x2F;

    byte Reserved30 = 0x30;
    byte TestSel1Reg = 0x31;
    byte TestSel2Reg = 0x32;
    byte TestPinEnReg = 0x33;
    byte TestPinValueReg = 0x34;
    byte TestBusReg = 0x35;
    byte AutoTestReg = 0x36;
    byte VersionReg = 0x37;
    byte AnalogTestReg = 0x38;
    byte TestDAC1Reg = 0x39;
    byte TestDAC2Reg = 0x3A;
    byte TestADCReg = 0x3B;
    byte Reserved31 = 0x3C;
    byte Reserved32 = 0x3D;
    byte Reserved33 = 0x3E;
    byte Reserved34 = 0x3F;


    /* Found in table 20, page 36 */
    byte REGISTER_COMMAND = 0x01; //CommandReg
    byte REGISTER_INTERRUPT_ENABLE = 0x02; //ComIEnReg
    byte REGISTER_COM_IRQ = 0x04; // DivIEnReg
    byte REGISTER_DIV_IRQ = 0x05; //ComIrqReg
    byte REGISTER_ERROR = 0x06; //ErrorReg
    byte REGISTER_COMMUNICATION_STATUS = 0x07; //Status1Reg
    byte REGISTER_RXTX_STATUS = 0x08; //Status2Reg
    byte REGISTER_FIFO_DATA = 0x09; //FIFODataReg
    byte REGISTER_FIFO_LEVEL = 0x0A; //FIFOLevelReg
    byte REGISTER_CONTROL = 0x0C; //ControlReg
    byte REGISTER_BIT_FRAMING = 0x0D; //BitFramingReg
    byte REGISTER_MODE = 0x11; //ModeReg
    byte REGISTER_TX_CONTROL = 0x14; //TxControlReg
    byte REGISTER_TX_MODE = 0x15; //TxASKReg
    byte REGISTER_CRC_RESULT_HIGH = 0x21; //CRCResultReg
    byte REGISTER_CRC_RESULT_LOW = 0x22; //CRCResultReg
    byte REGISTER_RF_CONFIG = 0x26; //RFCfgReg
    byte REGISTER_TIMER_MODE = 0x2A; //TModeReg
    byte REGISTER_TIMER_PRESCALER_MODE = 0x2B; //TPrescalerReg
    byte REGISTER_TIMER_RELOAD_HIGH = 0x2C; //TReloadReg
    byte REGISTER_TIMER_RELOAD_LOW = 0x2D; //TReloadReg
}
