package com.turingoal.mengbao.common.android.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量-》是否
 */
public final class TgMengbaoConstantYesNo {
    private TgMengbaoConstantYesNo() {
        throw new Error("工具类不能实例化！");
    }

    public static final int ALL = 100; // 全部
    public static final int YES = 1; // 是
    public static final int NO = 2; // 否
    private static Map<Integer, String> map;
    static {
        map = new HashMap<>();
        map.put(ALL, "全部");
        map.put(YES, "是");
        map.put(NO, "否");
    }

    /**
     * 是否常量
     */
    public static String getStr(final int yesNo) {
        return map.get(yesNo);
    }
}