package com.turingoal.common.android.util.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;

import com.blankj.utilcode.util.ScreenUtils;

import static android.Manifest.permission.WRITE_SETTINGS;

/**
 * 屏幕相关工具类
 */
public class TgScreenUtil {
    /**
     * 获取屏幕的宽度（单位：px）
     *
     * @return 屏幕宽px
     */
    public static int getScreenWidth() {
        return ScreenUtils.getScreenWidth();
    }

    /**
     * 获取屏幕的高度（单位：px）
     *
     * @return 屏幕高px
     */
    public static int getScreenHeight() {
        return ScreenUtils.getScreenHeight();
    }

    /**
     * 设置屏幕为横屏
     * <p>还有一种就是在Activity中加属性android:screenOrientation="landscape"</p>
     * <p>不设置Activity的android:configChanges时，切屏会重新调用各个生命周期，切横屏时会执行一次，切竖屏时会执行两次</p>
     * <p>设置Activity的android:configChanges="orientation"时，切屏还是会重新调用各个生命周期，切横、竖屏时只会执行一次</p>
     * <p>设置Activity的android:configChanges="orientation|keyboardHidden|screenSize"（4.0以上必须带最后一个参数）时
     * 切屏不会重新调用各个生命周期，只会执行onConfigurationChanged方法</p>
     *
     * @param activity activity
     */
    public static void setLandscape(final Activity activity) {
        ScreenUtils.setLandscape(activity);
    }

    /**
     * 设置屏幕为竖屏
     *
     * @param activity activity
     */
    public static void setPortrait(final Activity activity) {
        ScreenUtils.setPortrait(activity);
    }

    /**
     * 判断是否横屏
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isLandscape() {
        return ScreenUtils.isLandscape();
    }

    /**
     * 判断是否竖屏
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isPortrait() {
        return ScreenUtils.isPortrait();
    }

    /**
     * 获取屏幕旋转角度
     *
     * @param activity activity
     * @return 屏幕旋转角度
     */
    public static int getScreenRotation(final Activity activity) {
        return ScreenUtils.getScreenRotation(activity);
    }

    /**
     * 获取当前屏幕截图，包含状态栏
     *
     * @param activity activity
     * @return Bitmap
     */
    public static Bitmap captureWithStatusBar(final Activity activity) {
        return ScreenUtils.screenShot(activity, false);
    }

    /**
     * 获取当前屏幕截图，不包含状态栏
     *
     * @param activity activity
     * @return Bitmap
     */
    public static Bitmap captureWithoutStatusBar(final Activity activity) {
        return ScreenUtils.screenShot(activity, true);
    }

    /**
     * 判断是否锁屏
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isScreenLock() {
        return ScreenUtils.isScreenLock();
    }

    /**
     * 设置进入休眠时长
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.WRITE_SETTINGS" />}</p>
     *
     * @param duration 时长
     */
    @RequiresPermission(WRITE_SETTINGS)
    public static void setSleepDuration(final int duration) {
        ScreenUtils.setSleepDuration(duration);
    }

    /**
     * 获取进入休眠时长
     *
     * @return 进入休眠时长，报错返回-123
     */
    public static int getSleepDuration() {
        return ScreenUtils.getSleepDuration();
    }

    /**
     * 获取屏幕密度
     */
    public static float getScreenDensity() {
        return ScreenUtils.getScreenDensity();
    }

    /**
     * 获取屏幕密度 DPI
     */
    public static int getScreenDensityDpi() {
        return ScreenUtils.getScreenDensityDpi();
    }

    /**
     * 设置屏幕为全屏
     */
    public static void setFullScreen(@NonNull final Activity activity) {
        ScreenUtils.setFullScreen(activity);
    }

    /**
     * 设置屏幕为非全屏
     */
    public static void setNonFullScreen(@NonNull final Activity activity) {
        ScreenUtils.setNonFullScreen(activity);
    }

    /**
     * 切换屏幕为全屏与否状态
     */
    public static void toggleFullScreen(@NonNull final Activity activity) {
        ScreenUtils.toggleFullScreen(activity);
    }

    /**
     * 判断屏幕是否为全屏
     */
    public static boolean isFullScreen(@NonNull final Activity activity) {
        return ScreenUtils.isFullScreen(activity);
    }

    /**
     * 截屏
     */
    public static Bitmap screenShot(@NonNull final Activity activity) {
        return ScreenUtils.screenShot(activity);
    }

    /**
     * 截屏
     *
     * @param isDeleteStatusBar True to delete status bar, false otherwise.
     */
    public static Bitmap screenShot(@NonNull final Activity activity, boolean isDeleteStatusBar) {
        return ScreenUtils.screenShot(activity, isDeleteStatusBar);
    }

    /**
     * 判断是否是平板
     */
    public static boolean isTablet() {
        return ScreenUtils.isTablet();
    }

    /**
     * 适配垂直滑动的屏幕
     *
     * @param designWidthInPx The size of design diagram's width, in pixel.
     */
    public static void adaptScreen4VerticalSlide(final Activity activity, final int designWidthInPx) {
        ScreenUtils.adaptScreen4VerticalSlide(activity, designWidthInPx);
    }

    /**
     * 适配水平滑动的屏幕
     *
     * @param designHeightInPx The size of design diagram's height, in pixel.
     */
    public static void adaptScreen4HorizontalSlide(final Activity activity, final int designHeightInPx) {
        ScreenUtils.adaptScreen4HorizontalSlide(activity, designHeightInPx);
    }

    /**
     * 取消适配屏幕
     */
    public static void cancelAdaptScreen(final Activity activity) {
        ScreenUtils.cancelAdaptScreen(activity);
    }

    /**
     * 取消适配屏幕
     */
    public static void cancelAdaptScreen() {
        ScreenUtils.cancelAdaptScreen();
    }

    /**
     * 恢复适配屏幕
     */
    public static void restoreAdaptScreen() {
        ScreenUtils.restoreAdaptScreen();
    }

    /**
     * 是否适配屏幕
     */
    public static boolean isAdaptScreen() {
        return ScreenUtils.isAdaptScreen();
    }
}
