package com.turingoal.bts.common.android.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 故障处理结果
 */
public final class ConstantBreakdownHandlingStatus {
    private ConstantBreakdownHandlingStatus() {
        throw new Error("工具类不能实例化！");
    }

    public static final int FINISHED = 1; // 已完成
    public static final int WAIT_HANDLING = 2; // 待处理
    public static final int WAIT_REVIEW = 10; // 处理待验收
    private static Map<Integer, String> map;

    static {
        map = new HashMap<>();
        map.put(FINISHED, "已完成");
        map.put(WAIT_HANDLING, "待处理");
        map.put(WAIT_REVIEW, "处理待验收");
    }

    /**
     * 故障来源
     */
    public static String getStr(final int status) {
        return map.get(status);
    }
}