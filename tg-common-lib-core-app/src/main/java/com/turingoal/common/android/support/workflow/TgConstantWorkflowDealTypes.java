package com.turingoal.common.android.support.workflow;

import java.util.HashMap;
import java.util.Map;

/**
 * 审核处理方式
 */
public final class TgConstantWorkflowDealTypes {
    private TgConstantWorkflowDealTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final int YES = 1; // 通过
    public static final int NO = 2; // 驳回
    public static final int SUBMIT = 10; // 提交
    private static Map<Integer, String> map;

    static {
        map = new HashMap<>();
        map.put(SUBMIT, "提交");
        map.put(YES, "通过");
        map.put(NO, "驳回");
    }

    /**
     * 获取审核结果
     */
    public static String getStr(final int result) {
        return map.get(result);
    }
}
