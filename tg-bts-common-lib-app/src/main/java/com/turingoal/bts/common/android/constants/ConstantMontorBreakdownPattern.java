package com.turingoal.bts.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 故障模式
 */
public final class ConstantMontorBreakdownPattern {
    private ConstantMontorBreakdownPattern() {
        throw new Error("工具类不能实例化！");
    }

    public static final String OTHER = "other"; // 其他
    private static Map<String, String> map;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(OTHER, "其他");
        DATA_LIST.add(new TgKeyValueBean(OTHER, map.get(OTHER)));
    }

    /**
     * 类型
     */
    public static String getStr(final String type) {
        return TgStringUtil.null2Length0(map.get(type));
    }
}