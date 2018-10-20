package com.turingoal.bts.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 二级修分包类型
 */
public final class ConstantMontorLevel2SubPackageTypes {
    private ConstantMontorLevel2SubPackageTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final String I2 = "I2";  // I2
    public static final String M1 = "M1";  // M1
    public static final String M2 = "M2";  // M2
    public static final String M3 = "M3";  // M3
    public static final String M4 = "M4";  // M4
    public static final String S = "S";  // S
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        DATA_LIST.add(new TgKeyValueBean(I2, "I2"));
        DATA_LIST.add(new TgKeyValueBean(M1, "M1"));
        DATA_LIST.add(new TgKeyValueBean(M2, "M2"));
        DATA_LIST.add(new TgKeyValueBean(M3, "M3"));
        DATA_LIST.add(new TgKeyValueBean(M4, "M4"));
        DATA_LIST.add(new TgKeyValueBean(S, "S"));
    }
}
