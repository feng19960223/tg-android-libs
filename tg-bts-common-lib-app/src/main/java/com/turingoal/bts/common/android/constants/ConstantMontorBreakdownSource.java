package com.turingoal.bts.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 动车 故障来源
 */
public final class ConstantMontorBreakdownSource {
    private ConstantMontorBreakdownSource() {
        throw new Error("工具类不能实例化！");
    }

    public static final String GROUND_CHECK = "groundCheck"; // 地面检查
    public static final String CREW_LOG = "crewLog"; // 乘务日志
    private static Map<String, String> map;
    private static Map<String, String> shortMap;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(GROUND_CHECK, "地面检查");
        map.put(CREW_LOG, "乘务日志");
        shortMap = new HashMap<>();
        shortMap.put(GROUND_CHECK, "地面");
        shortMap.put(CREW_LOG, "乘务");
        DATA_LIST.add(new TgKeyValueBean(GROUND_CHECK, map.get(GROUND_CHECK)));
        DATA_LIST.add(new TgKeyValueBean(CREW_LOG, map.get(CREW_LOG)));
    }

    /**
     * 故障来源
     */
    public static String getStr(final String type) {
        return TgStringUtil.null2Length0(map.get(type));
    }

    /**
     * 故障来源
     */
    public static String getShortStr(final String type) {
        return TgStringUtil.null2Length0(shortMap.get(type));
    }
}