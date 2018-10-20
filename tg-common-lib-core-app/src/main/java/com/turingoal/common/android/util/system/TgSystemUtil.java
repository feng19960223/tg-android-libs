package com.turingoal.common.android.util.system;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

/**
 * 系统工具类
 */
public final class TgSystemUtil {
    private TgSystemUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 打开网址
     */
    public static void openWebSite(final String webSite) {
        if (!TextUtils.isEmpty(webSite)) {
            Uri uri;
            if (webSite.startsWith("http://") || webSite.startsWith("https://")) {
                uri = Uri.parse(webSite);
            } else {
                uri = Uri.parse("http://" + webSite);
            }
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }

    /**
     * 拨打电话号码
     */
    public static void call(final String phoneNum) {
        if (!TextUtils.isEmpty(phoneNum)) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + phoneNum));
            startActivity(intent);
        }
    }
}