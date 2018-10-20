package com.turingoal.common.android.util.io;

import android.support.annotation.RawRes;

import com.blankj.utilcode.util.ResourceUtils;

import java.util.List;

/**
 * 资源工具类
 */
public class TgResourceUtil {
    private TgResourceUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 从 assets 中拷贝文件
     */
    public static boolean copyFileFromAssets(final String assetsFilePath, final String destFilePath) {
        return ResourceUtils.copyFileFromAssets(assetsFilePath, destFilePath);
    }

    /**
     * 从 assets 中读取字符串
     */
    public static String readAssets2String(final String assetsFilePath) {
        return ResourceUtils.readAssets2String(assetsFilePath);
    }

    /**
     * 从 assets 中读取字符串
     */
    public static String readAssets2String(final String assetsFilePath, final String charsetName) {
        return ResourceUtils.readAssets2String(assetsFilePath, charsetName);
    }

    /**
     * 从 assets 中按行读取字符串
     */
    public static List<String> readAssets2List(final String assetsPath) {
        return ResourceUtils.readAssets2List(assetsPath);
    }

    /**
     * 从 assets 中按行读取字符串
     */
    public static List<String> readAssets2List(final String assetsPath, final String charsetName) {
        return ResourceUtils.readAssets2List(assetsPath, charsetName);
    }

    /**
     * 从 raw 中拷贝文件
     */
    public static boolean copyFileFromRaw(@RawRes final int resId, final String destFilePath) {
        return ResourceUtils.copyFileFromRaw(resId, destFilePath);
    }

    /**
     * 从 raw 中读取字符串
     */
    public static String readRaw2String(@RawRes final int resId) {
        return ResourceUtils.readRaw2String(resId);
    }

    /**
     * 从 raw 中读取字符串
     */
    public static String readRaw2String(@RawRes final int resId, final String charsetName) {
        return ResourceUtils.readRaw2String(resId, charsetName);
    }

    /**
     * 从 raw 中按行读取字符串
     */
    public static List<String> readRaw2List(@RawRes final int resId) {
        return ResourceUtils.readRaw2List(resId);
    }

    /**
     * 从 raw 中按行读取字符串
     */
    public static List<String> readRaw2List(@RawRes final int resId, final String charsetName) {
        return ResourceUtils.readRaw2List(resId, charsetName);
    }
}
