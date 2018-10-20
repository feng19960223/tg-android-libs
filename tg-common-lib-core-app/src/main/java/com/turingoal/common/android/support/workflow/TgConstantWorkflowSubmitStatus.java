package com.turingoal.common.android.support.workflow;

import java.util.HashMap;
import java.util.Map;

/**
 * 提交状态
 */
public final class TgConstantWorkflowSubmitStatus {
    private TgConstantWorkflowSubmitStatus() {
        throw new Error("工具类不能实例化！");
    }

    public static final int SAVE = 10; // 保存
    public static final int SUBMIT = 1; // 提交
    public static final int REJECT = 2; // 驳回

    private static Map<Integer, String> map;
    static {
        map = new HashMap<>();
        map.put(SAVE, "保存");
        map.put(SUBMIT, "提交");
        map.put(REJECT, "驳回");
    }

    /**
     * 状态
     */
    public static String getStr(final int type) {
        return map.get(type);
    }
}
