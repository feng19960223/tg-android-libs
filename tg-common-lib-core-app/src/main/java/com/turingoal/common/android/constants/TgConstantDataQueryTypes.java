package com.turingoal.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 常量-》查询类型
 */
public final class TgConstantDataQueryTypes {
    private TgConstantDataQueryTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final String SIMPLE_QUERY = "simple"; // 简单查询
    public static final String QUICK_QUERY = "quick"; // 快速查询
    public static final String ADVANCED_QUERY = "advanced"; // 高级查询
    public static final String MULTIPLE_QUERY = "multi"; // 多条件查询

    private static Map<String, String> map;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(SIMPLE_QUERY, "简单查询");
        map.put(QUICK_QUERY, "快速查询");
        map.put(ADVANCED_QUERY, "高级查询");
        map.put(MULTIPLE_QUERY, "条件查询");
        DATA_LIST.add(new TgKeyValueBean(SIMPLE_QUERY, map.get(SIMPLE_QUERY)));
        DATA_LIST.add(new TgKeyValueBean(QUICK_QUERY, map.get(QUICK_QUERY)));
        DATA_LIST.add(new TgKeyValueBean(ADVANCED_QUERY, map.get(ADVANCED_QUERY)));
        DATA_LIST.add(new TgKeyValueBean(MULTIPLE_QUERY, map.get(MULTIPLE_QUERY)));
    }

    /**
     * 类型
     */
    public static String getStr(final String type) {
        return TgStringUtil.null2Length0(map.get(type));
    }
}