package com.turingoal.common.android.constants;

import com.turingoal.common.android.bean.TgKeyValueBean;
import com.turingoal.common.android.util.lang.TgStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 常量-》性别
 */
public final class TgConstantGenderTypes {
    private TgConstantGenderTypes() {
        throw new Error("工具类不能实例化！");
    }

    public static final int MAIL = 1; // 男
    public static final int FEMAIL = 2; // 女
    public static final int OTHER = 99; // 其他
    private static Map<Integer, String> map;
    public static final List<TgKeyValueBean> DATA_LIST = new ArrayList<>();

    static {
        map = new HashMap<>();
        map.put(MAIL, "男");
        map.put(FEMAIL, "女");
        map.put(OTHER, "其他");
        DATA_LIST.add(new TgKeyValueBean(MAIL + "", map.get(MAIL)));
        DATA_LIST.add(new TgKeyValueBean(FEMAIL + "", map.get(FEMAIL)));
        DATA_LIST.add(new TgKeyValueBean(OTHER + "", map.get(OTHER)));
    }

    /**
     * 性别
     */
    public static String getStr(final int gender) {
        return TgStringUtil.null2Length0(map.get(gender));
    }
}
