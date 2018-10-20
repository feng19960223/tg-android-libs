package com.turingoal.common.android.util.system;

import android.support.annotation.RequiresPermission;

import com.blankj.utilcode.util.DeviceUtils;

import static android.Manifest.permission.ACCESS_WIFI_STATE;
import static android.Manifest.permission.INTERNET;

/**
 * 设备工具类
 */
public final class TgDeviceUtil {
    private TgDeviceUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 判断设备是否 rooted
     */
    public static boolean isDeviceRooted() {
        return DeviceUtils.isDeviceRooted();
    }

    /**
     * 获取设备系统版本号
     */
    public static String getSDKVersionName() {
        return DeviceUtils.getSDKVersionName();
    }

    /**
     * 获取设备系统版本码
     */
    public static int getSDKVersionCode() {
        return DeviceUtils.getSDKVersionCode();
    }

    /**
     * 获取设备 AndroidID
     */
    public static String getAndroidID() {
        return DeviceUtils.getAndroidID();
    }

    /**
     * 获取设备MAC地址
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>}</p>
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.INTERNET"/>}</p>
     *
     * @return MAC地址
     */
    @RequiresPermission(allOf = {ACCESS_WIFI_STATE, INTERNET})
    public static String getMacAddress() {
        return DeviceUtils.getMacAddress();
    }

    /**
     * 获取设备MAC地址
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>}</p>
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.INTERNET"/>}</p>
     *
     * @return MAC地址
     */
    @RequiresPermission(allOf = {ACCESS_WIFI_STATE, INTERNET})
    public static String getMacAddress(final String... excepts) {
        return DeviceUtils.getMacAddress();
    }

    /**
     * 获取设备厂商
     */
    public static String getManufacturer() {
        return DeviceUtils.getManufacturer();
    }

    /**
     * 获取设备型号
     */
    public static String getModel() {
        return DeviceUtils.getModel();
    }

    /**
     * 获取设备 ABIs
     */
    public static String[] getABIs() {
        return DeviceUtils.getABIs();
    }

    /**
     * 关机
     */
    public static void shutdown() {
        DeviceUtils.shutdown();
    }

    /**
     * 重启
     */
    public static void reboot() {
        DeviceUtils.reboot();
    }

    /**
     * 重启
     */
    public static void reboot(final String reason) {
        DeviceUtils.reboot(reason);
    }

    /**
     * 重启到 recovery
     */
    public static void reboot2Recovery() {
        DeviceUtils.reboot2Recovery();
    }

    /**
     * 重启到 bootloader
     */
    public static void reboot2Bootloader() {
        DeviceUtils.reboot2Bootloader();
    }
}