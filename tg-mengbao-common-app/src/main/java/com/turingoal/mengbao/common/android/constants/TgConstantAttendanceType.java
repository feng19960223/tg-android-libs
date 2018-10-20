package com.turingoal.mengbao.common.android.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 考勤类型
 */
public final class TgConstantAttendanceType {
    private TgConstantAttendanceType() {
        throw new Error("不能实例化！");
    }

    public static final int LATE = 1;
    public static final int LEAVE_EARLY = 2;
    public static final int LEAVE = 3;
    public static final int ABSENTEEISM = 10;
    private static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(LATE, "迟到");
        map.put(LEAVE_EARLY, "早退");
        map.put(LEAVE, "请假");
        map.put(ABSENTEEISM, "旷课");
    }

    /**
     * 获取考勤类型名称
     */
    public static String getUserTypeStr(final int type) {
        return map.get(type);
    }
}
