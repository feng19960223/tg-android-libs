package com.turingoal.bts.common.android.constants;

import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 动车 作业状态
 */
public final class ConstantStatus4Work {
    private ConstantStatus4Work() {
        throw new Error("工具类不能实例化！");
    }

    public static final String NO_STARTED = "noStarted"; // 未开始
    public static final String WORKING = "working"; // 作业中
    public static final String FINISHED_WAIT = "finishedWait"; // 等待确认完成
    public static final String FINISHED = "finished"; // 已完成
    public static final String SUSPEND = "suspend"; // 暂停
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put(NO_STARTED, "未开始");
        map.put(WORKING, "作业中");
        map.put(FINISHED_WAIT, "待确认完成");
        map.put(FINISHED, "已完成");
        map.put(SUSPEND, "暂停");
    }

    /**
     * 作业状态
     */
    public static String getStr(final String type) {
        return TgStringUtil.null2Length0(map.get(type));
    }
}
