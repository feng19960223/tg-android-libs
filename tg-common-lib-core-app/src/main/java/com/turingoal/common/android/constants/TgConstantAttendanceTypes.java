package com.turingoal.common.android.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 考勤类型
 */
public final class TgConstantAttendanceTypes {
    private TgConstantAttendanceTypes() {
        throw new Error("不能实例化！");
    }

    public static final String NORMAL = "normal"; // 正常
    public static final String LATE = "late"; // 迟到
    public static final String LEAVE_EARLY = "leaveEarly"; // 早退
    public static final String CASUAL_LEAVE = "casualLeave"; // 事假
    public static final String SICK_LEAVE = "sickLeave"; // 病假
    public static final String MARRIAGE_LEAVE = "marriageLeave"; // 婚假
    public static final String MATERNITY_LEAVE = "maternityLeave"; // 产假
    public static final String COMPASSIONATE_LEAVE = "compassionateLeave"; // 丧假
    public static final String ANNUAL_LEAVE = "annualLeave"; // 年假
    public static final String ABSENCE = "absence"; // 缺勤
    public static final String ABSENTEEISM = "absenteeism"; // 旷工
    public static final String EXTRA_WORK = "extraWork"; // 加班

    private static Map<String, String> map = new HashMap<String, String>();
    static {
        map.put(NORMAL, "正常");
        map.put(LATE, "迟到");
        map.put(LEAVE_EARLY, "早退");
        map.put(CASUAL_LEAVE, "事假");
        map.put(SICK_LEAVE, "病假");
        map.put(MARRIAGE_LEAVE, "婚假");
        map.put(MATERNITY_LEAVE, "产假");
        map.put(COMPASSIONATE_LEAVE, "丧假");
        map.put(ANNUAL_LEAVE, "年假");
        map.put(ABSENCE, "缺勤");
        map.put(ABSENTEEISM, "旷工");
        map.put(EXTRA_WORK, "加班");
    }

    /**
     * 获取考勤类型名称
     */
    public static String getAttendanceTypeStr(final String attendanceType) {
        return map.get(attendanceType);
    }
}
