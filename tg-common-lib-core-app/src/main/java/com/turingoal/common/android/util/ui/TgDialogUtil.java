package com.turingoal.common.android.util.ui;

import android.content.Context;
import android.text.TextUtils;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;

import libs.android.turingoal.com.tg_common_lib_core_app.R;

/**
 * 工具类-》dialog
 */
public final class TgDialogUtil {
    private TgDialogUtil() {
        throw new Error("工具类不能实例化！");
    }

    private static MaterialDialog dialog; // 加载框

    /**
     * 显示加载进度条
     */
    public static void showLoadingProgress(final Context context, final String title, final String content) {
        if (dialog == null) {
            dialog = new MaterialDialog.Builder(context).progress(true, 0).progressIndeterminateStyle(false).theme(Theme.DARK).build();
            if (TextUtils.isEmpty(title)) {
                dialog.setTitle(title);
            } else {
                dialog.setTitle("处理中");
            }
            if (TextUtils.isEmpty(content)) {
                dialog.setContent("请等待...");
            } else {
                dialog.setContent(content);
            }
        }
        dialog.show();
    }

    /**
     * 显示加载进度条
     */
    public static void showLoadingProgress(final Context context) {
        showLoadingProgress(context, null, null);
    }

    /**
     * 隐藏加载进度条
     */
    public static void dismissLoadingProgress() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /**
     * 关闭加载进度条
     */
    public static void closeLoadingProgress() {
        if (dialog != null) {
            dialog = null;
        }
    }

    /**
     * 开启确认对话框
     */
    public static void showDialog(final Context context, final String content, final MaterialDialog.SingleButtonCallback positiveCallback) {
        showDialog(context, "提示", content, positiveCallback, null);
    }

    /**
     * 开启对话框
     */
    public static void showDialog(final Context context, final String title, final String content, final MaterialDialog.SingleButtonCallback positiveCallback, final MaterialDialog.SingleButtonCallback negativeCallback) {
        new MaterialDialog.Builder(context)
                .title(title)
                .content(content)
                .positiveText("确定")
                .negativeText("取消")
                .onPositive(positiveCallback)
                .onNegative(negativeCallback)
                .show();
    }

    /**
     * 开启确认对话框
     */
    public static void showConfirmDialog(final Context context, final String title, final String content, final MaterialDialog.SingleButtonCallback callback) {
        new MaterialDialog.Builder(context)
                .title(title)
                .content(content)
                .positiveText("确定")
                .negativeText("取消")
                .icon(context.getDrawable(R.drawable.tg_common_ic_confirm))
                .onPositive(callback).show();
    }

    /**
     * 开启警告确认对话框
     */
    public static void showWarningDialog(final Context context, final String title, final String content, final MaterialDialog.SingleButtonCallback callback) {
        new MaterialDialog.Builder(context)
                .title(title)
                .content(content)
                .positiveText("确定")
                .negativeText("取消")
                .icon(context.getDrawable(R.drawable.tg_common_ic_warning))
                .onPositive(callback).show();
    }
}
