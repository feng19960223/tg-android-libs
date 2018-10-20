package com.turingoal.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 常量-》结果常量
 */
public final class TgConstantResultValues {
    private TgConstantResultValues() {
        throw new Error("工具类不能实例化！");
    }

    public static final String ALL = "ALL"; // 全部
    public static final String SUCCESS = "success"; // 成功
    public static final String FAIL = "fail"; // 失败
    public static final String ALL_CN = "全部"; // 全部
    public static final String SUCCESS_CN = "成功"; // 成功
    public static final String FAIL_CN = "失败"; // 失败

    private static Map<String, String> map;
    public static final List<TgKeyValueBean> DATA_LIST_WITH_ALL = new ArrayList<>();
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(ALL, "全部");
        map.put(SUCCESS, "成功");
        map.put(FAIL, "失败");
        DATA_LIST_WITH_ALL.add(new TgKeyValueBean(ALL + "", map.get(ALL)));
        DATA_LIST_WITH_ALL.add(new TgKeyValueBean(SUCCESS + "", map.get(SUCCESS)));
        DATA_LIST_WITH_ALL.add(new TgKeyValueBean(FAIL + "", map.get(FAIL)));
        DATA_LIST.add(new TgKeyValueBean(SUCCESS, map.get(SUCCESS)));
        DATA_LIST.add(new TgKeyValueBean(FAIL, map.get(FAIL)));
    }

    /**
     * 类型
     */
    public static String getStr(final String type) {
        return TgStringUtil.null2Length0(map.get(type));
    }
}
