package com.turingoal.common.android.util.system;

import com.blankj.ALog;

/**
 * 输出信息控制类
 */
public final class TgLogUtil {
    private TgLogUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * debug
     */
    public static void d(final String msg) {
        ALog.d(msg);
    }

    /**
     * information
     */
    public static void i(final String msg) {
        ALog.i(msg);
    }

    /**
     * verbose 详细的
     */
    public static void v(final String msg) {
        ALog.v(msg);
    }

    /**
     * warning
     */
    public static void w(final String msg) {
        ALog.w(msg);
    }

    /**
     * error
     */
    public static void e(final String msg) {
        ALog.e(msg);
    }
}
