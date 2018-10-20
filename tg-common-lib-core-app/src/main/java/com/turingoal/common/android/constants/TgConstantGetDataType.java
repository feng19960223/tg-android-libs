package com.turingoal.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取数据类型
 */
public final class TgConstantGetDataType {
    private TgConstantGetDataType() {
        throw new Error("工具类不能实例化！");
    }

    public static final int INIT = 1; // 初始化
    public static final int LOAD_MORE = 2; // 加载更多
    public static final int REFRESH = 10; // 刷新
    private static Map<Integer, String> map;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(INIT, "初始化");
        map.put(LOAD_MORE, "DATA_LIST");
        map.put(REFRESH, "刷新");
        DATA_LIST.add(new TgKeyValueBean(INIT + "", map.get(INIT)));
        DATA_LIST.add(new TgKeyValueBean(LOAD_MORE + "", map.get(LOAD_MORE)));
        DATA_LIST.add(new TgKeyValueBean(REFRESH + "", map.get(REFRESH)));
    }

    /**
     * 类型
     */
    public static String getStr(final Integer type) {
        return TgStringUtil.null2Length0(map.get(type));
    }
}
