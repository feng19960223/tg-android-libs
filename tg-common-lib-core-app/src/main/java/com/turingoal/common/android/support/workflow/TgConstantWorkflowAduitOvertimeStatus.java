package com.turingoal.common.android.support.workflow;

import java.util.HashMap;
import java.util.Map;

/**
 * 审核超时状态
 */
public final class TgConstantWorkflowAduitOvertimeStatus {
    private TgConstantWorkflowAduitOvertimeStatus() {
        throw new Error("工具类不能实例化！");
    }

    public static final int OK = 1; // 正常
    public static final int OVERTIME = 2; // 超时
    private static Map<Integer, String> map;
    static {
        map = new HashMap<>();
        map.put(OK, "正常");
        map.put(OVERTIME, "超时");
    }

    /**
     * 类型
     */
    public static String getStr(final int type) {
        return map.get(type);
    }
}
