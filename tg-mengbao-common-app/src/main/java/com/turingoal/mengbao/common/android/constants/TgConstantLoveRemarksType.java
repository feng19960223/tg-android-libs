package com.turingoal.mengbao.common.android.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 爱心备注类型
 */
public final class TgConstantLoveRemarksType {
    private TgConstantLoveRemarksType() {
        throw new Error("不能实例化！");
    }

    public static final int LEAVE = 1;
    public static final int MEDICINE = 2;
    public static final int DIET = 3;
    public static final int OTHERS = 4;
    private static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(LEAVE, "请假");
        map.put(MEDICINE, "喂药");
        map.put(DIET, "忌口");
        map.put(OTHERS, "其他");
    }

    /**
     * 获取爱心备注类型名称
     */
    public static String getUserTypeStr(final int type) {
        return map.get(type);
    }
}
