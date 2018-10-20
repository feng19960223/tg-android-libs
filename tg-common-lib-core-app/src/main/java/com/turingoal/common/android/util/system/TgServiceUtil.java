package com.turingoal.common.android.util.system;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.text.TextUtils;

import com.blankj.utilcode.util.ServiceUtils;
import com.blankj.utilcode.util.Utils;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

/**
 * 服务工具类
 */
public final class TgServiceUtil {
    private TgServiceUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 获取所有运行的服务
     */
    public static Set getAllRunningServices() {
        return ServiceUtils.getAllRunningServices();
    }

    /**
     * 启动服务
     *
     * @param className The name of class.
     */
    public static void startService(final String className) {
        ServiceUtils.startService(className);
    }

    /**
     * 启动服务
     *
     * @param cls The service class.
     */
    public static void startService(final Class<?> cls) {
        ServiceUtils.startService(cls);
    }

    /**
     * 停止服务
     *
     * @param className The name of class.
     */
    public static boolean stopService(final String className) {
        return ServiceUtils.stopService(className);
    }

    /**
     * 停止服务
     *
     * @param cls The name of class.
     */
    public static boolean stopService(final Class<?> cls) {
        return ServiceUtils.stopService(cls);
    }

    /**
     * 绑定服务
     *
     * @param className The name of class.
     * @param conn      The ServiceConnection object.
     * @param flags     Operation options for the binding.
     *                  <ul>
     *                  <li>0</li>
     *                  <li>{@link Context#BIND_AUTO_CREATE}</li>
     *                  <li>{@link Context#BIND_DEBUG_UNBIND}</li>
     *                  <li>{@link Context#BIND_NOT_FOREGROUND}</li>
     *                  <li>{@link Context#BIND_ABOVE_CLIENT}</li>
     *                  <li>{@link Context#BIND_ALLOW_OOM_MANAGEMENT}</li>
     *                  <li>{@link Context#BIND_WAIVE_PRIORITY}</li>
     *                  </ul>
     */
    public static void bindService(final String className, final ServiceConnection conn, final int flags) {
        ServiceUtils.bindService(className, conn, flags);
    }

    /**
     * 绑定服务
     *
     * @param cls   The service class.
     * @param conn  The ServiceConnection object.
     * @param flags Operation options for the binding.
     *              <ul>
     *              <li>0</li>
     *              <li>{@link Context#BIND_AUTO_CREATE}</li>
     *              <li>{@link Context#BIND_DEBUG_UNBIND}</li>
     *              <li>{@link Context#BIND_NOT_FOREGROUND}</li>
     *              <li>{@link Context#BIND_ABOVE_CLIENT}</li>
     *              <li>{@link Context#BIND_ALLOW_OOM_MANAGEMENT}</li>
     *              <li>{@link Context#BIND_WAIVE_PRIORITY}</li>
     *              </ul>
     */
    public static void bindService(final Class<?> cls, final ServiceConnection conn, final int flags) {
        ServiceUtils.bindService(cls, conn, flags);
    }

    /**
     * 解绑服务.
     *
     * @param conn The ServiceConnection object.
     */
    public static void unbindService(final ServiceConnection conn) {
        ServiceUtils.unbindService(conn);
    }

    /**
     * 判断服务是否运行
     *
     * @param cls The service class.
     */
    public static boolean isServiceRunning(final Class<?> cls) {
        return ServiceUtils.isServiceRunning(cls);
    }

    /**
     * 判断服务是否运行
     *
     * @param className The name of class.
     */
    public static boolean isServiceRunning(final String className) {
        return ServiceUtils.isServiceRunning(className);
    }
}