package com.turingoal.bts.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 编组类型
 */
public final class ConstantTrainSetLengthTypes {
    private ConstantTrainSetLengthTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final int SHORT = 1;  // 短编组
    public static final int LONG = 2;  // 长编组
    public static final int CONNECTED = 10;  // 重连车
    private static Map<Integer, String> map;
    private static Map<Integer, String> shortMap;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(SHORT, "短编组");
        map.put(LONG, "长编组");
        map.put(CONNECTED, "重连车");
        shortMap = new HashMap<>();
        shortMap.put(SHORT, "短");
        shortMap.put(LONG, "长");
        shortMap.put(CONNECTED, "重");
        DATA_LIST.add(new TgKeyValueBean(SHORT + "", map.get(SHORT)));
        DATA_LIST.add(new TgKeyValueBean(LONG + "", map.get(LONG)));
        DATA_LIST.add(new TgKeyValueBean(CONNECTED + "", map.get(CONNECTED)));
    }

    /**
     * 通过编组类型获得编组类型名称
     */
    public static String getStr(final int type) {
        return TgStringUtil.null2Length0(map.get(type));
    }

    /**
     * 通过编组类型获得编组类型名称
     */
    public static String getShortStr(final int type) {
        return TgStringUtil.null2Length0(shortMap.get(type));
    }
}
