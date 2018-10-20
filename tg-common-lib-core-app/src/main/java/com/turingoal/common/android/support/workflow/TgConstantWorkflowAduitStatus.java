package com.turingoal.common.android.support.workflow;

import java.util.HashMap;
import java.util.Map;

/**
 * 审核状态
 */
public final class TgConstantWorkflowAduitStatus {
    private TgConstantWorkflowAduitStatus() {
        throw new Error("工具类不能实例化！");
    }

    public static final int YES = 1; // 已通过
    public static final int NO = 2; // 未通过
    public static final int WAIT = 10; // 待审核
    public static final int PROCESS = 99; // 审核中
    private static Map<Integer, String> map;

    static {
        map = new HashMap<>();
        map.put(YES, "已通过");
        map.put(NO, "未通过");
        map.put(WAIT, "待审核");
        map.put(PROCESS, "审核中");
    }

    /**
     * 获取审核结果
     */
    public static String getStr(final int result) {
        return map.get(result);
    }
}
