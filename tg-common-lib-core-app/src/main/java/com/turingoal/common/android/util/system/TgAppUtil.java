package com.turingoal.common.android.util.system;

import android.app.Activity;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.Utils;

import java.io.File;
import java.util.List;

/**
 * App工具类
 */
public final class TgAppUtil {
    private TgAppUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 注册 App 前后台切换监听器
     */
    public static void registerAppStatusChangedListener(@NonNull final Object obj, @NonNull final Utils.OnAppStatusChangedListener listener) {
        AppUtils.registerAppStatusChangedListener(obj, listener);
    }

    /**
     * 注销 App 前后台切换监听器
     */
    public static void unregisterAppStatusChangedListener(@NonNull final Object obj) {
        AppUtils.unregisterAppStatusChangedListener(obj);
    }

    /**
     * 安装 App（支持 8.0）
     *
     * @param filePath The path of file.
     */
    public static void installApp(final String filePath) {
        AppUtils.installApp(filePath);
    }

    /**
     * 安装 App（支持 8.0）
     *
     * @param file The file.
     */
    public static void installApp(final File file) {
        AppUtils.installApp(file);
    }

    /**
     * 安装 App（支持 8.0）
     *
     * @param activity    The activity.
     * @param filePath    The path of file.
     * @param requestCode If &gt;= 0, this code will be returned in
     *                    onActivityResult() when the activity exits.
     */
    public static void installApp(final Activity activity, final String filePath, final int requestCode) {
        AppUtils.installApp(activity, filePath, requestCode);
    }

    /**
     * 安装 App（支持 8.0）
     *
     * @param activity    The activity.
     * @param file        The file.
     * @param requestCode If &gt;= 0, this code will be returned in
     *                    onActivityResult() when the activity exits.
     */
    public static void installApp(final Activity activity, final File file, final int requestCode) {
        AppUtils.installApp(activity, file, requestCode);
    }

    /**
     * 静默安装 App
     *
     * @param filePath The path of file.
     */
    public static boolean installAppSilent(final String filePath) {
        return AppUtils.installAppSilent(filePath);
    }

    /**
     * 静默安装 App
     *
     * @param file The file.
     */
    public static boolean installAppSilent(final File file) {
        return AppUtils.installAppSilent(file);
    }

    /**
     * 静默安装 App
     *
     * @param filePath The path of file.
     * @param params   The params of installation(e.g.,<code>-r</code>, <code>-s</code>).
     */
    public static boolean installAppSilent(final String filePath, final String params) {
        return AppUtils.installAppSilent(filePath, params);
    }

    /**
     * 静默安装 App
     *
     * @param file   The file.
     * @param params The params of installation(e.g.,<code>-r</code>, <code>-s</code>).
     */
    public static boolean installAppSilent(final File file, final String params) {
        return AppUtils.installAppSilent(file, params);
    }

    /**
     * 静默安装 App
     *
     * @param file     The file.
     * @param params   The params of installation(e.g.,<code>-r</code>, <code>-s</code>).
     * @param isRooted True to use root, false otherwise.
     */
    public static boolean installAppSilent(final File file, final String params, final boolean isRooted) {
        return AppUtils.installAppSilent(file, params, isRooted);
    }

    /**
     * 卸载 App
     *
     * @param packageName The name of the package.
     */
    public static void uninstallApp(final String packageName) {
        AppUtils.uninstallApp(packageName);
    }

    /**
     * 卸载 App
     *
     * @param activity    The activity.
     * @param packageName The name of the package.
     * @param requestCode If &gt;= 0, this code will be returned in
     *                    onActivityResult() when the activity exits.
     */
    public static void uninstallApp(final Activity activity, final String packageName, final int requestCode) {
        AppUtils.uninstallApp(activity, packageName, requestCode);
    }

    /**
     * 静默卸载 App
     *
     * @param packageName The name of the package.
     */
    public static boolean uninstallAppSilent(final String packageName) {
        return AppUtils.uninstallAppSilent(packageName);
    }

    /**
     * 静默卸载 App
     *
     * @param packageName The name of the package.
     * @param isKeepData  Is keep the data.
     */
    public static boolean uninstallAppSilent(final String packageName, final boolean isKeepData) {
        return AppUtils.uninstallAppSilent(packageName, isKeepData);
    }

    /**
     * 静默卸载 App
     *
     * @param packageName The name of the package.
     * @param isKeepData  Is keep the data.
     * @param isRooted    True to use root, false otherwise.
     */
    public static boolean uninstallAppSilent(final String packageName, final boolean isKeepData, final boolean isRooted) {
        return AppUtils.uninstallAppSilent(packageName, isKeepData, isRooted);
    }

    /**
     * 判断 App 是否安装
     *
     * @param packageName The name of the package.
     */
    public static boolean isAppInstalled(@NonNull final String packageName) {
        return AppUtils.isAppInstalled(packageName);
    }

    /**
     * 判断 App 是否安装
     *
     * @param action   The Intent action, such as ACTION_VIEW.
     * @param category The desired category.
     */
    public static boolean isAppInstalled(@NonNull final String action, @NonNull final String category) {
        return AppUtils.isAppInstalled(action, category);
    }

    /**
     * 判断 App 是否有 root 权限
     */
    public static boolean isAppRoot() {
        return AppUtils.isAppRoot();
    }


    /**
     * 判断 App 是否是 Debug 版本
     */
    public static boolean isAppDebug() {
        return AppUtils.isAppDebug();
    }

    /**
     * 判断 App 是否是 Debug 版本
     *
     * @param packageName The name of the package.
     */
    public static boolean isAppDebug(final String packageName) {
        return AppUtils.isAppDebug(packageName);
    }

