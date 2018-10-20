package com.turingoal.bts.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 股道分类
 */
public final class ConstantTrackTypes {
    private ConstantTrackTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final int MAINTENANCE = 1;  // 检修，一二级修
    public static final int MAINTENANCE_TEMP = 2;  // 临修,大的故障
    public static final int TURNING_ROUND = 3; // 镟轮
    private static Map<Integer, String> map;
    private static Map<Integer, String> shortMap;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(MAINTENANCE, "检修");
        map.put(MAINTENANCE_TEMP, "临修");
        map.put(TURNING_ROUND, "镟轮");
        shortMap = new HashMap<>();
        shortMap.put(MAINTENANCE, "检");
        shortMap.put(MAINTENANCE_TEMP, "临");
        shortMap.put(TURNING_ROUND, "镟");
        DATA_LIST.add(new TgKeyValueBean(MAINTENANCE + "", map.get(MAINTENANCE)));
        DATA_LIST.add(new TgKeyValueBean(MAINTENANCE_TEMP + "", map.get(MAINTENANCE_TEMP)));
        DATA_LIST.add(new TgKeyValueBean(TURNING_ROUND + "", map.get(TURNING_ROUND)));
    }

    /**
     * 股道分类
     */
    public static String getStr(final int type) {
        return TgStringUtil.null2Length0(map.get(type));
    }

    /**
     * 股道分类
     */
    public static String getShortStr(final int type) {
        return TgStringUtil.null2Length0(shortMap.get(type));
    }
}
