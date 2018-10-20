package com.turingoal.bts.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 班组类型
 */
public final class ConstantWorkGroupTypes {
    private ConstantWorkGroupTypes() {
        throw new Error("工具类不能实例化！");
    }

    private static Map<String, String> map;
    private static Map<String, String> shortMap;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        shortMap = new HashMap<>();
        // DATA_LIST.add(new TgKeyValueBean(DAY_SHIFT + "", map.get(DAY_SHIFT)));
        // DATA_LIST.add(new TgKeyValueBean(NIGHY_SHIFT + "", map.get(NIGHY_SHIFT)));
    }

    /**
     * 名称
     */
    public static String getStr(final String type) {
        return TgStringUtil.null2Length0(map.get(type));
    }

    /**
     * 名称
     */
    public static String getShortStr(final String type) {
        return TgStringUtil.null2Length0(shortMap.get(type));
    }
}
