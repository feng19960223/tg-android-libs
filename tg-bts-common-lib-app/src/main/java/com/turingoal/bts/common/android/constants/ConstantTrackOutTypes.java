package com.turingoal.bts.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 股道出站类型
 */
public final class ConstantTrackOutTypes {
    private ConstantTrackOutTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final int A_IN_A_OUT = 1;  // 1进1出
    public static final int A_IN_B_OUT = 2;  // 1进2出，即贯通股道
    private static Map<Integer, String> map;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(A_IN_A_OUT, "1进1出");
        map.put(A_IN_B_OUT, "1进2出");
        DATA_LIST.add(new TgKeyValueBean(A_IN_A_OUT + "", map.get(A_IN_A_OUT)));
        DATA_LIST.add(new TgKeyValueBean(A_IN_B_OUT + "", map.get(A_IN_B_OUT)));
    }

    /**
     * 股道出站类型
     */
    public static String getStr(final int type) {
        return TgStringUtil.null2Length0(map.get(type));
    }
}