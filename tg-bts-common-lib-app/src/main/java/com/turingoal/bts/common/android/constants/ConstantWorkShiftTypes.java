package com.turingoal.bts.common.android.constants;

import com.turingoal.bts.common.android.biz.domain.WorkShift;
import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 班次类型
 */
public final class ConstantWorkShiftTypes {
    private ConstantWorkShiftTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final int DAY_SHIFT = 1;  // 白班
    public static final int NIGHY_SHIFT = 2;  // 夜班
    private static Map<Integer, String> map;
    private static Map<Integer, String> shortMap;
    private static List<WorkShift> list;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(DAY_SHIFT, "白班");
        map.put(NIGHY_SHIFT, "夜班");
        shortMap = new HashMap<>();
        shortMap.put(DAY_SHIFT, "白");
        shortMap.put(NIGHY_SHIFT, "夜");
        list = new ArrayList<>();
        list.add(new WorkShift("白班", DAY_SHIFT));
        list.add(new WorkShift("夜班", NIGHY_SHIFT));
        DATA_LIST.add(new TgKeyValueBean(DAY_SHIFT + "", map.get(DAY_SHIFT)));
        DATA_LIST.add(new TgKeyValueBean(NIGHY_SHIFT + "", map.get(NIGHY_SHIFT)));
    }

    /**
     * 通过班次类型获得班次名称
     */
    public static String getStr(final int type) {
        return TgStringUtil.null2Length0(map.get(type));
    }

    /**
     * 通过班次类型获得班次名称
     */
    public static String getShortStr(final int type) {
        return TgStringUtil.null2Length0(shortMap.get(type));
    }
}