    /**
     * 判断 App 是否是系统应用
     */
    public static boolean isAppSystem() {
        return AppUtils.isAppSystem();
    }

    /**
     * 判断 App 是否是系统应用
     *
     * @param packageName The name of the package.
     */
    public static boolean isAppSystem(final String packageName) {
        return AppUtils.isAppSystem(packageName);
    }

    /**
     * 判断 App 是否处于前台
     */
    public static boolean isAppForeground() {
        return AppUtils.isAppForeground();
    }

    /**
     * 判断 App 是否处于前台
     *
     * @param packageName The name of the package.
     */
    public static boolean isAppForeground(@NonNull final String packageName) {
        return AppUtils.isAppForeground(packageName);
    }

    /**
     * 打开 App
     *
     * @param packageName The name of the package.
     */
    public static void launchApp(final String packageName) {
        AppUtils.launchApp(packageName);
    }

    /**
     * 打开 App
     *
     * @param activity    The activity.
     * @param packageName The name of the package.
     * @param requestCode If &gt;= 0, this code will be returned in
     *                    onActivityResult() when the activity exits.
     */
    public static void launchApp(final Activity activity, final String packageName, final int requestCode) {
        AppUtils.launchApp(activity, packageName, requestCode);
    }

    /*
     * 重启 App
     */
    public static void relaunchApp() {
        AppUtils.relaunchApp();
    }

    /**
     * 打开 App 具体设置
     */
    public static void launchAppDetailsSettings() {
        AppUtils.launchAppDetailsSettings();
    }

    /**
     * 打开 App 具体设置
     *
     * @param packageName The name of the package.
     */
    public static void launchAppDetailsSettings(final String packageName) {
        AppUtils.launchAppDetailsSettings(packageName);
    }

    /**
     * 关闭应用
     */
    public static void exitApp() {
        AppUtils.exitApp();
    }

    /**
     * 获取 App 图标
     */
    public static Drawable getAppIcon() {
        return AppUtils.getAppIcon();
    }

    /**
     * 获取 App 图标
     *
     * @param packageName The name of the package.
     */
    public static Drawable getAppIcon(final String packageName) {
        return AppUtils.getAppIcon(packageName);
    }

    /**
     * 获取 App 包名
     */
    public static String getAppPackageName() {
        return AppUtils.getAppPackageName();
    }

    /**
     * 获取 App 名称
     */
    public static String getAppName() {
        return AppUtils.getAppName();
    }

    /**
     * 获取 App 名称
     *
     * @param packageName The name of the package.
     */
    public static String getAppName(final String packageName) {
        return AppUtils.getAppName(packageName);
    }

    /**
     * 获取 App 路径
     */
    public static String getAppPath() {
        return AppUtils.getAppPath();
    }

    /**
     * 获取 App 路径
     *
     * @param packageName The name of the package.
     */
    public static String getAppPath(final String packageName) {
        return AppUtils.getAppPath(packageName);
    }

    /*获取 App 版本号
     */
    public static String getAppVersionName() {
        return AppUtils.getAppVersionName();
    }

    /**
     * 获取 App 版本号
     *
     * @param packageName The name of the package.
     */
    public static String getAppVersionName(final String packageName) {
        return AppUtils.getAppVersionName(packageName);
    }

    /**
     * 获取 App 版本码
     */
    public static int getAppVersionCode() {
        return AppUtils.getAppVersionCode();
    }

    /**
     * 获取 App 版本码.
     *
     * @param packageName The name of the package.
     */
    public static int getAppVersionCode(final String packageName) {
        return AppUtils.getAppVersionCode(packageName);
    }

    /**
     * 获取 App 签名
     */
    public static Signature[] getAppSignature() {
        return AppUtils.getAppSignature();
    }

    /**
     * 获取 App 签名
     *
     * @param packageName The name of the package.
     */
    public static Signature[] getAppSignature(final String packageName) {
        return AppUtils.getAppSignature(packageName);
    }

    /**
     * 获取应用签名的的 SHA1 值
     */
    public static String getAppSignatureSHA1() {
        return AppUtils.getAppSignatureSHA1();
    }

    /**
     * 获取应用签名的的 SHA1 值
     */
    public static String getAppSignatureSHA1(final String packageName) {
        return AppUtils.getAppSignatureSHA1(packageName);
    }

    /**
     * 获取应用签名的的 SHA256 值
     */
    public static String getAppSignatureSHA256() {
        return AppUtils.getAppSignatureSHA256();
    }

    /**
     * 获取应用签名的的 SHA256 值
     */
    public static String getAppSignatureSHA256(final String packageName) {
        return AppUtils.getAppSignatureSHA256(packageName);
    }

    /**
     * 获取应用签名的的 MD5 值
     */
    public static String getAppSignatureMD5() {
        return AppUtils.getAppSignatureMD5();
    }

    /**
     * 获取应用签名的的 MD5 值
     */
    public static String getAppSignatureMD5(final String packageName) {
        return AppUtils.getAppSignatureMD5();
    }

    /**
     * 获取 App 信息
     * <ul>
     * <li>name of package</li>
     * <li>icon</li>
     * <li>name</li>
     * <li>path of package</li>
     * <li>version name</li>
     * <li>version code</li>
     * <li>is system</li>
     * </ul>
     */
    public static AppUtils.AppInfo getAppInfo() {
        return AppUtils.getAppInfo();
    }

    /**
     * 获取 App 信息
     *
     * @param packageName The name of the package.
     */
    public static AppUtils.AppInfo getAppInfo(final String packageName) {
        return AppUtils.getAppInfo(packageName);
    }

    /**
     * 获取所有已安装 App 信息
     */
    public static List<AppUtils.AppInfo> getAppsInfo() {
        return AppUtils.getAppsInfo();
    }
}

