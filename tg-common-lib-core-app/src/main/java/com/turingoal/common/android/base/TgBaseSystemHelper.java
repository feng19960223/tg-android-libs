package com.turingoal.common.android.base;

import android.app.Activity;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.turingoal.common.android.util.ui.TgDialogUtil;
import com.turingoal.common.android.util.ui.TgToastUtil;

import libs.android.turingoal.com.tg_common_lib_core_app.R;

/**
 * 公用方法
 */
public abstract class TgBaseSystemHelper {
    private static long exitTime = 0; // 退出系统
    private static final long EXIT_DELAY_TIME = 2000; // 再按一次退出系统，间隔时间

    /**
     * 再按一次退出系统
     */
    public static void dbClickExit() {
        if ((System.currentTimeMillis() - exitTime) > EXIT_DELAY_TIME) {
            TgToastUtil.showShort(TgBaseApplication.getContext().getString(R.string.hint_common_double_click_exit));
            exitTime = System.currentTimeMillis();
        } else {
            TgBaseApplication.clearActivitys(); // 清除Activity栈
            System.exit(0);
        }
    }

    /**
     * 跳转后关闭页面回调
     */
    public static NavCallback navAndFinishCallback(final Activity context) {
        return new NavCallback() {
            @Override
            public void onArrival(final Postcard postcard) {
                TgDialogUtil.closeLoadingProgress(); //关闭进度条
                context.finish();
            }
        };
    }

    /**
     * 处理跳转
     */
    public static void handleIntent(final String path) {
        ARouter.getInstance().build(path).navigation();
    }

    /**
     * 处理跳转，关闭当前页面
     */
    public static void handleIntentAndFinish(final String path, final Activity mContext) {
        ARouter.getInstance().build(path).navigation(mContext, navAndFinishCallback(mContext));
    }

    /**
     * 处理跳转
     */
    public static void handleIntent(final String path, final Activity mContext, final int requestCode) {
        ARouter.getInstance().build(path).navigation(mContext, requestCode);
    }

    /**
     * 处理跳转，关闭当前页面
     */
    public static void handleIntentAndFinish(final String path, final Activity mContext, final int requestCode) {
        ARouter.getInstance().build(path).navigation(mContext, requestCode, navAndFinishCallback(mContext));
    }

    /**
     * 处理跳转
     */
    public static void handleIntent(final String path, final Activity mContext, final int requestCode, final NavigationCallback callback) {
        ARouter.getInstance().build(path).navigation(mContext, requestCode, callback);
    }

    /**
     * 处理跳转,带参数过去
     */
    public static void handleIntentWithObj(final String path, final String objName, final Object obj) {
        ARouter.getInstance().build(path).withObject(objName, obj).navigation();
    }

    /**
     * 处理跳转，关闭当前页面， 带参数过去
     */
    public static void handleIntentWithObjAndFinish(final String path, final String objName, final Object obj, final Activity mContext) {
        ARouter.getInstance().build(path).withObject(objName, obj).navigation(mContext, navAndFinishCallback(mContext));
    }

    /**
     * 处理跳转,带参数过去
     */
    public static void handleIntentWithObj(final String path, final String objName, final Object obj, final Activity mContext, final int requestCode) {
        ARouter.getInstance().build(path).withObject(objName, obj).navigation(mContext, requestCode);
    }

    /**
     * 处理跳转,关闭当前页面，带参数过去
     */
    public static void handleIntentWithObjAndFinish(final String path, final String objName, final Object obj, final Activity mContext, final int requestCode) {
        ARouter.getInstance().build(path).withObject(objName, obj).navigation(mContext, requestCode, navAndFinishCallback(mContext));
    }

    /**
     * 处理跳转,带参数过去
     */
    public static void handleIntentWithObj(final String path, final String objName, final Object obj, final Activity mContext, final int requestCode, final NavigationCallback callback) {
        ARouter.getInstance().build(path).withObject(objName, obj).navigation(mContext, requestCode, navAndFinishCallback(mContext));
    }

    /**
     * 处理跳转,带参数过去
     */
    public static void handleIntentWithStr(final String path, final String strName, final String value) {
        ARouter.getInstance().build(path).withString(strName, value).navigation();
    }

