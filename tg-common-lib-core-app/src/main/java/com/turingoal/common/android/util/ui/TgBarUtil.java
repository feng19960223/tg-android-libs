package com.turingoal.common.android.util.ui;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.RequiresPermission;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.Window;

import com.blankj.utilcode.util.BarUtils;

import static android.Manifest.permission.EXPAND_STATUS_BAR;

/**
 * 通知栏、状态栏相关
 */
public class TgBarUtil {
    private TgBarUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 获取状态栏高度（px）
     */
    public static int getStatusBarHeight() {
        return BarUtils.getStatusBarHeight();
    }

    /**
     * 设置状态栏是否可见
     */
    public static void setStatusBarVisibility(@NonNull final Activity activity, final boolean isVisible) {
        BarUtils.setStatusBarVisibility(activity, isVisible);
    }

    /**
     * 设置状态栏是否可见
     */
    public static void setStatusBarVisibility(@NonNull final Window window, final boolean isVisible) {
        BarUtils.setStatusBarVisibility(window, isVisible);
    }

    /**
     * 判断状态栏是否可见
     */
    public static boolean isStatusBarVisible(@NonNull final Activity activity) {
        return BarUtils.isStatusBarVisible(activity);
    }

    /**
     * 设置状态栏是否为浅色模式
     */
    public static void setStatusBarLightMode(@NonNull final Activity activity, final boolean isLightMode) {
        BarUtils.setStatusBarLightMode(activity, isLightMode);
    }

    /**
     * Set the status bar's light mode.
     *
     * @param window      The window.
     * @param isLightMode True to set status bar light mode, false otherwise.
     */
    public static void setStatusBarLightMode(@NonNull final Window window, final boolean isLightMode) {
        BarUtils.setStatusBarLightMode(window, isLightMode);
    }

    /**
     * 为 view 增加 MarginTop 为状态栏高度
     */
    public static void addMarginTopEqualStatusBarHeight(@NonNull View view) {
        BarUtils.addMarginTopEqualStatusBarHeight(view);
    }

    /**
     * 为 view 减少 MarginTop 为状态栏高度
     */
    public static void subtractMarginTopEqualStatusBarHeight(@NonNull View view) {
        BarUtils.subtractMarginTopEqualStatusBarHeight(view);

    }

    /**
     * 设置状态栏颜色
     *
     * @param color The status bar's color.
     */
    public static void setStatusBarColor(@NonNull final Activity activity, @ColorInt final int color) {
        BarUtils.setStatusBarColor(activity, color);
    }

    /**
     * 设置状态栏颜色
     *
     * @param color The status bar's color.
     * @param alpha The status bar's alpha which isn't the same as alpha in the color.
     */
    public static void setStatusBarColor(@NonNull final Activity activity, @ColorInt final int color, @IntRange(from = 0, to = 255) final int alpha) {
        BarUtils.setStatusBarColor(activity, color, alpha);
    }

    /**
     * 设置状态栏颜色
     *
     * @param color   The status bar's color.
     * @param alpha   The status bar's alpha which isn't the same as alpha in the color.
     * @param isDecor True to add fake status bar in DecorView,
     *                false to add fake status bar in ContentView.
     */
    public static void setStatusBarColor(@NonNull final Activity activity,
                                         @ColorInt final int color,
                                         @IntRange(from = 0, to = 255) final int alpha,
                                         final boolean isDecor) {
        BarUtils.setStatusBarColor(activity, color, alpha, isDecor);
    }

    /**
     * 设置状态栏颜色
     *
     * @param fakeStatusBar The fake status bar view.
     * @param color         The status bar's color.
     */
    public static void setStatusBarColor(@NonNull final View fakeStatusBar, @ColorInt final int color) {
        BarUtils.setStatusBarColor(fakeStatusBar, color);
    }

    /**
     * 设置状态栏颜色
     *
     * @param color The status bar's color.
     * @param alpha The status bar's alpha which isn't the same as alpha in the color.
     */
    public static void setStatusBarColor(@NonNull final View fakeStatusBar, @ColorInt final int color, @IntRange(from = 0, to = 255) final int alpha) {
        BarUtils.setStatusBarColor(fakeStatusBar, color, alpha);
    }

    /**
     * 设置状态栏透明度
     */
    public static void setStatusBarAlpha(@NonNull final Activity activity) {
        BarUtils.setStatusBarAlpha(activity);
    }

    /**
     * 设置状态栏透明度
     */
    public static void setStatusBarAlpha(@NonNull final Activity activity, @IntRange(from = 0, to = 255) final int alpha) {
        BarUtils.setStatusBarAlpha(activity, alpha);
        ;
    }

    /**
     * 设置状态栏透明度
     *
     * @param isDecor True to add fake status bar in DecorView,
     *                false to add fake status bar in ContentView.
     */
    public static void setStatusBarAlpha(@NonNull final Activity activity, @IntRange(from = 0, to = 255) final int alpha, final boolean isDecor) {
        BarUtils.setStatusBarAlpha(activity, alpha, isDecor);
    }

    /**
     * 设置状态栏透明度
     */
    public static void setStatusBarAlpha(@NonNull final View fakeStatusBar) {
        BarUtils.setStatusBarAlpha(fakeStatusBar);
    }

