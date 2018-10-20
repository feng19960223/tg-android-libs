package com.turingoal.bts.common.android.util;

import java.util.Date;
import com.turingoal.bts.common.android.constants.ConstantWorkShiftTypes;
import com.turingoal.common.android.util.lang.TgDateUtil;
import com.turingoal.common.android.util.lang.TgStringUtil;

/**
 * 班次工具类
 */
public final class WorkShiftUtil {
    private WorkShiftUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 通过班次全称获得班次日期字符串，如2017-09-18[夜班]，2017-09-18白班 , 得到2017-09-18
     */
    public static String getWorkShiftDateStrByFullName(final String workShiftFullName) {
        String workShiftDateStr = null;
        if (!TgStringUtil.isBlank(workShiftFullName)) {
            workShiftDateStr = workShiftFullName.substring(0, 10);
        }
        return workShiftDateStr;
    }

    /**
     * 通过班次全称获得班次日期，如2017-09-18[夜班]，2017-09-18白班 , 得到2017-09-18
     */
    public static Date getWorkShiftDateByFullName(final String workShiftFullName) {
        Date workShiftDate = null;
        String workShiftDateStr = getWorkShiftDateStrByFullName(workShiftFullName);
        if (!TgStringUtil.isBlank(workShiftDateStr)) {
            workShiftDate = TgDateUtil.string2Date(workShiftDateStr);
        }
        return workShiftDate;
    }

    /**
     * 通过班次全称获得班次类型，如2017-09-18[夜班],2017-09-18【夜班】 ,2017-09-18(夜班) ,2017-09-18（夜班） ,2017-09-18夜班， 得到 夜班
     */
    public static String getWorkShiftNameByFullName(final String workShiftFullName) {
        String workShiftName = null;
        if (!TgStringUtil.isBlank(workShiftFullName)) {
            if (workShiftFullName.contains("[") && workShiftFullName.contains("]")) {
                workShiftName = workShiftFullName.substring(workShiftFullName.indexOf("[") + 1, workShiftFullName.indexOf("[") + 3); // 2017-09-18[夜班]
            } else if (workShiftFullName.contains("【") && workShiftFullName.contains("】")) {
                workShiftName = workShiftFullName.substring(workShiftFullName.indexOf("【") + 1, workShiftFullName.indexOf("【") + 3); // 2017-09-18【夜班】
            } else if (workShiftFullName.contains("(") && workShiftFullName.contains(")")) {
                workShiftName = workShiftFullName.substring(workShiftFullName.indexOf("(") + 1, workShiftFullName.indexOf(")") + 3); // 2017-09-18(夜班)
            } else if (workShiftFullName.contains("（") && workShiftFullName.contains("）")) {
                workShiftName = workShiftFullName.substring(workShiftFullName.indexOf("（") + 1, workShiftFullName.indexOf("）") + 3); // 2017-09-18（夜班）
            } else {
                workShiftName = workShiftFullName.substring(10); // 2017-09-18夜班
            }
        }
        return workShiftName;
    }

    /**
     * 通过班次全称获得班次类型，如2017-09-18[夜班]， 得到 ConstantWorkShiftType.NIGHY_SHIFT 2。默认白班
     */
    public static int getWorkShiftTypeByFullName(final String workShiftFullName) {
        int workShiftType = ConstantWorkShiftTypes.DAY_SHIFT; // 默认白班
        String workShiftName = getWorkShiftNameByFullName(workShiftFullName);
        if (!TgStringUtil.isBlank(workShiftName)) {
            if ("白班".equals(workShiftName) || "白".equals(workShiftName)) {
                workShiftType = ConstantWorkShiftTypes.DAY_SHIFT;
            } else if ("夜班".equals(workShiftName) || "夜".equals(workShiftName)) {
                workShiftType = ConstantWorkShiftTypes.NIGHY_SHIFT;
            }
        }
        return workShiftType;
    }
}
