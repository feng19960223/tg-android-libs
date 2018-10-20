package com.turingoal.common.android.constants;

/**
 * 常用的数字模式.
 */
public interface TgConstantPattern4Number {
    /**
     * 整数,不含小数 <code>{@value}</code>.
     * <h3>示例:</h3> <blockquote>
     * 
     * <pre class="code">
     * 88.6 会被格式化成 89
     * -88.6 会被格式化成 -89
     * </pre>
     * 
     * </blockquote>
     */
    String NO_SCALE = "#";

    /**
     * (2位小数点) <code>{@value}</code>.
     * <h3>示例:</h3> <blockquote>
     * 
     * <pre class="code">
     * 88.6 会被格式化成 88.60
     * -88.067 会被格式化成 -88.07
     * </pre>
     * 
     * </blockquote>
     */
    String TWO_DECIMAL_POINTS = "#0.00";

    /**
     * 百分数的表达式(不带小数) <code>{@value}</code>.
     * <h3>示例:</h3> <blockquote>
     * 
     * <pre class="code">
     * 0 会被格式化成 0%
     * 1 会被格式化成 100%
     * 100 会被格式化成 10000%
     * </pre>
     * 
     * </blockquote>
     */
    String PERCENT_WITH_NOPOINT = "##%";

    /**
     * 百分数的表达式(1位小数点) <code>{@value}</code>.
     * <h3>示例:</h3> <blockquote>
     * 
     * <pre class="code">
     * 0 会被格式化成 0.0%
     * 1 会被格式化成 100.0%
     * 100 会被格式化成 10000.0%
     * </pre>
     * 
     * </blockquote>
     */

    /**
     * 百分数的表达式(2位小数点) <code>{@value}</code>.
     * <h3>示例:</h3> <blockquote>
     * 
     * <pre class="code">
     * 0 会被格式化成 0.00%
     * 1 会被格式化成 100.00%
     * 100 会被格式化成 10000.00%
     * </pre>
     * 
     * </blockquote>
     */
    String PERCENT_WITH_2POINT = "#0.00%";
}