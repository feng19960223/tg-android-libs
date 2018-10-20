package com.turingoal.mengbao.common.android.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户类型
 */
public final class ConstantUserType {
    private ConstantUserType() {
        throw new Error("不能实例化！");
    }

    public static final int PARENT = 1;
    public static final int TEACHER = 2;
    public static final int SCHOOL = 11;
    private static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(PARENT, "家长");
        map.put(TEACHER, "老师");
        map.put(SCHOOL, "幼儿园");
    }

    /**
     * 获取用户类型名称
     */
    public static String getUserTypeStr(final int userType) {
        return map.get(userType);
    }
}
