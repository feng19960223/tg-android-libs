package com.turingoal.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [导航]位置
 */
public final class TgConstantCmsNavPositions {
    private TgConstantCmsNavPositions() {
        throw new Error("工具类不能实例化！");
    }

    public static final String TOP = "top"; // 顶部
    public static final String CENTER = "center"; // 中部
    public static final String BUTTOM = "bottom"; // 底部
    private static Map<String, String> map;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(TOP, "顶部");
        map.put(CENTER, "中部");
        map.put(BUTTOM, "底部");
        DATA_LIST.add(new TgKeyValueBean(TOP, map.get(TOP)));
        DATA_LIST.add(new TgKeyValueBean(CENTER, map.get(CENTER)));
        DATA_LIST.add(new TgKeyValueBean(BUTTOM, map.get(BUTTOM)));
    }

    /**
     * 类型
     */
    public static String getStr(final String type) {
        return TgStringUtil.null2Length0(map.get(type));
    }
}
