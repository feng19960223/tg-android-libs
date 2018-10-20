package com.turingoal.common.android.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 权限域
 */
public final class TgConstantSystemDominTypes {
    private TgConstantSystemDominTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final String DEFAULT = "default"; // 默认
    public static final String FORE = "fore"; // 前台
    public static final String ADMIN = "admin"; // 后台
    public static final String MANAGER = "manager"; // 中台
    private static Map<String, String> map;
    static {
        map = new HashMap<>();
        map.put(DEFAULT, "默认");
        map.put(FORE, "前台");
        map.put(ADMIN, "后台");
        map.put(MANAGER, "中台");
    }

    /**
     * 权限域
     */
    public static String getStr(final String adType) {
        return map.get(adType);
    }
}
