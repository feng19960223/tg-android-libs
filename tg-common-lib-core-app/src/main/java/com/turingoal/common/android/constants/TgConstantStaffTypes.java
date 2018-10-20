package com.turingoal.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 编制类型
 */
public final class TgConstantStaffTypes {
    private TgConstantStaffTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final int INTERNAL = 1;  // 内部
    public static final int EXTERNAL = 2;  // 外部
    private static Map<Integer, String> map;
    private static Map<Integer, String> shortMap;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(INTERNAL, "内部");
        map.put(EXTERNAL, "外部");
        shortMap = new HashMap<>();
        shortMap.put(INTERNAL, "内");
        shortMap.put(EXTERNAL, "外");
        DATA_LIST.add(new TgKeyValueBean(INTERNAL + "", map.get(INTERNAL)));
        DATA_LIST.add(new TgKeyValueBean(EXTERNAL + "", map.get(EXTERNAL)));
    }

    /**
     * 类型
     */
    public static String getStr(final int type) {
        return TgStringUtil.null2Length0(map.get(type));
    }

    /**
     * 类型
     */
    public static String getShortStr(final int type) {
        return TgStringUtil.null2Length0(shortMap.get(type));
    }
}
