package com.turingoal.common.android.util.math;

import java.util.UUID;

/**
 * 封装各种生成唯一性ID算法的工具类.
 */
public final class TgIdentitieUtil {
    private TgIdentitieUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * UUID, 中间有-分割.
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * UUID, 通过Random数字生成, 中间无-分割.
     */
    public static String uuidWithoutUnderline() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
