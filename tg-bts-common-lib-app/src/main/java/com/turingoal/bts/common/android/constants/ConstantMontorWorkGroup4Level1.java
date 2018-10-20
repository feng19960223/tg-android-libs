package com.turingoal.bts.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 一级修班组类型
 */
public final class ConstantMontorWorkGroup4Level1 {
    private ConstantMontorWorkGroup4Level1() {
        throw new Error("工具类不能实例化！");
    }

    public static final String GROUP_TOP = "top";  // 上部作业组
    public static final String GROUP_BOTTOM = "bottom";  // 下部作业组
    public static final String GROUP_REPAIR = "repair";  // 维修作业组
    public static final String GROUP_GROUND = "ground";  // 地勤作业组
    private static Map<String, String> map;
    private static Map<String, String> shortMap;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(GROUP_TOP, "上部作业组");
        map.put(GROUP_BOTTOM, "下部作业组");
        map.put(GROUP_REPAIR, "维修作业组");
        map.put(GROUP_GROUND, "地勤作业组");
        shortMap = new HashMap<>();
        shortMap.put(GROUP_TOP, "上");
        shortMap.put(GROUP_BOTTOM, "下");
        shortMap.put(GROUP_REPAIR, "维");
        shortMap.put(GROUP_GROUND, "地");
        DATA_LIST.add(new TgKeyValueBean(GROUP_TOP, map.get(GROUP_TOP)));
        DATA_LIST.add(new TgKeyValueBean(GROUP_BOTTOM, map.get(GROUP_BOTTOM)));
        DATA_LIST.add(new TgKeyValueBean(GROUP_REPAIR, map.get(GROUP_REPAIR)));
        DATA_LIST.add(new TgKeyValueBean(GROUP_GROUND, map.get(GROUP_GROUND)));
    }

    /**
     * 一级修班组类型
     */
    public static String getStr(final String type) {
        return TgStringUtil.null2Length0(map.get(type));
    }

    /**
     * 一级修班组类型
     */
    public static String getShortStr(final String type) {
        return TgStringUtil.null2Length0(shortMap.get(type));
    }
}
