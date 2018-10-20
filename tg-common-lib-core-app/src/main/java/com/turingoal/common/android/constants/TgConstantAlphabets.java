package com.turingoal.common.android.constants;

/**
 * 字母表
 */
public interface TgConstantAlphabets {
    /**
     * 数字The digit alphabet { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }.
     */
    String DIGIT = "0123456789";
    /**
     * 小写字母The lowercase alphabet { a, b, c, ..., z }.
     */
    String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    /**
     * 大写字母 The uppercase alphabet { A, B, C, ..., Z }.
     */
    String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * 大写字母和小写字母
     */
    String LETTERS = UPPERCASE + LOWERCASE;
    /**
     * 数字和所有的字母
     */
    String DIGIT_AND_LETTERS = UPPERCASE + LOWERCASE + DIGIT;
    /**
     * 数字和小写字母
     */
    String DIGIT_AND_LOWERCASE = DIGIT + LOWERCASE;
    /**
     * 数字和大写字母
     */
    String DIGIT_AND_UPPERCASE = DIGIT + UPPERCASE;
    /**
     * 数字和小写的字母,剔除一些难以辨别的数字和字母.23456789abcdefghijkmnpqrstuvwxyz。剔除了以下数字/字母:数字 1 和 字母 l,数字 0 和 字母 o
     */
    String DIGIT_AND_LOWERCASE_DISTINGUISHABLE = "23456789abcdefghijkmnpqrstuvwxyz";
}
