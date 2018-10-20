package com.turingoal.common.android.util.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.PathUtils;

/**
 * 键盘工具类
 */
public final class TgKeyboardUtil {
    private TgKeyboardUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 动态显示软键盘
     */
    public static void showSoftInput(final Activity activity) {
        KeyboardUtils.showSoftInput(activity);
    }

    /**
     * 显示软键盘
     */
    public static void showSoftInputUsingToggle(final Activity activity) {
        KeyboardUtils.showSoftInput(activity);
    }

    /**
     * 动态显示软键盘
     */
    public static void showSoftInput(final View view) {
        KeyboardUtils.showSoftInput(view);
    }

    /**
     * 动态隐藏软键盘
     */
    public static void hideSoftInput(final Activity activity) {
        KeyboardUtils.hideSoftInput(activity);
    }

    /**
     * 动态隐藏软键盘
     */
    public static void hideSoftInput(final View view) {
        KeyboardUtils.hideSoftInput(view);
    }

    /**
     * 隐藏软键盘
     */
    public static void hideSoftInputUsingToggle(final Activity activity) {
        KeyboardUtils.hideSoftInputUsingToggle(activity);
    }


    /**
     * 切换键盘显示与否状态
     */
    public static void toggleSoftInput() {
        KeyboardUtils.toggleSoftInput();
    }


    /**
     * 判断软键盘是否可见
     */
    public static boolean isSoftInputVisible(final Activity activity) {
        return KeyboardUtils.isSoftInputVisible(activity);
    }

    /**
     * 注册软键盘改变监听器
     *
     * @param listener The soft input changed listener.
     */
    public static void registerSoftInputChangedListener(final Activity activity, final KeyboardUtils.OnSoftInputChangedListener listener) {
        KeyboardUtils.registerSoftInputChangedListener(activity, listener);
    }

    /**
     * 注销软键盘改变监听器
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void unregisterSoftInputChangedListener(final Activity activity) {
        KeyboardUtils.unregisterSoftInputChangedListener(activity);
    }

    /**
     * 修复安卓 5497 BUG
     */
    public static void fixAndroidBug5497(final Activity activity) {
        KeyboardUtils.fixAndroidBug5497(activity);
    }

    /**
     * 修复软键盘内存泄漏
     */
    public static void fixSoftInputLeaks(final Activity activity) {
        KeyboardUtils.fixSoftInputLeaks(activity);
    }

    /**
     * 点击屏幕空白区域隐藏软键盘
     */
    public static void clickBlankArea2HideSoftInput() {
        KeyboardUtils.clickBlankArea2HideSoftInput();
    }

    /**
     * 点击其他位置是否将要隐藏输入键盘(editview)
     */
    public static boolean isShouldHideInput(final View v, final MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            v.getLocationInWindow(leftTop);
            final int left = leftTop[0];
            final int top = leftTop[1];
            final int right = left + v.getWidth();
            final int bottom = top + v.getHeight();
            return !(event.getX() > left && event.getX() < right && event.getY() > top && event.getY() < bottom);
        }
        return false;
    }
}
