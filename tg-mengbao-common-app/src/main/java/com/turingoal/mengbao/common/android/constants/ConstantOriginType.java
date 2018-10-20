package com.turingoal.mengbao.common.android.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 礼物来源
 */
public final class ConstantOriginType {
    private ConstantOriginType() {
        throw new Error("不能实例化！");
    }

    public static final int COMMENTS = 1;
    public static final int HOMEWORK = 2;
    public static final int SCHOOL = 11;
    private static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(COMMENTS, "点评");
        map.put(HOMEWORK, "亲子作业");
        map.put(SCHOOL, "幼儿园");
    }

    /**
     * 获取礼物来源名称
     */
    public static String getUserTypeStr(final int userType) {
        return map.get(userType);
    }
}
