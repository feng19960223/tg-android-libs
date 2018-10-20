package com.turingoal.bts.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车组类型
 */
public final class ConstantTrainSetTypes {
    private ConstantTrainSetTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final int MONTOR = 1; // 动车
    public static final int LOCOMOTIVE = 2;  // 机车
    private static Map<Integer, String> map;
    private static Map<Integer, String> shortMap;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(MONTOR, "动车");
        map.put(LOCOMOTIVE, "机车");
        shortMap = new HashMap<>();
        shortMap.put(MONTOR, "动");
        shortMap.put(LOCOMOTIVE, "机");
        DATA_LIST.add(new TgKeyValueBean(MONTOR + "", map.get(MONTOR)));
        DATA_LIST.add(new TgKeyValueBean(LOCOMOTIVE + "", map.get(LOCOMOTIVE)));
    }

    /**
     * 车组分类
     */
    public static String getStr(final int type) {
        return TgStringUtil.null2Length0(map.get(type));
    }

    /**
     * 车组分类
     */
    public static String getShortStr(final int type) {
        return TgStringUtil.null2Length0(shortMap.get(type));
    }
}
