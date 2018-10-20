package com.turingoal.common.android.util.lang;

import android.text.TextUtils;
import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;

/**
 * String工具类
 */
public final class TgStringUtil {
    private TgStringUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 得到字符串
     */
    public static String getStr(final CharSequence str) {
        if (isEmpty(str)) {
            return "";
        } else {
            return str.toString().trim();
        }
    }

    /**
     * 设置字符串
     */
    public static void setStr(final CharSequence str, final TextView textView) {
        if (textView != null) {
            textView.setText(getStr(str));
        }
    }

    /**
     * 判断String是否为空
     */
    public static boolean isEmpty(final CharSequence str) {
        boolean result = true;
        if (str != null) {
            result = StringUtils.isTrimEmpty(str.toString());
        }
        return result;
    }

    /**
     * 判断字符串是否为 null 或全为空白字符
     */
    public static boolean isBlank(final CharSequence str) {
        boolean result = true;
        if (str != null) {
            result = StringUtils.isSpace(str.toString());
        }
        return result;
    }

    /**
     * 判断两字符串是否相等
     */
    public static boolean equals(final CharSequence s1, final CharSequence s2) {
        return StringUtils.equals(s1, s2);
    }

    /**
     * 判断两字符串忽略大小写是否相等
     */
    public static boolean equalsIgnoreCase(final String s1, final String s2) {
        return StringUtils.equalsIgnoreCase(s1, s2);
    }

    /**
     * null 转为长度为 0 的字符串
     */
    public static String null2Length0(final String s) {
        return StringUtils.null2Length0(s);
    }

    /**
     * 返回字符串长度
     */
    public static int length(final CharSequence s) {
        return StringUtils.length(s);
    }

    /**
     * 首字母大写
     */
    public static String upperFirstLetter(final String s) {
        return StringUtils.upperFirstLetter(s);
    }

    /**
     * 首字母小写
     */
    public static String lowerFirstLetter(final String s) {
        return StringUtils.lowerFirstLetter(s);
    }

    /**
     * 反转字符串
     */
    public static String reverse(final String s) {
        return StringUtils.reverse(s);
    }

    /**
     * 转化为半角字符
     */
    public static String toDBC(final String s) {
        return StringUtils.toDBC(s);
    }

    /**
     * 转化为全角字符
     */
    public static String toSBC(final String s) {
        return StringUtils.toSBC(s);
    }
}