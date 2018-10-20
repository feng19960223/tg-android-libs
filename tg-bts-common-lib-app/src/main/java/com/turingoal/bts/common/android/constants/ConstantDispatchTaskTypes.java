package com.turingoal.bts.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 派工任务类型
 */
public final class ConstantDispatchTaskTypes {
    private ConstantDispatchTaskTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final int MAINTENANCE = 1;  // 检修
    public static final int BREAKDOWN = 2;  // 故障
    private static Map<Integer, String> map;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(MAINTENANCE, "检修");
        map.put(BREAKDOWN, "故障");
        DATA_LIST.add(new TgKeyValueBean(MAINTENANCE + "", map.get(MAINTENANCE)));
        DATA_LIST.add(new TgKeyValueBean(BREAKDOWN + "", map.get(BREAKDOWN)));
    }

    /**
     * 派工任务类型
     */
    public static String getStr(final int type) {
        return TgStringUtil.null2Length0(map.get(type));
    }
}
