package com.turingoal.bts.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 股道进站出站
 */
public final class ConstantTrackArriveOrOutType {
    private ConstantTrackArriveOrOutType() {
        throw new Error("工具类不能实例化！");
    }

    public static final int ARRIVE = 1;  // 进站
    public static final int OUT = 2;  // 出站
    private static Map<Integer, String> map;
    private static Map<Integer, String> shortMap;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(ARRIVE, "进站");
        map.put(OUT, "出站");
        shortMap = new HashMap<>();
        shortMap.put(ARRIVE, "进");
        shortMap.put(OUT, "出");
        DATA_LIST.add(new TgKeyValueBean(ARRIVE + "", map.get(ARRIVE)));
        DATA_LIST.add(new TgKeyValueBean(OUT + "", map.get(OUT)));
    }

    /**
     * 股道进站出站
     */
    public static String getStr(final int type) {
        return TgStringUtil.null2Length0(map.get(type));
    }

    /**
     * 股道进站出站
     */
    public static String getShortStr(final int type) {
        return TgStringUtil.null2Length0(shortMap.get(type));
    }
}