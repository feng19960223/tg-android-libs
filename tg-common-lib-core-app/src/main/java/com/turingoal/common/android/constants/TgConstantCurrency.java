package com.turingoal.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 常量-》货币类型
 */
public final class TgConstantCurrency {
    private TgConstantCurrency() {
        throw new Error("工具类不能实例化！");
    }

    public static final String CNY = "CNY"; // CNY
    public static final String CNY_NAME = "人民币"; // CNY人民币
    public static final String USD = "USD"; // USD
    public static final String USD_NAME = "美元"; // 美元
    public static final String EUR = "EUR"; // EUR
    public static final String EUR_NAME = "欧元"; // 欧元
    public static final String GBP = "GBP"; // GBP
    public static final String GBP_NAME = "英镑"; // 英镑
    public static final String HKD = "HKD"; // HKD
    public static final String HKD_NAME = "港元"; // 港元
    public static final String JPY = "JPY"; // JPY
    public static final String JPY_NAME = "日元"; // 日元

    private static Map<String, String> map;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();
    public static final List<TgKeyValueBean> DATA_EN_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(CNY, "人民币");
        map.put(USD, "美元");
        map.put(EUR, "欧元");
        map.put(GBP, "英镑");
        map.put(HKD, "港元");
        map.put(JPY, "日元");
        DATA_LIST.add(new TgKeyValueBean(CNY, map.get(CNY)));
        DATA_LIST.add(new TgKeyValueBean(USD, map.get(USD)));
        DATA_LIST.add(new TgKeyValueBean(EUR, map.get(EUR)));
        DATA_LIST.add(new TgKeyValueBean(GBP, map.get(GBP)));
        DATA_LIST.add(new TgKeyValueBean(HKD, map.get(HKD)));
        DATA_LIST.add(new TgKeyValueBean(JPY, map.get(JPY)));
        DATA_EN_LIST.add(new TgKeyValueBean(CNY, CNY));
        DATA_EN_LIST.add(new TgKeyValueBean(USD, USD));
        DATA_EN_LIST.add(new TgKeyValueBean(EUR, EUR));
        DATA_EN_LIST.add(new TgKeyValueBean(GBP, GBP));
        DATA_EN_LIST.add(new TgKeyValueBean(HKD, HKD));
        DATA_EN_LIST.add(new TgKeyValueBean(JPY, JPY));
    }

    /**
     * 类型
     */
    public static String getStr(final String type) {
        return TgStringUtil.null2Length0(map.get(type));
    }
}
