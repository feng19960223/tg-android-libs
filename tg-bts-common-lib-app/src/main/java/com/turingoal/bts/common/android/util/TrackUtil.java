package com.turingoal.bts.common.android.util;


import com.turingoal.common.android.util.lang.TgStringUtil;

/**
 * 股道工具类
 */
public final class TrackUtil {
    private TrackUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 通过股道全称获得股道，如D38-1或者D38(1)或者D38（1）或者D38[1]或者D38【1】，获得股道38
     */
    public static String getTrackCodeNumByFullName(final String trackFullName) {
        String trackCodeNum = trackFullName;
        if (!TgStringUtil.isBlank(trackFullName)) {
            if (trackFullName.contains("-")) {
                trackCodeNum = trackFullName.split("-")[0];
            } else if (trackFullName.contains("(")) {
                trackCodeNum = trackFullName.substring(0, trackFullName.indexOf("("));
            } else if (trackFullName.contains("（")) {
                trackCodeNum = trackFullName.substring(0, trackFullName.indexOf("（"));
            } else if (trackFullName.contains("[")) {
                trackCodeNum = trackFullName.substring(0, trackFullName.indexOf("["));
            } else if (trackFullName.contains("【")) {
                trackCodeNum = trackFullName.substring(0, trackFullName.indexOf("【"));
            }
        }
        return trackCodeNum;
    }

    /**
     * 通过股道全称获得列位，如D38-1或者D38(1)或者D38（1）或者D38[1]或者D38【1】，获得列位1
     */
    public static int getTrackRowByFullName(final String trackFullName) {
        int row = 1;
        if (!TgStringUtil.isBlank(trackFullName)) {
            String rowStr = null;
            if (trackFullName.contains("-")) {
                rowStr = trackFullName.split("-")[1];
            } else if (trackFullName.contains("(") && trackFullName.contains(")")) {
                rowStr = trackFullName.substring(trackFullName.indexOf("(") + 1, trackFullName.indexOf("(") + 2);
            } else if (trackFullName.contains("（") && trackFullName.contains("）")) {
                rowStr = trackFullName.substring(trackFullName.indexOf("（") + 1, trackFullName.indexOf("（") + 2);
            } else if (trackFullName.contains("[") && trackFullName.contains("]")) {
                rowStr = trackFullName.substring(trackFullName.indexOf("[") + 1, trackFullName.indexOf("[") + 2);
            } else if (trackFullName.contains("【") && trackFullName.contains("】")) {
                rowStr = trackFullName.substring(trackFullName.indexOf("【") + 1, trackFullName.indexOf("【") + 2);
            }
            if (!TgStringUtil.isBlank(rowStr)) {
                row = Integer.parseInt(rowStr);
            }
        }
        return row;
    }
}
