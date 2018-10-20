package com.turingoal.android.things.rfid;

/**
 * RC522工具类
 */
public class TgRc522Util {
    /**
     * 读取的标签的UID字符串，用separator分隔
     */
    public static String getUidString(final byte[] uid, final String separator) {
        if (uid == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String prefix = "";
        for (byte b : uid) {
            int ubyte = b & 0xff;
            if (ubyte == 0) {
                break;
            }
            sb.append(prefix);
            prefix = separator;
            sb.append(ubyte);
        }
        return sb.toString();
    }

    /**
     * 读取的标签的UID字符串，用"-"分隔
     */
    public static String getUidString(final byte[] uid) {
        return getUidString(uid, "-");
    }

    /***
     * Calculates the access bits for a sector trailer (bytes 6 to 7) based on Table 6 and Table 7
     * on MIFARE 1k's reference
     * @see <a href="http://www.nxp.com/docs/en/data-sheet/MF1S50YYX_V1.pdf#page=12" target="blank">Reference sheet</a>
     * @param c1 byte array for the c1 values for block 0, 1, 2 and 3 respectively
     * @param c2 byte array for the c2 values for block 0, 1, 2 and 3 respectively
     * @param c3 byte array for the c3 values for block 0, 1, 2 and 3 respectively
     * @return a 3 byte array containing the access bits
     */
    public static byte[] calculateAccessBits(byte[] c1, byte[] c2, byte[] c3) {
        byte[] accessBits = new byte[3];
        try {
            // Byte 6
            accessBits[0] = (byte) (
                    ((~c2[3] & 1) << 7) + ((~c2[2] & 1) << 6) + ((~c2[1] & 1) << 5) +
                            ((~c2[0] & 1) << 4) + ((~c1[3] & 1) << 3) + ((~c1[2] & 1) << 2) +
                            ((~c1[1] & 1) << 1) + (~c1[0] & 1)
            );
            // Byte 7
            accessBits[1] = (byte) (
                    ((c1[3] & 1) << 7) + ((c1[2] & 1) << 6) + ((c1[1] & 1) << 5) +
                            ((c1[0] & 1) << 4) + ((~c3[3] & 1) << 3) + ((~c3[2] & 1) << 2) +
                            ((~c3[1] & 1) << 1) + (~c3[0] & 1)
            );
            // Byte 7
            accessBits[2] = (byte) (
                    ((c3[3] & 1) << 7) + ((c3[2] & 1) << 6) + ((c3[1] & 1) << 5) +
                            ((c3[0] & 1) << 4) + ((c2[3] & 1) << 3) + ((c2[2] & 1) << 2) +
                            ((c2[1] & 1) << 1) + (c2[0] & 1)
            );
            return accessBits;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /**
     * Calculates the access bits for a sector trailer (bytes 6 to 7) based on Table 6 and Table 7
     * on MIFARE 1k's reference
     *
     * @param accessConditions a 2d array containing the access conditions for each block
     * @return a 3 byte array containing the access bits
     */
    public static byte[] calculateAccessBits(byte[][] accessConditions) {
        try {
            return calculateAccessBits(accessConditions[0], accessConditions[1], accessConditions[2]);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /**
     * Calculates the individual access conditions given the access bits
     *
     * @param accessBits 3 bytes array containing the access bits of a sector trailer (bytes 6 to 7)
     * @return a 3-item array representing each of the access conditions (c1,c2,c3), each containing a byte array for the values of each block (0 to 3)
     */
    public static byte[][] calculateAccessConditions(byte[] accessBits) {
        try {
            return new byte[][]{
                    {(byte) (accessBits[1] >>> 4 & 1), (byte) (accessBits[1] >>> 5 & 1), (byte) (accessBits[1] >>> 6 & 1), (byte) (accessBits[1] >>> 7 & 1)}, //C1
                    {(byte) (accessBits[2] & 1), (byte) (accessBits[2] >>> 1 & 1), (byte) (accessBits[2] >>> 2 & 1), (byte) (accessBits[2] >>> 3 & 1)}, //C2
                    {(byte) (accessBits[2] >>> 4 & 1), (byte) (accessBits[2] >>> 5 & 1), (byte) (accessBits[2] >>> 6 & 1), (byte) (accessBits[2] >>> 7 & 1)} //C3
            };
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
