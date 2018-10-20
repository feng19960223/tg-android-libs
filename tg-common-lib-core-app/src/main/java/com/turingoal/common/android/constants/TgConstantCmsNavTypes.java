package com.turingoal.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [导航]类型
 */
public final class TgConstantCmsNavTypes {
    private TgConstantCmsNavTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final String NODE = "node"; // 栏目
    public static final String INFO = "info"; // 文章
    public static final String SINGLE = "single"; // 单页
    public static final String LINK = "link"; // 链接
    private static Map<String, String> map;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(NODE, "栏目");
        map.put(INFO, "文章");
        map.put(SINGLE, "单页");
        map.put(LINK, "链接");
        DATA_LIST.add(new TgKeyValueBean(NODE, map.get(NODE)));
        DATA_LIST.add(new TgKeyValueBean(INFO, map.get(INFO)));
        DATA_LIST.add(new TgKeyValueBean(SINGLE, map.get(SINGLE)));
        DATA_LIST.add(new TgKeyValueBean(LINK, map.get(LINK)));
    }

    /**
     * 类型
     */
    public static String getStr(final String type) {
        return TgStringUtil.null2Length0(map.get(type));
    }
}
