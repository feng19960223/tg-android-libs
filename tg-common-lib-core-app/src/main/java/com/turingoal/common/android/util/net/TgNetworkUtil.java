package com.turingoal.common.android.util.net;

import android.support.annotation.RequiresPermission;

import com.blankj.utilcode.util.NetworkUtils;

import static android.Manifest.permission.ACCESS_NETWORK_STATE;
import static android.Manifest.permission.ACCESS_WIFI_STATE;
import static android.Manifest.permission.CHANGE_WIFI_STATE;
import static android.Manifest.permission.INTERNET;
import static android.Manifest.permission.MODIFY_PHONE_STATE;

/**
 * 网络相关工具类
 */
public class TgNetworkUtil {
    private TgNetworkUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 打开网络设置界面
     */
    public static void openWirelessSettings() {
        NetworkUtils.openWirelessSettings();
    }

    /**
     * 判断网络是否连接
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>}</p>
     */
    @RequiresPermission(ACCESS_NETWORK_STATE)
    public static boolean isConnected() {
        return NetworkUtils.isConnected();
    }

    /**
     * 判断网络是否可用
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.INTERNET"/>}</p>
     * y@code true}: 可用<br>{@code false}: 不可用
     */
    @RequiresPermission(INTERNET)
    public static boolean isAvailableByPing() {
        return NetworkUtils.isAvailableByPing();
    }

    /**
     * 判断网络是否是4G
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>}</p>
     */
    @RequiresPermission(ACCESS_NETWORK_STATE)
    public static boolean is4G() {
        return NetworkUtils.is4G();
    }

    /**
     * 判断wifi是否打开
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>}</p>
     */
    @RequiresPermission(ACCESS_WIFI_STATE)
    public static boolean getWifiEnabled() {
        return NetworkUtils.getWifiEnabled();
    }

    /**
     * 打开或关闭wifi
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.CHANGE_WIFI_STATE"/>}</p>
     *
     * @param enabled {@code true}: 打开<br>{@code false}: 关闭
     */
    @RequiresPermission(CHANGE_WIFI_STATE)
    public static void setWifiEnabled(final boolean enabled) {
        NetworkUtils.setWifiEnabled(enabled);
    }

    /**
     * 判断wifi是否连接状态
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>}</p>
     */
    @RequiresPermission(ACCESS_NETWORK_STATE)
    public static boolean isWifiConnected() {
        return NetworkUtils.isWifiConnected();
    }

    /**
     * 判断wifi数据是否可用
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>}</p>
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.INTERNET"/>}</p>
     */
    @RequiresPermission(allOf = {ACCESS_WIFI_STATE, INTERNET})
    public static boolean isWifiAvailable() {
        return NetworkUtils.isWifiAvailable();
    }

    /**
     * 获取网络运营商名称
     * <p>中国移动、如中国联通、中国电信</p>
     *
     * @return 运营商名称
     */
    public static String getNetworkOperatorName() {
        return NetworkUtils.getNetworkOperatorName();
    }

    /**
     * 获取当前网络类型
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>}</p>
     *
     * @return 网络类型
     * <ul>
     * <li>{@link NetworkUtils.NetworkType#NETWORK_WIFI   } </li>
     * <li>{@link NetworkUtils.NetworkType#NETWORK_4G     } </li>
     * <li>{@link NetworkUtils.NetworkType#NETWORK_3G     } </li>
     * <li>{@link NetworkUtils.NetworkType#NETWORK_2G     } </li>
     * <li>{@link NetworkUtils.NetworkType#NETWORK_UNKNOWN} </li>
     * <li>{@link NetworkUtils.NetworkType#NETWORK_NO     } </li>
     * </ul>
     */
    @RequiresPermission(ACCESS_NETWORK_STATE)
    public static NetworkUtils.NetworkType getNetworkType() {
        return NetworkUtils.getNetworkType();
    }

    /**
     * 获取IP地址
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.INTERNET"/>}</p>
     *
     * @param useIPv4 是否用IPv4
     * @return IP地址
     */
    @RequiresPermission(INTERNET)
    public static String getIPAddress(final boolean useIPv4) {
        return NetworkUtils.getIPAddress(useIPv4);
    }

    /**
     * 获取域名ip地址
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.INTERNET"/>}</p>
     *
     * @param domain 域名
     * @return ip地址
     */
    @RequiresPermission(INTERNET)
    public static String getDomainAddress(final String domain) {
        return NetworkUtils.getDomainAddress(domain);
    }


    /**
     * 判断移动数据是否打开
     */
    public static boolean getMobileDataEnabled() {
        return NetworkUtils.getMobileDataEnabled();
    }

    /**
     * 打开或关闭移动数据
     */
    @RequiresPermission(MODIFY_PHONE_STATE)
    public static void setMobileDataEnabled(final boolean enabled) {
        NetworkUtils.setMobileDataEnabled(enabled);
    }

    /**
     * 判断网络是否是移动数据
     */
    @RequiresPermission(ACCESS_NETWORK_STATE)
    public static boolean isMobileData() {
        return NetworkUtils.isMobileData();
    }

    /**
     * 根据 WiFi 获取网络 IP 地址
     */
    @RequiresPermission(ACCESS_WIFI_STATE)
    public static String getIpAddressByWifi() {
        return NetworkUtils.getIpAddressByWifi();
    }

    /**
     * 根据 WiFi 获取网关 IP 地址
     */
    @RequiresPermission(ACCESS_WIFI_STATE)
    public static String getGatewayByWifi() {
        return NetworkUtils.getGatewayByWifi();
    }

    /**
     * 根据 WiFi 获取子网掩码 IP 地址
     */
    @RequiresPermission(ACCESS_WIFI_STATE)
    public static String getNetMaskByWifi() {
        return NetworkUtils.getNetMaskByWifi();
    }

    /**
     * 根据 WiFi 获取服务端 IP 地址
     */
    @RequiresPermission(ACCESS_WIFI_STATE)
    public static String getServerAddressByWifi() {
        return NetworkUtils.getServerAddressByWifi();
    }
}
