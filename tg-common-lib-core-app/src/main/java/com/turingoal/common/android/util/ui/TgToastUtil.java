package com.turingoal.common.android.util.ui;

import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;

/**
 * Toast吐司工具类
 */
public class TgToastUtil {
    private TgToastUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 设置吐司位置
     */
    public static void setGravity(final int gravity, final int xOffset, final int yOffset) {
        ToastUtils.setGravity(gravity, xOffset, yOffset);
    }

    /**
     * 设置背景颜色
     */
    public static void setBgColor(@ColorInt final int backgroundColor) {
        ToastUtils.setBgColor(backgroundColor);
    }

    /**
     * 设置背景资源
     */
    public static void setBgResource(@DrawableRes final int bgResource) {
        ToastUtils.setBgResource(bgResource);
    }

    /**
     * 设置消息颜色
     */
    public static void setMsgColor(@ColorInt final int msgColor) {
        ToastUtils.setMsgColor(msgColor);

    }

    /**
     * 设置消息字体大小
     */
    public static void setMsgTextSize(final int textSize) {
        ToastUtils.setMsgColor(textSize);
    }

    /**
     * 显示短时吐司
     */
    public static void showShort(final CharSequence text) {
        ToastUtils.showShort(text);
    }


    /**
     * 显示短时吐司
     */
    public static void showShort(@StringRes final int resId) {
        ToastUtils.showShort(resId);
    }

    /**
     * 显示短时吐司
     */
    public static void showShort(@StringRes final int resId, final Object... args) {
        ToastUtils.showShort(resId, args);
    }

    /**
     * 显示短时吐司
     */
    public static void showShort(final String format, final Object... args) {
        ToastUtils.showShort(format, args);
    }

    /**
     * 显示长时吐司
     */
    public static void showLong(final CharSequence text) {
        ToastUtils.showLong(text);
    }

    /**
     * 显示长时吐司
     */
    public static void showLong(@StringRes final int resId) {
        ToastUtils.showLong(resId);
    }

    /**
     * 显示长时吐司
     */
    public static void showLong(@StringRes final int resId, final Object... args) {
        ToastUtils.showLong(resId, args);
    }

    /**
     * 显示长时吐司
     */
    public static void showLong(final String format, final Object... args) {
        ToastUtils.showLong(format, args);
    }


    /**
     * 显示短时自定义吐司
     */
    public static View showCustomShort(@LayoutRes final int layoutId) {
        return ToastUtils.showCustomShort(layoutId);
    }

    /**
     * 显示长时自定义吐司
     */
    public static View showCustomLong(@LayoutRes final int layoutId) {
        return ToastUtils.showCustomLong(layoutId);
    }

    /**
     * 取消吐司显示
     */
    public static void cancel() {
        ToastUtils.cancel();
    }
}