    /**
     * 设置状态栏透明度
     */
    public static void setStatusBarAlpha(@NonNull final View fakeStatusBar, @IntRange(from = 0, to = 255) final int alpha) {
        BarUtils.setStatusBarAlpha(fakeStatusBar, alpha);
    }

    /**
     * 为 DrawerLayout 设置状态栏颜色
     *
     * @param activity      The activity.
     * @param drawer        The DrawLayout.
     * @param fakeStatusBar The fake status bar view.
     * @param color         The status bar's color.
     * @param isTop         True to set DrawerLayout at the top layer, false otherwise.
     */
    public static void setStatusBarColor4Drawer(@NonNull final Activity activity,
                                                @NonNull final DrawerLayout drawer,
                                                @NonNull final View fakeStatusBar,
                                                @ColorInt final int color,
                                                final boolean isTop) {
        BarUtils.setStatusBarColor4Drawer(activity, drawer, fakeStatusBar, color, isTop);
    }

    /**
     * 为 DrawerLayout 设置状态栏颜色
     *
     * @param activity      The activity.
     * @param drawer        The DrawLayout.
     * @param fakeStatusBar The fake status bar view.
     * @param color         The status bar's color.
     * @param alpha         The status bar's alpha which isn't the same as alpha in the color.
     * @param isTop         True to set DrawerLayout at the top layer, false otherwise.
     */
    public static void setStatusBarColor4Drawer(@NonNull final Activity activity,
                                                @NonNull final DrawerLayout drawer,
                                                @NonNull final View fakeStatusBar,
                                                @ColorInt final int color,
                                                @IntRange(from = 0, to = 255) final int alpha,
                                                final boolean isTop) {
        BarUtils.setStatusBarColor4Drawer(activity, drawer, fakeStatusBar, color, alpha, isTop);
    }

    /**
     * 设置状态栏透明度
     *
     * @param activity      The activity.
     * @param drawer        drawerLayout
     * @param fakeStatusBar The fake status bar view.
     * @param isTop         True to set DrawerLayout at the top layer, false otherwise.
     */
    public static void setStatusBarAlpha4Drawer(@NonNull final Activity activity, @NonNull final DrawerLayout drawer, @NonNull final View fakeStatusBar, final boolean isTop) {
        BarUtils.setStatusBarAlpha4Drawer(activity, drawer, fakeStatusBar, isTop);
    }

    /**
     * 设置状态栏透明度
     *
     * @param activity      The activity.
     * @param drawer        drawerLayout
     * @param fakeStatusBar The fake status bar view.
     * @param alpha         The status bar's alpha.
     * @param isTop         True to set DrawerLayout at the top layer, false otherwise.
     */
    public static void setStatusBarAlpha4Drawer(@NonNull final Activity activity, @NonNull final DrawerLayout drawer, @NonNull final View fakeStatusBar, @IntRange(from = 0, to = 255) final int alpha, final boolean isTop) {
        BarUtils.setStatusBarAlpha4Drawer(activity, drawer, fakeStatusBar, alpha, isTop);
    }


    ///////////////////////////////////////////////////////////////////////////
    // action bar
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 获取 ActionBar 高度
     */
    public static int getActionBarHeight() {
        return BarUtils.getActionBarHeight();
    }

    ///////////////////////////////////////////////////////////////////////////
    // notification bar
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 设置通知栏是否可见
     */
    @RequiresPermission(EXPAND_STATUS_BAR)
    public static void setNotificationBarVisibility(final boolean isVisible) {
        BarUtils.setNotificationBarVisibility(isVisible);
    }

    ///////////////////////////////////////////////////////////////////////////
    // navigation bar
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 获取导航栏高度
     */
    public static int getNavBarHeight() {
        return BarUtils.getNavBarHeight();
    }

    /**
     * 设置导航栏是否可见
     */
    public static void setNavBarVisibility(@NonNull final Activity activity, boolean isVisible) {
        BarUtils.setNavBarVisibility(activity, isVisible);
    }

    /**
     * 设置导航栏是否可见
     */
    public static void setNavBarVisibility(@NonNull final Window window, boolean isVisible) {
        BarUtils.setNavBarVisibility(window, isVisible);
    }

    /**
     * 设置导航栏颜色
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    public static void setNavBarColor(@NonNull final Activity activity, @ColorInt final int color) {
        BarUtils.setNavBarColor(activity, color);
    }

    /**
     * 设置导航栏颜色
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    public static void setNavBarColor(@NonNull final Window window, @ColorInt final int color) {
        BarUtils.setNavBarColor(window, color);
    }

    /**
     * 获取导航栏颜色
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    public static int getNavBarColor(@NonNull final Activity activity) {
        return BarUtils.getNavBarColor(activity);
    }

    /**
     * 获取导航栏颜色
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    public static int getNavBarColor(@NonNull final Window window) {
        return BarUtils.getNavBarColor(window);
    }

    /**
     * 判断导航栏是否可见
     */
    public static boolean isNavBarVisible(@NonNull final Activity activity) {
        return BarUtils.isNavBarVisible(activity);
    }

    /**
     * 判断导航栏是否可见
     */
    public static boolean isNavBarVisible(@NonNull final Window window) {
        return BarUtils.isNavBarVisible(window);
    }

    /**
     * Return whether the navigation bar visible.
     */
    public static boolean isSupportNavBar() {
        return BarUtils.isSupportNavBar();
    }
}




