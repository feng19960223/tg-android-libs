package com.turingoal.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 任务状态
 */
public final class TgConstantTaskStatus {
    private TgConstantTaskStatus() {
        throw new Error("工具类不能实例化！");
    }

    public static final int NO_STARTED = 2; // 未开始
    public static final int STARTED = 10; // 进行中
    public static final int FINISHED = 1; // 已完成
    private static Map<Integer, String> map;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(NO_STARTED, "未开始");
        map.put(STARTED, "进行中");
        map.put(FINISHED, "已完成");
        DATA_LIST.add(new TgKeyValueBean(NO_STARTED + "", map.get(NO_STARTED)));
        DATA_LIST.add(new TgKeyValueBean(STARTED + "", map.get(STARTED)));
        DATA_LIST.add(new TgKeyValueBean(FINISHED + "", map.get(FINISHED)));
    }

    /**
     * 任务状态
     */
    public static String getStr(final int type) {
        return TgStringUtil.null2Length0(map.get(type));
    }
}