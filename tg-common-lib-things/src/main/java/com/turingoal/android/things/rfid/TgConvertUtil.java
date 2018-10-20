package com.turingoal.android.things.rfid;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;

/**
 * 字节转换工具类
 */
public class TgConvertUtil {

    /**
     * string2Object
     */
    public static Object string2Object(String strValue, int type) {
        Object value = null;
        switch (type) {
            case Types.INTEGER:
                value = Integer.parseInt(strValue);
                break;
            case Types.VARCHAR:
            case Types.CHAR:
            case Types.NVARCHAR:
                value = strValue;
                break;
            case Types.DOUBLE:
                value = Double.parseDouble(strValue);
                break;
            case Types.FLOAT:
                value = Float.parseFloat(strValue);
                break;
            case Types.BOOLEAN:
                value = Boolean.parseBoolean(strValue);
                break;
            case Types.DATE:
                value = Date.valueOf(strValue);
                break;
            case Types.DECIMAL:
            case Types.NUMERIC:
                value = new BigDecimal(strValue);
                break;
            case Types.BIGINT:
                value = new BigInteger(strValue);
                break;
            case Types.TIMESTAMP:
                value = Timestamp.valueOf(strValue);
                break;
            case Types.TIME:
                value = Time.valueOf(strValue);
                break;
            case Types.SMALLINT:
                value = Integer.parseInt(strValue);
                break;
            case Types.LONGVARCHAR:
            case Types.LONGNVARCHAR:
                value = strValue;
                break;
        }
        return value;
    }

    /**
     * dataToHexString
     */
    public static String dataToHexString(byte[] bytes) {
        final char[] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for (int j = 0, length = bytes.length; j < length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    /**
     * Converts a 32-bit signed integer into a 4-byte array
     *
     * @param value value to be converted
     * @return byte array
     */
    public static byte[] intToByteArray(int value) {
        return new byte[]{
                (byte) (value & 0xFF),
                (byte) ((value & 0xFF00) >> 8),
                (byte) ((value & 0xFF0000) >> 16),
                (byte) ((value & 0xFF000000) >> 24)
        };
    }
}
