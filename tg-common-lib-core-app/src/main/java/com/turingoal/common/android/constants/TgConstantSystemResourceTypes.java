package com.turingoal.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 常量-》资源类型
 */
public final class TgConstantSystemResourceTypes {
    private TgConstantSystemResourceTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final String RESOURCE_TYPE_SYSTEM = "system"; // 系统
    public static final String RESOURCE_TYPE_MENU = "menu"; // 菜单
    public static final String RESOURCE_TYPE_BUTTON = "button"; // 按钮
    public static final String RESOURCE_TYPE_METHOD = "method"; // 方法
    public static final String RESOURCE_TYPE_DATA = "data"; // 数据
    private static Map<String, String> map;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(RESOURCE_TYPE_SYSTEM, "系统");
        map.put(RESOURCE_TYPE_MENU, "菜单");
        map.put(RESOURCE_TYPE_BUTTON, "按钮");
        map.put(RESOURCE_TYPE_METHOD, "方法");
        map.put(RESOURCE_TYPE_DATA, "数据");
        DATA_LIST.add(new TgKeyValueBean(RESOURCE_TYPE_SYSTEM, map.get(RESOURCE_TYPE_SYSTEM)));
        DATA_LIST.add(new TgKeyValueBean(RESOURCE_TYPE_MENU, map.get(RESOURCE_TYPE_MENU)));
        DATA_LIST.add(new TgKeyValueBean(RESOURCE_TYPE_BUTTON, map.get(RESOURCE_TYPE_BUTTON)));
        DATA_LIST.add(new TgKeyValueBean(RESOURCE_TYPE_METHOD, map.get(RESOURCE_TYPE_METHOD)));
        DATA_LIST.add(new TgKeyValueBean(RESOURCE_TYPE_DATA, map.get(RESOURCE_TYPE_DATA)));
    }

    /**
     * 资源类型
     */
    public static String getStr(final String type) {
        return TgStringUtil.null2Length0(map.get(type));
    }
}
