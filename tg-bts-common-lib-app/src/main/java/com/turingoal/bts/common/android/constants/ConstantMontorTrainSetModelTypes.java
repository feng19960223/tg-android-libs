package com.turingoal.bts.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车型分类
 */
public final class ConstantMontorTrainSetModelTypes {
    private ConstantMontorTrainSetModelTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final String GENERAL_PEED = "general"; // 一般动车组（D字头列车）主要用于快速铁路，高速动车组
    public static final String HIGH_SPEED = "high";  // 高速动车组（G）主要用于高速铁路
    public static final String LOW_SPEED = "low"; // 低速动车组（南车青岛公司研究时速140公里的）适合将来的城市轻轨，
    private static Map<String, String> map;
    private static Map<String, String> shortMap;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(GENERAL_PEED, "一般动车组");
        map.put(HIGH_SPEED, "高速动车组");
        map.put(LOW_SPEED, "低速动车组");
        shortMap = new HashMap<>();
        shortMap.put(GENERAL_PEED, "一般");
        shortMap.put(HIGH_SPEED, "高速");
        shortMap.put(LOW_SPEED, "低速");
        DATA_LIST.add(new TgKeyValueBean(GENERAL_PEED, map.get(GENERAL_PEED)));
        DATA_LIST.add(new TgKeyValueBean(HIGH_SPEED, map.get(HIGH_SPEED)));
        DATA_LIST.add(new TgKeyValueBean(LOW_SPEED, map.get(LOW_SPEED)));
    }

    /**
     * 车型分类
     */
    public static String getStr(final String type) {
        return TgStringUtil.null2Length0(map.get(type));
    }

    /**
     * 车型分类
     */
    public static String getShortStr(final String type) {
        return TgStringUtil.null2Length0(shortMap.get(type));
    }
}
