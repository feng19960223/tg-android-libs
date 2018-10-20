package com.turingoal.common.android.util.lang;

import com.blankj.utilcode.util.RegexUtils;

import java.util.List;

/**
 * 工具类-》正则表达式
 */
public final class TgRegexUtil {

    /**
     * 验证手机号（简单）
     */
    public static boolean isMobileSimple(final CharSequence input) {
        return RegexUtils.isMobileSimple(input);
    }

    /**
     * 验证手机号（精确）
     */
    public static boolean isMobileExact(final CharSequence input) {
        return RegexUtils.isMobileExact(input);
    }

    /**
     * 验证电话号码
     */
    public static boolean isTel(final CharSequence input) {
        return RegexUtils.isTel(input);
    }

    /**
     * 验证身份证号码 15 位
     */
    public static boolean isIDCard15(final CharSequence input) {
        return RegexUtils.isIDCard15(input);
    }

    /**
     * 验证身份证号码 18 位
     */
    public static boolean isIDCard18(final CharSequence input) {
        return RegexUtils.isIDCard18(input);
    }

    /**
     * 精确验证身份证号码 18 位
     */
    public static boolean isIDCard18Exact(final CharSequence input) {
        return RegexUtils.isIDCard18Exact(input);
    }

    /**
     * 验证邮箱
     */
    public static boolean isEmail(final CharSequence input) {
        return RegexUtils.isEmail(input);
    }

    /**
     * 验证 URL
     */
    public static boolean isURL(final CharSequence input) {
        return RegexUtils.isURL(input);
    }

    /**
     * 验证汉字
     */
    public static boolean isZh(final CharSequence input) {
        return RegexUtils.isZh(input);
    }

    /**
     * 验证用户名
     */
    public static boolean isUsername(final CharSequence input) {
        return RegexUtils.isUsername(input);
    }

    /**
     * 验证 yyyy-MM-dd 格式的日期校验，已考虑平闰年
     */
    public static boolean isDate(final CharSequence input) {
        return RegexUtils.isDate(input);
    }

    /**
     * 验证 IP 地址
     */
    public static boolean isIP(final CharSequence input) {
        return RegexUtils.isIP(input);
    }

    /**
     * 判断是否匹配正则
     */
    public static boolean isMatch(final String regex, final CharSequence input) {
        return RegexUtils.isMatch(regex, input);
    }

    /**
     * 获取正则匹配的部分
     */
    public static List<String> getMatches(final String regex, final CharSequence input) {
        return RegexUtils.getMatches(regex, input);
    }

    /**
     * 获取正则匹配分组
     */
    public static String[] getSplits(final String input, final String regex) {
        return RegexUtils.getSplits(input, regex);
    }

    /**
     * 替换正则匹配的第一部分
     *
     * @param input       The input.
     * @param regex       The regex.
     * @param replacement The replacement string.
     */
    public static String getReplaceFirst(final String input, final String regex, final String replacement) {
        return RegexUtils.getReplaceFirst(input, regex, replacement);
    }

    /**
     * 替换所有正则匹配的部分
     *
     * @param input       The input.
     * @param regex       The regex.
     * @param replacement The replacement string.
     */
    public static String getReplaceAll(final String input, final String regex, final String replacement) {
        return RegexUtils.getReplaceAll(input, regex, replacement);
    }
}
