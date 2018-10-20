package com.turingoal.common.android.util.lang;

import com.blankj.utilcode.util.EncodeUtils;

/**
 * Encode 工具类
 */
public final class TgEncodeUtil {
    private TgEncodeUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * URL 编码
     */
    public static String urlEncode(final String input) {
        return EncodeUtils.urlEncode(input);
    }

    /**
     * URL 编码
     */
    public static String urlEncode(final String input, final String charsetName) {
        return EncodeUtils.urlEncode(input, charsetName);
    }

    /**
     * URL 解码
     */
    public static String urlDecode(final String input) {
        return EncodeUtils.urlDecode(input);
    }

    /**
     * URL 解码
     */
    public static String urlDecode(final String input, final String charsetName) {
        return EncodeUtils.urlEncode(input, charsetName);
    }

    /**
     * Base64 编码
     */
    public static byte[] base64Encode(final String input) {
        return EncodeUtils.base64Encode(input);
    }

    /**
     * Base64 编码
     */
    public static byte[] base64Encode(final byte[] input) {
        return EncodeUtils.base64Encode(input);
    }

    /**
     * *Base64 编码
     */
    public static String base64Encode2String(final byte[] input) {
        return EncodeUtils.base64Encode2String(input);
    }

    /**
     * Base64 解码
     */
    public static byte[] base64Decode(final String input) {
        return EncodeUtils.base64Decode(input);
    }

    /**
     * Base64 解码
     */
    public static byte[] base64Decode(final byte[] input) {
        return EncodeUtils.base64Decode(input);
    }

    /**
     * Html 编码
     */
    public static String htmlEncode(final CharSequence input) {
        return EncodeUtils.htmlEncode(input);
    }

    /**
     * Html 解码
     */
    public static CharSequence htmlDecode(final String input) {
        return EncodeUtils.htmlDecode(input);
    }
}