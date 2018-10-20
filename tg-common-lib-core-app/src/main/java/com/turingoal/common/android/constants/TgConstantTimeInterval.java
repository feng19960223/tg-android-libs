package com.turingoal.common.android.constants;

/**
 * 常量-》常用的时间间隔
 */
public interface TgConstantTimeInterval {
    int SECONDS_PER_SECOND = 1;
    /** 1分钟 60s. */
    int SECONDS_PER_MINUTE = 60 * SECONDS_PER_SECOND;
    /** 1小时 60 * 60=3600. */
    int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * 60;
    /** 1天 60 * 60 * 24=86400. */
    int SECONDS_PER_DAY = SECONDS_PER_HOUR * 24;
    /** 1个星期 60 * 60 * 24 * 7= 604 800. */
    int SECONDS_PER_WEEK = SECONDS_PER_DAY * 7;
    /** 1个月 60 * 60 * 24 * 30= 2592000. 30天一个月 */
    int SECONDS_PER_MONTH = SECONDS_PER_DAY * 30;
    /** 1年 60 * 60 * 24 * 365=31536000. 以365天算 */
    int SECONDS_PER_YEAR = SECONDS_PER_DAY * 365;
    // ------------------------------以毫秒为单位------------------------------
    /** 1秒 1000ms(毫秒). */
    int MILLISECOND_PER_SECONDS = 1000;
    /** 1分钟 60 000ms(毫秒). */
    int MILLISECOND_PER_MINUTE = SECONDS_PER_MINUTE * 1000;
    /** 1小时 3600 000ms(毫秒). */
    int MILLISECOND_PER_HOUR = SECONDS_PER_HOUR * 1000;
    /** 1天 86400 000ms(毫秒). */
    int MILLISECOND_PER_DAY = SECONDS_PER_DAY * 1000;
    /** 1个星期 604 800 000ms(毫秒). */
    int MILLISECOND_PER_WEEK = SECONDS_PER_WEEK * 1000;
    /** 1个月,2592000 000ms(毫秒),<span style="color:red">大于 {@link Integer#MAX_VALUE}:2147483647</span>. */
    long MILLISECOND_PER_MONTH = 1000L * SECONDS_PER_MONTH;
    /** 1年 31536000 000ms(毫秒). */
    long MILLISECOND_PER_YEAR = 1000L * SECONDS_PER_YEAR;
}