    /**
     * 处理跳转关闭当前页面，,带参数过去
     */
    public static void handleIntentWithStrAndFinish(final String path, final String strName, final String value, final Activity mContext) {
        ARouter.getInstance().build(path).withString(strName, value).navigation(mContext, navAndFinishCallback(mContext));
    }

    /**
     * 处理跳转,带参数过去
     */
    public static void handleIntentWithStr(final String path, final String strName, final String value, final Activity mContext, final int requestCode) {
        ARouter.getInstance().build(path).withString(strName, value).navigation(mContext, requestCode);
    }

    /**
     * 处理跳转,关闭当前页面，带参数过去
     */
    public static void handleIntentWithStrAndFinish(final String path, final String strName, final String value, final Activity mContext, final int requestCode) {
        ARouter.getInstance().build(path).withString(strName, value).navigation(mContext, requestCode, navAndFinishCallback(mContext));
    }

    /**
     * 处理跳转,带参数过去
     */
    public static void handleIntentWithStr(final String path, final String strName, final String value, final Activity mContext, final int requestCode, final NavigationCallback callback) {
        ARouter.getInstance().build(path).withString(strName, value).navigation(mContext, requestCode, callback);
    }

    /**
     * 处理跳转,带参数过去
     */
    public static void handleIntentWithInt(final String path, final String name, final int value) {
        ARouter.getInstance().build(path).withInt(name, value).navigation();
    }

    /**
     * 处理跳转,关闭当前页面，带参数过去
     */
    public static void handleIntentWithIntAndFinish(final String path, final String name, final int value, final Activity mContext) {
        ARouter.getInstance().build(path).withInt(name, value).navigation(mContext, navAndFinishCallback(mContext));
    }

    /**
     * 处理跳转,带参数过去
     */
    public static void handleIntentWithInt(final String path, final String name, final int value, final Activity mContext, final int requestCode) {
        ARouter.getInstance().build(path).withInt(name, value).navigation(mContext, requestCode);
    }

    /**
     * 处理跳转,关闭当前页面，带参数过去
     */
    public static void handleIntentWithIntAndFinish(final String path, final String name, final int value, final Activity mContext, final int requestCode) {
        ARouter.getInstance().build(path).withInt(name, value).navigation(mContext, requestCode, navAndFinishCallback(mContext));
    }

    /**
     * 处理跳转,带参数过去
     */
    public static void handleIntentWithInt(final String path, final String name, final int value, final Activity mContext, final int requestCode, final NavigationCallback callback) {
        ARouter.getInstance().build(path).withInt(name, value).navigation(mContext, requestCode, callback);
    }

    /**
     * 处理跳转,带参数过去
     */
    public static void handleIntentWithLong(final String path, final String name, final long value) {
        ARouter.getInstance().build(path).withLong(name, value).navigation();
    }

    /**
     * 处理跳转,关闭当前页面，带参数过去
     */
    public static void handleIntentWithLongAndFinish(final String path, final String name, final long value, final Activity mContext) {
        ARouter.getInstance().build(path).withLong(name, value).navigation(mContext, navAndFinishCallback(mContext));
    }

    /**
     * 处理跳转,带参数过去
     */
    public static void handleIntentWithLong(final String path, final String name, final long value, final Activity mContext, final int requestCode) {
        ARouter.getInstance().build(path).withLong(name, value).navigation(mContext, requestCode);
    }


    /**
     * 处理跳转,关闭当前页面，带参数过去
     */
    public static void handleIntentWithLongAndFinish(final String path, final String name, final long value, final Activity mContext, final int requestCode) {
        ARouter.getInstance().build(path).withLong(name, value).navigation(mContext, requestCode, navAndFinishCallback(mContext));
    }

    /**
     * 处理跳转,带参数过去
     */
    public static void handleIntentWithLong(final String path, final String name, final long value, final Activity mContext, final int requestCode, final NavigationCallback callback) {
        ARouter.getInstance().build(path).withLong(name, value).navigation(mContext, requestCode, callback);
    }

    /**
     * 处理跳转,带参数过去
     */
    public static void handleIntentWithBoolean(final String path, final String name, final boolean value) {
        ARouter.getInstance().build(path).withBoolean(name, value).navigation();
    }

