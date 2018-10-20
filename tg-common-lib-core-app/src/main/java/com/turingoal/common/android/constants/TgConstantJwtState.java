package com.turingoal.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定义token的三种状态
 */
public final class TgConstantJwtState {
    private TgConstantJwtState() {
        throw new Error("工具类不能实例化！");
    }

    public static final String EXPIRED = "EXPIRED"; // 过期
    public static final String INVALID = "INVALID"; // 无效(token不合法)
    public static final String VALID = "VALID"; // 有效的

    private static Map<String, String> map;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(EXPIRED, "过期");
        map.put(INVALID, "无效");
        map.put(VALID, "有效");
        DATA_LIST.add(new TgKeyValueBean(EXPIRED, map.get(EXPIRED)));
        DATA_LIST.add(new TgKeyValueBean(INVALID, map.get(INVALID)));
        DATA_LIST.add(new TgKeyValueBean(VALID, map.get(VALID)));
    }

    /**
     * 类型
     */
    public static String getStr(final String type) {
        return TgStringUtil.null2Length0(map.get(type));
    }
}
