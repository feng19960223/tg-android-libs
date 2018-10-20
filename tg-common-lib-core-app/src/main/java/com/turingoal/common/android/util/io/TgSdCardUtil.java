package com.turingoal.common.android.util.io;

import com.blankj.utilcode.util.SDCardUtils;

import java.util.List;

/**
 * SD卡工具类
 */
public class TgSdCardUtil {
    private TgSdCardUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 根据 Environment 判断 SD 卡是否可用
     */
    public static boolean isSDCardEnableByEnvironment() {
        return SDCardUtils.isSDCardEnableByEnvironment();
    }

    /**
     * 根据 Environment 获取 SD 卡路径
     */
    public static String getSDCardPathByEnvironment() {
        return SDCardUtils.getSDCardPathByEnvironment();
    }

    /**
     * 判断 SD 卡是否可用
     */
    public static boolean isSDCardEnable() {
        return SDCardUtils.isSDCardEnable();
    }

    /**
     * 获取 SD 卡路径
     */
    public static List<String> getSDCardPaths(final boolean removable) {
        return SDCardUtils.getSDCardPaths(removable);
    }

    /**
     * 获取 SD 卡路径
     */
    public static List<String> getSDCardPaths() {
        return SDCardUtils.getSDCardPaths();
    }
}