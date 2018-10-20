package com.turingoal.bts.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 动车 修程
 */
public final class ConstantMontorMaintenanceLevels {
    private ConstantMontorMaintenanceLevels() {
        throw new Error("工具类不能实例化！");
    }

    public static final String LEVEL_1 = "1";  // 一级修
    public static final String LEVEL_2 = "2";  // 二级修
    public static final String LEVEL_3 = "3";  // 三级修
    public static final String LEVEL_4 = "4";  // 四级修
    public static final String LEVEL_5 = "5";  // 五级修
    public static final String OTHER = "99";  // 无级修
    private static Map<String, String> map;
    private static Map<String, String> shortMap;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(LEVEL_1, "一级修");
        map.put(LEVEL_2, "二级修");
        map.put(LEVEL_3, "三级修");
        map.put(LEVEL_4, "四级修");
        map.put(LEVEL_5, "五级修");
        map.put(OTHER, "无级修");
        shortMap = new HashMap<>();
        shortMap.put(LEVEL_1, "一");
        shortMap.put(LEVEL_2, "二");
        shortMap.put(LEVEL_3, "三");
        shortMap.put(LEVEL_4, "四");
        shortMap.put(LEVEL_5, "五");
        shortMap.put(OTHER, "无");
        DATA_LIST.add(new TgKeyValueBean(LEVEL_1, map.get(LEVEL_1)));
        DATA_LIST.add(new TgKeyValueBean(LEVEL_2 , map.get(LEVEL_2)));
        DATA_LIST.add(new TgKeyValueBean(LEVEL_3 , map.get(LEVEL_3)));
        DATA_LIST.add(new TgKeyValueBean(LEVEL_4 , map.get(LEVEL_4)));
        DATA_LIST.add(new TgKeyValueBean(LEVEL_5 , map.get(LEVEL_5)));
        DATA_LIST.add(new TgKeyValueBean(OTHER, map.get(OTHER)));
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
