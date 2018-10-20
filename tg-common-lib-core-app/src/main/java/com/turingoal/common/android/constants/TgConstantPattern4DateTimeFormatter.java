package com.turingoal.common.android.constants;

/**
 * 常量-》时间格式化类型[基于simpleDateFormat]
 * 
 * <p>
 * G Era 标志符 Text AD
 * </p>
 * <p>
 * y 年 Year 1996; 96
 * </p>
 * <p>
 * M 年中的月份 Month July; Jul; 07
 * </p>
 * <p>
 * w 年中的周数 Number 27
 * </p>
 * <p>
 * W 月份中的周数 Number 2
 * </p>
 * <p>
 * D 年中的天数 Number 189
 * </p>
 * <p>
 * d 月份中的天数 Number 10
 * </p>
 * <p>
 * F 月份中的星期 Number 2
 * </p>
 * <p>
 * E 星期中的天数 Text Tuesday; Tue
 * </p>
 * <p>
 * a Am/pm 标记 Text PM
 * </p>
 * <p>
 * H 一天中的小时数（0-23） Number 0
 * </p>
 * <p>
 * k 一天中的小时数（1-24） Number 24
 * </p>
 * <p>
 * K am/pm 中的小时数（0-11） Number 0
 * </p>
 * <p>
 * h am/pm 中的小时数（1-12） Number 12
 * </p>
 * <p>
 * m 小时中的分钟数 Number 30
 * </p>
 * <p>
 * s 分钟中的秒数 Number 55
 * </p>
 * <p>
 * S 毫秒数 Number 978
 * </p>
 * <p>
 * z 时区 General time zone Pacific Standard Time; PST; GMT-08:00
 * </p>
 * <p>
 * Z 时区 RFC 822 time zone -0800
 * </p>
 */
public interface TgConstantPattern4DateTimeFormatter {
    String YEAR_MONTH = "yyyy年MM月"; // yyyy年MM月 ，如：2015年01月
    String YEAR_DATE = "yyyy年MM月dd日"; // yyyy年MM月dd日 ，如：2015年01月25日
    String YEAR_DATE_WEEK = "yyyy年MM月dd日 E"; // yyyy年MM月dd日 E ，如：2015年01月25日 星期五
    String YEAR_DATE_TIME12 = "yyyy年MM月dd日 h:mm:ss"; // yyyy年MM月dd日 hh:mm:ss ，如：2015年01月25日 6:45:36
    String YEAR_DATE_TIME24 = "YYYY年MM月dd日 HH:mm:ss"; // YYYY年MM月DD日 hh:mm:ss ，如：2015年01月25日 18:45:36
    String YYYY = "yyyy"; // yyyy ，如：2015
    String MM = "MM"; // MM ，如：11
    String DD = "dd"; // dd ，如：23
    String YYYY_MM = "yyyy-MM"; // yyyy-MM ，如：2015-09
    String YYYYMM = "yyyyMM"; // yyyyMM ，如：201509
    String YYYY_MM_DD = "yyyy-MM-dd"; // yyyy-MM-dd ，如：2015-05-23
    String YYYYMMDD = "yyyyMMdd"; // yyyyMMdd ，如：20150523
    String YYYY_MM_DD_H12_MM = "yyyy-MM-dd h:mm"; // yyyy-MM-dd hh:mm ，如：2015-05-23 10:40
    String YYYY_MM_DD_HH24_MM = "yyyy-MM-dd HH:mm"; // yyyy-MM-dd HH:mm ，如：2015-05-23 24:40 simpleDateFormat HH 24小时制 hh12小时制
    String YYYY_MM_DD_H12_MM_SS = "yyyy-MM-dd h:mm:ss"; // yyyy-MM-dd hh:mm:ss ，如：2015-05-23 10:40:36
    String YYYY_MM_DD_HH24_MM_SS = "yyyy-MM-dd HH:mm:ss"; // yyyy-MM-dd HH:mm:ss ，如：2015-05-23 24:40:36 simpleDateFormat HH 24小时制 hh12小时制
    String YYYY_MM_DD_HH24_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS"; // yyyy-MM-dd HH:mm:ss.SSS ，如：2015-05-23 24:40:36.568 simpleDateFormat HH 24小时制 hh12小时制
    String YYYYMMDDHH12MMSS = "yyyyMMddhmmss"; // yyyyMMddhmmss ，如：20150523104036
    String YYYYMMDDHH24MMSS = "yyyyMMddHHmmss"; // yyyyMMddHHmmss ，如：20150523224036
    String YYYYMMDDHH12MMSSMSS = "yyyyMMddhmmssSSS"; // yyyyMMddhmmssSSS ，如：20150523104036568
    String YYYYMMDDHH24MMSSMSS = "yyyyMMddHHmmssSSS"; // yyyyMMddHHmmssSSS ，如：20150523224036568
    String H12_MM_SS = "h:mm:ss"; // hh:mm:ss ，如：10:40:36
    String HH24_MM_SS = "HH:mm:ss"; // HH:mm:ss ，如：22:40:36 simpleDateFormat HH 24小时制 hh12小时制
    String H12MMSS = "hmmss"; // hhmmss ，如：104036
    String HH24MMSS = "HHmmss"; // HHmmss ，如：224036
    String H12MMSSMSS = "hmmssSSS"; // hhmmssmss ，如：104036375
    String HH24MMSSMSS = "HHmmssSSS"; // HHmmssmss ，如：224036375
    String H12_MM = "h:mm"; // hh:mm ，如：10:40
    String HH24_MM = "HH:mm"; // HH:mm ，如：22:40 simpleDateFormat HH 24小时制 hh12小时制
    /** HTTP头中日期时间格式：EEE, dd MMM yyyy HH:mm:ss z */
    String HTTP_DATETIME_PATTERN = "EEE, dd MMM yyyy HH:mm:ss z";
    /** JDK日期时间格式：EEE MMM dd HH:mm:ss zzz yyyy */
    String JDK_DATETIME_PATTERN = "EEE MMM dd HH:mm:ss zzz yyyy";
}
