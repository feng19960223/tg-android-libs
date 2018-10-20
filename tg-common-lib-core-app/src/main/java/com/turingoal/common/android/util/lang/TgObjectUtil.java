package com.turingoal.common.android.util.lang;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SimpleArrayMap;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;

import com.blankj.utilcode.util.ObjectUtils;

import java.util.Collection;
import java.util.Map;

/**
 * object工具类
 */
public final class TgObjectUtil {
    private TgObjectUtil() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 判断对象是否为空
     */
    public static boolean isEmpty(final Object obj) {
        return ObjectUtils.isEmpty(obj);
    }

    /**
     * 判断对象是否为空
     */
    public static boolean isEmpty(final CharSequence obj) {
        return ObjectUtils.isEmpty(obj);
    }

    /**
     * 判断对象是否为空
     */
    public static boolean isEmpty(final Collection obj) {
        return ObjectUtils.isEmpty(obj);
    }

    /**
     * 判断对象是否为空
     */
    public static boolean isEmpty(final Map obj) {
        return ObjectUtils.isEmpty(obj);
    }

    /**
     * 判断对象是否为空
     */
    public static boolean isEmpty(final SimpleArrayMap obj) {
        return ObjectUtils.isEmpty(obj);
    }

    /**
     * 判断对象是否为空
     */
    public static boolean isEmpty(final SparseArray obj) {
        return ObjectUtils.isEmpty(obj);
    }

    /**
     * 判断对象是否为空
     */
    public static boolean isEmpty(final SparseBooleanArray obj) {
        return ObjectUtils.isEmpty(obj);
    }

    /**
     * 判断对象是否为空
     */
    public static boolean isEmpty(final SparseIntArray obj) {
        return ObjectUtils.isEmpty(obj);
    }

    /**
     * 判断对象是否为空
     */
    public static boolean isEmpty(final LongSparseArray obj) {
        return ObjectUtils.isEmpty(obj);
    }

    /**
     * 判断对象是否为空
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static boolean isEmpty(final SparseLongArray obj) {
        return ObjectUtils.isEmpty(obj);
    }

    /**
     * 判断对象是否为空
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static boolean isEmpty(final android.util.LongSparseArray obj) {
        return ObjectUtils.isEmpty(obj);
    }

    /**
     * 判断对象是否非空
     */
    public static boolean isNotEmpty(final Object obj) {
        return ObjectUtils.isNotEmpty(obj);
    }

    /**
     * 判断对象是否非空
     */
    public static boolean isNotEmpty(final CharSequence obj) {
        return ObjectUtils.isNotEmpty(obj);
    }

    /**
     * 判断对象是否非空
     */
    public static boolean isNotEmpty(final Collection obj) {
        return ObjectUtils.isNotEmpty(obj);
    }

    /**
     * 判断对象是否非空
     */
    public static boolean isNotEmpty(final Map obj) {
        return ObjectUtils.isNotEmpty(obj);
    }

    /**
     * 判断对象是否非空
     */
    public static boolean isNotEmpty(final SimpleArrayMap obj) {
        return ObjectUtils.isNotEmpty(obj);
    }

    /**
     * 判断对象是否非空
     */
    public static boolean isNotEmpty(final SparseArray obj) {
        return ObjectUtils.isNotEmpty(obj);
    }

    /**
     * 判断对象是否非空
     */
    public static boolean isNotEmpty(final SparseBooleanArray obj) {
        return ObjectUtils.isNotEmpty(obj);
    }

    /**
     * 判断对象是否非空
     */
    public static boolean isNotEmpty(final SparseIntArray obj) {
        return ObjectUtils.isNotEmpty(obj);
    }

    /**
     * 判断对象是否非空
     */
    public static boolean isNotEmpty(final LongSparseArray obj) {
        return ObjectUtils.isNotEmpty(obj);
    }

    /**
     * 判断对象是否非空
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static boolean isNotEmpty(final SparseLongArray obj) {
        return ObjectUtils.isNotEmpty(obj);
    }

    /**
     * 判断对象是否非空
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static boolean isNotEmpty(final android.util.LongSparseArray obj) {
        return ObjectUtils.isNotEmpty(obj);
    }

    /**
     * 判断对象是否相等
     */
    public static boolean equals(final Object o1, final Object o2) {
        return ObjectUtils.equals(o1, o2);
    }

    /**
     * 检查对象非空
     */
    public static void requireNonNull(final Object... objects) {
        ObjectUtils.requireNonNull(objects);
    }

    /**
     * 获取非空或默认对象
     */
    public static <T> T getOrDefault(final T object, final T defaultObject) {
        return ObjectUtils.getOrDefault(object, defaultObject);
    }

    /**
     * 获取对象哈希值
     */
    public static int hashCode(final Object o) {
        return ObjectUtils.hashCode(o);
    }
}