    /**
     * 处理跳转,关闭当前页面，带参数过去
     */
    public static void handleIntentWithBooleanAndFinish(final String path, final String name, final boolean value, final Activity mContext) {
        ARouter.getInstance().build(path).withBoolean(name, value).navigation(mContext, navAndFinishCallback(mContext));
    }

    /**
     * 处理跳转,带参数过去
     */
    public static void handleIntentWithBoolean(final String path, final String name, final boolean value, final Activity mContext, final int requestCode) {
        ARouter.getInstance().build(path).withBoolean(name, value).navigation(mContext, requestCode);
    }

    /**
     * 处理跳转,关闭当前页面，带参数过去
     */
    public static void handleIntentWithBooleanAndFinish(final String path, final String name, final boolean value, final Activity mContext, final int requestCode) {
        ARouter.getInstance().build(path).withBoolean(name, value).navigation(mContext, requestCode, navAndFinishCallback(mContext));
    }

    /**
     * 处理跳转,带参数过去
     */
    public static void handleIntentWithBoolean(final String path, final String name, final boolean value, final Activity mContext, final int requestCode, final NavigationCallback callback) {
        ARouter.getInstance().build(path).withBoolean(name, value).navigation(mContext, requestCode, callback);
    }

    /**
     * 处理跳转,带参数过去
     */
    public static void handleIntentWithFloat(final String path, final String name, final float value) {
        ARouter.getInstance().build(path).withFloat(name, value).navigation();
    }

    /**
     * 处理跳转,关闭当前页面，带参数过去
     */
    public static void handleIntentWithFloatAndFinish(final String path, final String name, final float value, final Activity mContext) {
        ARouter.getInstance().build(path).withFloat(name, value).navigation(mContext, navAndFinishCallback(mContext));
    }

    /**
     * 处理跳转,带参数过去
     */
    public static void handleIntentWithFloat(final String path, final String name, final float value, final Activity mContext, final int requestCode) {
        ARouter.getInstance().build(path).withFloat(name, value).navigation(mContext, requestCode);
    }

    /**
     * 处理跳转,关闭当前页面，带参数过去
     */
    public static void handleIntentWithFloatAndFinish(final String path, final String name, final float value, final Activity mContext, final int requestCode) {
        ARouter.getInstance().build(path).withFloat(name, value).navigation(mContext, requestCode, navAndFinishCallback(mContext));
    }

    /**
     * 处理跳转,带参数过去
     */
    public static void handleIntentWithFloat(final String path, final String name, final float value, final Activity mContext, final int requestCode, final NavigationCallback callback) {
        ARouter.getInstance().build(path).withFloat(name, value).navigation(mContext, requestCode, callback);
    }

    /**
     * 处理跳转,带参数过去
     */
    public static void handleIntentWithDouble(final String path, final String name, final double value) {
        ARouter.getInstance().build(path).withDouble(name, value).navigation();
    }

    /**
     * 处理跳转,关闭当前页面，带参数过去
     */
    public static void handleIntentWithDoubleAndFinish(final String path, final String name, final double value, final Activity mContext) {
        ARouter.getInstance().build(path).withDouble(name, value).navigation(mContext, navAndFinishCallback(mContext));
    }

    /**
     * 处理跳转,带参数过去
     */
    public static void handleIntentWithDouble(final String path, final String name, final double value, final Activity mContext, final int requestCode) {
        ARouter.getInstance().build(path).withDouble(name, value).navigation(mContext, requestCode);
    }

    /**
     * 处理跳转,关闭当前页面，带参数过去
     */
    public static void handleIntentWithDoubleAndFinish(final String path, final String name, final double value, final Activity mContext, final int requestCode) {
        ARouter.getInstance().build(path).withDouble(name, value).navigation(mContext, requestCode, navAndFinishCallback(mContext));
    }

    /**
     * 处理跳转,带参数过去
     */
    public static void handleIntentWithDouble(final String path, final String name, final double value, final Activity mContext, final int requestCode, final NavigationCallback callback) {
        ARouter.getInstance().build(path).withDouble(name, value).navigation(mContext, requestCode, callback);
    }
}