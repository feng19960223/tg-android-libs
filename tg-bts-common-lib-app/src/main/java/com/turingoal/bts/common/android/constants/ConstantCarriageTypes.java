package com.turingoal.bts.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车组中车辆车种编号类型
 */
public final class ConstantCarriageTypes {
    private ConstantCarriageTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final String SHANG_WU = "SW";  // 商务车 设置可躺式VIP座椅车
    public static final String YI_DENG_ZUO = "ZY";  // 一等座车 设置一等座椅车（包括设置一等座椅、VIP座椅包间车）
    public static final String ER_DENG_ZUO = "ZE";  // 二等座车 设置二等座椅车
    public static final String CAN = "CA";  // 餐车 16编组餐车
    public static final String CAN_ZUO = "ZEC";  // 座车、餐车 8编组餐座合造车
    public static final String YI_DENG_ZUO_GUANGUANG = "ZYG";  // 一等座车/观光车 16编组带观光区和座卧包间头车
    public static final String ER_DENG_ZUO_GUANGUANG = "ZEG";  // 二等座车/观光车 16编组带观光区头车
    private static Map<String, String> map;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(SHANG_WU, "商务车");
        map.put(YI_DENG_ZUO, "一等座车");
        map.put(ER_DENG_ZUO, "二等座车");
        map.put(CAN, "餐车");
        map.put(CAN_ZUO, "座车、餐车");
        map.put(YI_DENG_ZUO_GUANGUANG, "一等座车/观光车");
        map.put(ER_DENG_ZUO_GUANGUANG, "二等座车/观光车");
        DATA_LIST.add(new TgKeyValueBean(SHANG_WU, map.get(SHANG_WU)));
        DATA_LIST.add(new TgKeyValueBean(YI_DENG_ZUO, map.get(YI_DENG_ZUO)));
        DATA_LIST.add(new TgKeyValueBean(ER_DENG_ZUO, map.get(ER_DENG_ZUO)));
        DATA_LIST.add(new TgKeyValueBean(CAN, map.get(CAN)));
        DATA_LIST.add(new TgKeyValueBean(CAN_ZUO, map.get(CAN_ZUO)));
        DATA_LIST.add(new TgKeyValueBean(YI_DENG_ZUO_GUANGUANG, map.get(YI_DENG_ZUO_GUANGUANG)));
        DATA_LIST.add(new TgKeyValueBean(ER_DENG_ZUO_GUANGUANG, map.get(ER_DENG_ZUO_GUANGUANG)));
    }

    /**
     * 通过车种编号类型获得名称
     */
    public static String getStr(final String type) {
        return TgStringUtil.null2Length0(map.get(type));
    }
}
