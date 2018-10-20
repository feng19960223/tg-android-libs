package com.turingoal.bts.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 二级修班组类型
 */
public final class ConstantMontorWorkGroup4Level2 {
    private ConstantMontorWorkGroup4Level2() {
        throw new Error("工具类不能实例化！");
    }

    public static final String GROUP_SPECIAL_CONTROL = "control";  // 专项修组-司控组
    public static final String GROUP_SPECIAL_ELECTRIC = "electric";  // 专项修组-电气组
    public static final String GROUP_SPECIAL_DRIVING = "driving";  // 专项修组-行车组
    public static final String GROUP_SPECIAL_SERVICE = "service";  // 专项修组-客服组
    public static final String GROUP_WHEEL = "wheel";  // 轮轴作业组
    public static final String GROUP_GROUND = "ground";  // 地勤作业组
    public static final String GROUP_TEMPORARY = "temporary";  // 临修作业组
    public static final String GROUP_OUTSOURCING = "outsourcing";  // 外协组
    private static Map<String, String> map;
    private static Map<String, String> shortMap;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(GROUP_SPECIAL_CONTROL, "专项修组-司控组");
        map.put(GROUP_SPECIAL_ELECTRIC, "专项修组-电气组");
        map.put(GROUP_SPECIAL_DRIVING, "专项修组-行车组");
        map.put(GROUP_SPECIAL_SERVICE, "专项修组-客服组");
        map.put(GROUP_WHEEL, "轮轴作业组");
        map.put(GROUP_GROUND, "地勤作业组");
        map.put(GROUP_TEMPORARY, "临修作业组");
        map.put(GROUP_OUTSOURCING, "外协组");
        shortMap = new HashMap<>();
        shortMap.put(GROUP_SPECIAL_CONTROL, "司");
        shortMap.put(GROUP_SPECIAL_ELECTRIC, "电");
        shortMap.put(GROUP_SPECIAL_DRIVING, "行");
        shortMap.put(GROUP_SPECIAL_SERVICE, "客");
        shortMap.put(GROUP_WHEEL, "轮");
        shortMap.put(GROUP_GROUND, "地");
        shortMap.put(GROUP_TEMPORARY, "临");
        shortMap.put(GROUP_OUTSOURCING, "外");
        DATA_LIST.add(new TgKeyValueBean(GROUP_SPECIAL_CONTROL, map.get(GROUP_SPECIAL_CONTROL)));
        DATA_LIST.add(new TgKeyValueBean(GROUP_SPECIAL_ELECTRIC, map.get(GROUP_SPECIAL_ELECTRIC)));
        DATA_LIST.add(new TgKeyValueBean(GROUP_SPECIAL_DRIVING, map.get(GROUP_SPECIAL_DRIVING)));
        DATA_LIST.add(new TgKeyValueBean(GROUP_SPECIAL_SERVICE, map.get(GROUP_SPECIAL_SERVICE)));
        DATA_LIST.add(new TgKeyValueBean(GROUP_WHEEL, map.get(GROUP_WHEEL)));
        DATA_LIST.add(new TgKeyValueBean(GROUP_GROUND, map.get(GROUP_GROUND)));
        DATA_LIST.add(new TgKeyValueBean(GROUP_TEMPORARY, map.get(GROUP_TEMPORARY)));
        DATA_LIST.add(new TgKeyValueBean(GROUP_OUTSOURCING, map.get(GROUP_OUTSOURCING)));
    }

    /**
     * 二级修班组类型
     */
    public static String getStr(final String type) {
        return TgStringUtil.null2Length0(map.get(type));
    }

    /**
     * 二级修班组类型
     */
    public static String getShortStr(final String type) {
        return TgStringUtil.null2Length0(shortMap.get(type));
    }
}
