package com.turingoal.bts.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 股道支持编组类型
 */
public final class ConstantTrackLengthTypes {

    private ConstantTrackLengthTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final int SHORT = 1;  // 短股道
    public static final int LONG = 2;  // 长股道
    private static Map<Integer, String> map;
    private static Map<Integer, String> shortMap;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(SHORT, "短股道");
        map.put(LONG, "长股道");
        shortMap = new HashMap<>();
        shortMap.put(SHORT, "短");
        shortMap.put(LONG, "长");
        DATA_LIST.add(new TgKeyValueBean(SHORT + "", map.get(SHORT)));
        DATA_LIST.add(new TgKeyValueBean(LONG + "", map.get(LONG)));
    }

    /**
     * 股道支持编组类型
     */
    public static String getStr(final int type) {
        return TgStringUtil.null2Length0(map.get(type));
    }

    /**
     * 股道支持编组类型
     */
    public static String getShortStr(final int type) {
        return TgStringUtil.null2Length0(shortMap.get(type));
    }
}
