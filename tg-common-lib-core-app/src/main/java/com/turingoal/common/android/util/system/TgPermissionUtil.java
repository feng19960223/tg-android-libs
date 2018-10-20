package com.turingoal.common.android.util.system;

import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.PermissionUtils;

import java.util.List;

/**
 * 权限工具类
 */
public final class TgPermissionUtil {
    private TgPermissionUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 获取应用权限
     */
    public static List<String> getPermissions() {
        return PermissionUtils.getPermissions();
    }

    /**
     * 获取应用权限
     */
    public static List<String> getPermissions(final String packageName) {
        return PermissionUtils.getPermissions(packageName);
    }

    /**
     * 判断权限是否被授予
     */
    public static boolean isGranted(final String... permissions) {
        return PermissionUtils.isGranted(permissions);
    }

    /**
     * 打开应用具体设置
     */
    public static void launchAppDetailsSettings() {
        PermissionUtils.launchAppDetailsSettings();
    }

    /**
     * 设置请求权限
     */
    public static PermissionUtils permission(@PermissionConstants.Permission final String... permissions) {
        return PermissionUtils.permission(permissions);
    }
}