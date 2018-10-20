package com.turingoal.common.android.util.lang;

import android.support.annotation.NonNull;

import com.blankj.utilcode.constant.TimeConstants;
import com.blankj.utilcode.util.TimeUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 工具类-》日期工具类
 */
public final class TgDateUtil {

    private TgDateUtil() {
        throw new Error("工具类不能实例化！");
    }

    public static final Integer SIXTY = 60;
    public static final Integer TWENTY_FOUR = 24;
    public static final Integer SEVEN = 7;
    public static final Integer FOUR = 4;

    public static final String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_MM_DD_HH_MM_SS = "MM-dd HH:mm:ss";
    public static final String FORMAT_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String FORMAT_YYYY_MM_DD_HH_MM_SS_ZH = "yyyy年MM月dd日 HH:mm:ss";
    public static final String FORMAT_MM_DD_HH_MM_SS_ZH = "MM月dd日 HH:mm:ss";
    public static final String FORMAT_MM_DD_HH_MM_ZH = "MM月dd日 HH:mm";
    public static final String FORMAT_YYYY_MM_DD_HH_MM_ZH = "yyyy年MM月dd HH:mm";
    public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String FORMAT_YYYY_MM = "yyyy-MM";
    public static final String FORMAT_YYYYMM = "yyyyMM";
    public static final String FORMAT_YYYY = "yyyy";
    public static final String FORMAT_YYYY_MM_DD_ZH = "yyyy年MM月dd日";
    public static final String FORMAT_YYYY_MM_ZH = "yyyy年MM月";
    public static final String FORMAT_HH_MM_SS = "HH:mm:ss";
    public static final String FORMAT_HH_MM = "HH:mm";
    public static final Date DEFAULT_START_DATE = TgDateUtil.string2Date("2000-01-01", TgDateUtil.FORMAT_YYYY_MM_DD); // 初始化开始时间
    public static final Date DEFAULT_END_DATE = TgDateUtil.string2Date("2046-12-31", TgDateUtil.FORMAT_YYYY_MM_DD); // 初始化结束时间

    /**
     * 格式化时间
     */
    public static String date2String(final Date date, final String formatStr) {
        String dateString = "";
        if (date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
            dateString = formatter.format(date);
        }
        return dateString;
    }


    /**
     * 字符串转时间
     */
    public static Date string2Date(final String dateStr, final String formatStr) {
        SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
        Date date = null;
        try {
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 功能描述：返回月
     */
    public static int getMonth(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 功能描述：返回日
     */
    public static int getDay(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 功能描述：返回小时
     */
    public static int getHour(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 功能描述：返回分
     */
    public static int getMinute(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 返回秒钟
     */
    public static int getSecond(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 功能描述：返回毫秒
     */
    public static long getMillis(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    /**
     * 在日期上增加数个整月
     */
    public static Date addMonth(final Date date, final int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }

    /**
     * 在日期上增加天数
     */
    public static Date addDay(final Date date, final int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return cal.getTime();

    }

    /**
     * 前一天
     */
    public static Date getBeforeDay(final Date date) {
        return addDay(date, -1);
    }

    /**
     * 获取下一天
     */
    public static Date getNextDay(final Date date) {
        return addDay(date, 1);
    }

    /**
     * 计时
     */
    public static String timing(final Date startTime) {
        long workStartTimt = startTime.getTime();
        long time = (new Date().getTime() - workStartTimt) / 1000;
        long hour = time / (SIXTY * SIXTY);
        time = time % (SIXTY * SIXTY);
        long minute = time / SIXTY;
        long second = time % SIXTY;
        String secondStr = "" + second;
        if (second < 10) {
            secondStr = "0" + second;
        }
        String minuteStr = "" + minute;
        if (minute < 10) {
            minuteStr = "0" + minute;
        }
        return hour + "小时" + minuteStr + "分" + secondStr + "秒";
    }

    /**
     * 通过毫秒值，手动计算日期间的相关的值
     * <p>
     * 跨年不会出现问题
     * 使用此种方法的话需要注意
     * 如果时间为：2016-03-18 11:59:59 和 2016-03-19 00:00:01的话差值为 0
     */
    public static long daysBetweenTwoDays(Date fDate, Date oDate) {
        return (oDate.getTime() - fDate.getTime()) / (1000 * 3600 * 24);
    }

    /**
     * 将时间戳转为时间字符串
     * <p>The pattern is {@code yyyy-MM-dd HH:mm:ss}.</p>
     */
    public static String millis2String(final long millis) {
        return TimeUtils.millis2String(millis);
    }

    /**
     * 将时间戳转为时间字符串
     */
    public static String millis2String(final long millis, @NonNull final java.text.DateFormat format) {
        return TimeUtils.millis2String(millis, format);
    }

    /**
     * 将时间字符串转为时间戳
     */
    public static long string2Millis(final String time) {
        return TimeUtils.string2Millis(time);
    }

    /**
     * 将时间字符串转为时间戳
     */
    public static long string2Millis(final String time, @NonNull final java.text.DateFormat format) {
        return TimeUtils.string2Millis(time, format);
    }

    /**
     * 将时间字符串转为 Date 类型
     */
    public static Date string2Date(final String time) {
        return TimeUtils.string2Date(time);
    }

    /**
     * 将时间字符串转为 Date 类型
     */
    public static Date string2Date(final String time, @NonNull final java.text.DateFormat format) {
        return TimeUtils.string2Date(time, format);
    }

    /**
     * 将 Date 类型转为时间字符串
     * <p>The pattern is {@code yyyy-MM-dd HH:mm:ss}.</p>
     */
    public static String dateTime2String(final Date date) {
        return TimeUtils.date2String(date);
    }

    /**
     * 将 Date 类型转为时间字符串
     * <p>The pattern is {@code yyyy-MM-dd}.</p>
     */
    public static String date2String(final Date date) {
        return date2String(date, FORMAT_YYYY_MM_DD);
    }

    /**
     * 将 Date 类型转为时间字符串
     * <p>The pattern is {@code HH:mm:ss}.</p>
     */
    public static String time2String(final Date date) {
        return date2String(date, FORMAT_HH_MM_SS);
    }

    /**
     * 将 Date 类型转为时间字符串
     */
    public static String date2String(final Date date, @NonNull final java.text.DateFormat format) {
        return TimeUtils.date2String(date, format);
    }

    /**
     * 将 Date 类型转为时间戳
     */
    public static long date2Millis(final Date date) {
        return TimeUtils.date2Millis(date);
    }

    /**
     * 将时间戳转为 Date 类型
     */
    public static Date millis2Date(final long millis) {
        return TimeUtils.millis2Date(millis);
    }

    /**
     * 获取两个时间差（单位：unit）
     *
     * @param unit The unit of time span.
     *             <ul>
     *             <li>{@link TimeConstants#MSEC}</li>
     *             <li>{@link TimeConstants#SEC }</li>
     *             <li>{@link TimeConstants#MIN }</li>
     *             <li>{@link TimeConstants#HOUR}</li>
     *             <li>{@link TimeConstants#DAY }</li>
     *             </ul>
     */
    public static long getTimeSpan(final String time1, final String time2, @TimeConstants.Unit final int unit) {
        return TimeUtils.getTimeSpan(time1, time2, unit);
    }

    /**
     * 获取两个时间差（单位：unit）
     *
     * @param unit The unit of time span.
     *             <ul>
     *             <li>{@link TimeConstants#MSEC}</li>
     *             <li>{@link TimeConstants#SEC }</li>
     *             <li>{@link TimeConstants#MIN }</li>
     *             <li>{@link TimeConstants#HOUR}</li>
     *             <li>{@link TimeConstants#DAY }</li>
     *             </ul>
     * @return the time span, in unit
     */
    public static long getTimeSpan(final String time1, final String time2, @NonNull final java.text.DateFormat format, @TimeConstants.Unit final int unit) {
        return TimeUtils.getTimeSpan(time1, time2, format, unit);
    }

    /**
     * 获取两个时间差（单位：unit）
     *
     * @param unit The unit of time span.
     *             <ul>
     *             <li>{@link TimeConstants#MSEC}</li>
     *             <li>{@link TimeConstants#SEC }</li>
     *             <li>{@link TimeConstants#MIN }</li>
     *             <li>{@link TimeConstants#HOUR}</li>
     *             <li>{@link TimeConstants#DAY }</li>
     *             </ul>
     */
    public static long getTimeSpan(final Date date1, final Date date2, @TimeConstants.Unit final int unit) {
        return TimeUtils.getTimeSpan(date1, date2, unit);
    }

    /**
     * 获取两个时间差（单位：unit）
     *
     * @param unit The unit of time span.
     *             <ul>
     *             <li>{@link TimeConstants#MSEC}</li>
     *             <li>{@link TimeConstants#SEC }</li>
     *             <li>{@link TimeConstants#MIN }</li>
     *             <li>{@link TimeConstants#HOUR}</li>
     *             <li>{@link TimeConstants#DAY }</li>
     *             </ul>
     */
    public static long getTimeSpan(final long millis1, final long millis2, @TimeConstants.Unit final int unit) {
        return TimeUtils.getTimeSpan(millis1, millis2, unit);
    }

    /**
     * 获取合适型两个时间差
     *
     * @param precision The precision of time span.
     *                  <ul>
     *                  <li>precision = 0, return null</li>
     *                  <li>precision = 1, return 天</li>
     *                  <li>precision = 2, return 天, 小时</li>
     *                  <li>precision = 3, return 天, 小时, 分钟</li>
     *                  <li>precision = 4, return 天, 小时, 分钟, 秒</li>
     *                  <li>precision &gt;= 5，return 天, 小时, 分钟, 秒, 毫秒</li>
     *                  </ul>
     * @return the fit time span
     */
    public static String getFitTimeSpan(final String time1, final String time2, final int precision) {
        return TimeUtils.getFitTimeSpan(time1, time2, precision);
    }

    /**
     * 获取合适型两个时间差
     *
     * @param time1     The first formatted time string.
     * @param time2     The second formatted time string.
     * @param format    The format.
     * @param precision The precision of time span.
     *                  <ul>
     *                  <li>precision = 0, return null</li>
     *                  <li>precision = 1, return 天</li>
     *                  <li>precision = 2, return 天, 小时</li>
     *                  <li>precision = 3, return 天, 小时, 分钟</li>
     *                  <li>precision = 4, return 天, 小时, 分钟, 秒</li>
     *                  <li>precision &gt;= 5，return 天, 小时, 分钟, 秒, 毫秒</li>
     *                  </ul>
     */
    public static String getFitTimeSpan(final String time1, final String time2, @NonNull final java.text.DateFormat format, final int precision) {
        return TimeUtils.getFitTimeSpan(time1, time2, format, precision);
    }

    /**
     * 获取合适型两个时间差
     *
     * @param precision The precision of time span.
     *                  <ul>
     *                  <li>precision = 0, return null</li>
     *                  <li>precision = 1, return 天</li>
     *                  <li>precision = 2, return 天, 小时</li>
     *                  <li>precision = 3, return 天, 小时, 分钟</li>
     *                  <li>precision = 4, return 天, 小时, 分钟, 秒</li>
     *                  <li>precision &gt;= 5，return 天, 小时, 分钟, 秒, 毫秒</li>
     *                  </ul>
     */
    public static String getFitTimeSpan(final Date date1, final Date date2, final int precision) {
        return TimeUtils.getFitTimeSpan(date1, date2, precision);
    }

    /**
     * 获取合适型两个时间差
     *
     * @param precision The precision of time span.
     *                  <ul>
     *                  <li>precision = 0, return null</li>
     *                  <li>precision = 1, return 天</li>
     *                  <li>precision = 2, return 天, 小时</li>
     *                  <li>precision = 3, return 天, 小时, 分钟</li>
     *                  <li>precision = 4, return 天, 小时, 分钟, 秒</li>
     *                  <li>precision &gt;= 5，return 天, 小时, 分钟, 秒, 毫秒</li>
     *                  </ul>
     */
    public static String getFitTimeSpan(final long millis1, final long millis2, final int precision) {
        return TimeUtils.getFitTimeSpan(millis1, millis2, precision);
    }

    /**
     * 获取当前时间字符串
     */
    public static long getNowMills() {
        return System.currentTimeMillis();
    }

    /**
     * 获取当前时间字符串
     * <p>The pattern is {@code yyyy-MM-dd HH:mm:ss}.</p>
     */
    public static String getNowString() {
        return TimeUtils.getNowString();
    }

    /**
     * 获取当前时间字符串
     */
    public static String getNowString(@NonNull final java.text.DateFormat format) {
        return TimeUtils.getNowString(format);
    }

    /**
     * 获取当前 Date
     */
    public static Date getNowDate() {
        return TimeUtils.getNowDate();
    }

    /**
     * 获取与当前时间的差（单位：unit）
     */
    public static long getTimeSpanByNow(final String time, @TimeConstants.Unit final int unit) {
        return TimeUtils.getTimeSpanByNow(time, unit);
    }

    /**
     * 获取与当前时间的差（单位：unit）
     */
    public static long getTimeSpanByNow(final String time, @NonNull final java.text.DateFormat format, @TimeConstants.Unit final int unit) {
        return TimeUtils.getTimeSpanByNow(time, format, unit);
    }

    /**
     * 获取与当前时间的差（单位：unit）
     */
    public static long getTimeSpanByNow(final Date date, @TimeConstants.Unit final int unit) {
        return TimeUtils.getTimeSpanByNow(date, unit);
    }

    /**
     * 获取与当前时间的差（单位：unit）
     */
    public static long getTimeSpanByNow(final long millis, @TimeConstants.Unit final int unit) {
        return TimeUtils.getTimeSpanByNow(millis, unit);
    }

    /**
     * 获取合适型与当前时间的差
     *
     * @param time      The formatted time string.
     * @param precision The precision of time span.
     *                  <ul>
     *                  <li>precision = 0，返回 null</li>
     *                  <li>precision = 1，返回天</li>
     *                  <li>precision = 2，返回天和小时</li>
     *                  <li>precision = 3，返回天、小时和分钟</li>
     *                  <li>precision = 4，返回天、小时、分钟和秒</li>
     *                  <li>precision &gt;= 5，返回天、小时、分钟、秒和毫秒</li>
     *                  </ul>
     * @return the fit time span by now
     */
    public static String getFitTimeSpanByNow(final String time, final int precision) {
        return TimeUtils.getFitTimeSpanByNow(time, precision);
    }

    /**
     * 获取合适型与当前时间的差
     *
     * @param time      The formatted time string.
     * @param format    The format.
     * @param precision The precision of time span.
     *                  <ul>
     *                  <li>precision = 0，返回 null</li>
     *                  <li>precision = 1，返回天</li>
     *                  <li>precision = 2，返回天和小时</li>
     *                  <li>precision = 3，返回天、小时和分钟</li>
     *                  <li>precision = 4，返回天、小时、分钟和秒</li>
     *                  <li>precision &gt;= 5，返回天、小时、分钟、秒和毫秒</li>
     *                  </ul>
     * @return the fit time span by now
     */
    public static String getFitTimeSpanByNow(final String time, @NonNull final java.text.DateFormat format, final int precision) {
        return TimeUtils.getFitTimeSpanByNow(time, format, precision);
    }

    /**
     * 获取合适型与当前时间的差
     *
     * @param date      The date.
     * @param precision The precision of time span.
     *                  <ul>
     *                  <li>precision = 0，返回 null</li>
     *                  <li>precision = 1，返回天</li>
     *                  <li>precision = 2，返回天和小时</li>
     *                  <li>precision = 3，返回天、小时和分钟</li>
     *                  <li>precision = 4，返回天、小时、分钟和秒</li>
     *                  <li>precision &gt;= 5，返回天、小时、分钟、秒和毫秒</li>
     *                  </ul>
     * @return the fit time span by now
     */
    public static String getFitTimeSpanByNow(final Date date, final int precision) {
        return TimeUtils.getFitTimeSpanByNow(date, precision);
    }

    /**
     * 获取合适型与当前时间的差
     *
     * @param millis    The milliseconds.
     * @param precision The precision of time span.
     *                  <ul>
     *                  <li>precision = 0，返回 null</li>
     *                  <li>precision = 1，返回天</li>
     *                  <li>precision = 2，返回天和小时</li>
     *                  <li>precision = 3，返回天、小时和分钟</li>
     *                  <li>precision = 4，返回天、小时、分钟和秒</li>
     *                  <li>precision &gt;= 5，返回天、小时、分钟、秒和毫秒</li>
     *                  </ul>
     * @return the fit time span by now
     */
    public static String getFitTimeSpanByNow(final long millis, final int precision) {
        return TimeUtils.getFitTimeSpanByNow(millis, precision);
    }

    /**
     * 获取友好型与当前时间的差
     * <ul>
     * <li>如果小于 1 秒钟内，显示刚刚</li>
     * <li>如果在 1 分钟内，显示 XXX秒前</li>
     * <li>如果在 1 小时内，显示 XXX分钟前</li>
     * <li>如果在 1 小时外的今天内，显示今天15:32</li>
     * <li>如果是昨天的，显示昨天15:32</li>
     * <li>其余显示，2016-10-15</li>
     * <li>时间不合法的情况全部日期和时间信息，如星期六 十月 27 14:21:20 CST 2007</li>
     * </ul>
     */
    public static String getFriendlyTimeSpanByNow(final String time) {
        return TimeUtils.getFriendlyTimeSpanByNow(time);
    }

    /**
     * 获取友好型与当前时间的差
     *
     * @param time   The formatted time string.
     * @param format The format.
     * @return the friendly time span by now
     * <ul>
     * <li>如果小于 1 秒钟内，显示刚刚</li>
     * <li>如果在 1 分钟内，显示 XXX秒前</li>
     * <li>如果在 1 小时内，显示 XXX分钟前</li>
     * <li>如果在 1 小时外的今天内，显示今天15:32</li>
     * <li>如果是昨天的，显示昨天15:32</li>
     * <li>其余显示，2016-10-15</li>
     * <li>时间不合法的情况全部日期和时间信息，如星期六 十月 27 14:21:20 CST 2007</li>
     * </ul>
     */
    public static String getFriendlyTimeSpanByNow(final String time, @NonNull final java.text.DateFormat format) {
        return TimeUtils.getFriendlyTimeSpanByNow(time, format);
    }

    /**
     * 获取友好型与当前时间的差
     *
     * @param date The date.
     * @return the friendly time span by now
     * <ul>
     * <li>如果小于 1 秒钟内，显示刚刚</li>
     * <li>如果在 1 分钟内，显示 XXX秒前</li>
     * <li>如果在 1 小时内，显示 XXX分钟前</li>
     * <li>如果在 1 小时外的今天内，显示今天15:32</li>
     * <li>如果是昨天的，显示昨天15:32</li>
     * <li>其余显示，2016-10-15</li>
     * <li>时间不合法的情况全部日期和时间信息，如星期六 十月 27 14:21:20 CST 2007</li>
     * </ul>
     */
    public static String getFriendlyTimeSpanByNow(final Date date) {
        return TimeUtils.getFriendlyTimeSpanByNow(date);
    }

    /**
     * 获取友好型与当前时间的差
     * <ul>
     * <li>如果小于 1 秒钟内，显示刚刚</li>
     * <li>如果在 1 分钟内，显示 XXX秒前</li>
     * <li>如果在 1 小时内，显示 XXX分钟前</li>
     * <li>如果在 1 小时外的今天内，显示今天15:32</li>
     * <li>如果是昨天的，显示昨天15:32</li>
     * <li>其余显示，2016-10-15</li>
     * <li>时间不合法的情况全部日期和时间信息，如星期六 十月 27 14:21:20 CST 2007</li>
     * </ul>
     */
    public static String getFriendlyTimeSpanByNow(final long millis) {
        return TimeUtils.getFriendlyTimeSpanByNow(millis);
    }

    /**
     * 获取与给定时间等于时间差的时间戳
     */
    public static long getMillis(final long millis, final long timeSpan, @TimeConstants.Unit final int unit) {
        return TimeUtils.getMillis(millis, timeSpan, unit);
    }

    /**
     * 获取与给定时间等于时间差的时间戳
     */
    public static long getMillis(final String time, final long timeSpan, @TimeConstants.Unit final int unit) {
        return TimeUtils.getMillis(time, timeSpan, unit);
    }

    /**
     * 获取与给定时间等于时间差的时间戳
     */
    public static long getMillis(final String time, @NonNull final java.text.DateFormat format, final long timeSpan, @TimeConstants.Unit final int unit) {
        return TimeUtils.getMillis(time, format, timeSpan, unit);
    }

    /**
     * 获取与给定时间等于时间差的时间戳
     */
    public static long getMillis(final Date date, final long timeSpan, @TimeConstants.Unit final int unit) {
        return TimeUtils.getMillis(date, timeSpan, unit);
    }

    /**
     * 获取与给定时间等于时间差的时间字符串
     */
    public static String getString(final long millis, final long timeSpan, @TimeConstants.Unit final int unit) {
        return TimeUtils.getString(millis, timeSpan, unit);
    }

    /**
     * 获取与给定时间等于时间差的时间字符串
     */
    public static String getString(final long millis, @NonNull final java.text.DateFormat format, final long timeSpan, @TimeConstants.Unit final int unit) {
        return TimeUtils.getString(millis, format, timeSpan, unit);
    }

    /**
     * 获取与给定时间等于时间差的时间字符串
     */
    public static String getString(final String time, final long timeSpan, @TimeConstants.Unit final int unit) {
        return TimeUtils.getString(time, timeSpan, unit);
    }

    /**
     * 获取与给定时间等于时间差的时间字符串
     */
    public static String getString(final String time, @NonNull final java.text.DateFormat format, final long timeSpan, @TimeConstants.Unit final int unit) {
        return TimeUtils.getString(time, format, timeSpan, unit);
    }

    /**
     * 获取与给定时间等于时间差的时间字符串
     */
    public static String getString(final Date date, final long timeSpan, @TimeConstants.Unit final int unit) {
        return TimeUtils.getString(date, timeSpan, unit);
    }

    /**
     * 获取与给定时间等于时间差的时间字符串
     */
    public static String getString(final Date date, @NonNull final java.text.DateFormat format, final long timeSpan, @TimeConstants.Unit final int unit) {
        return TimeUtils.getString(date, format, timeSpan, unit);
    }

    /**
     * 获取与给定时间等于时间差的 Date
     */
    public static Date getDate(final long millis, final long timeSpan, @TimeConstants.Unit final int unit) {
        return TimeUtils.getDate(millis, timeSpan, unit);
    }

    /**
     * 获取与给定时间等于时间差的 Date
     */
    public static Date getDate(final String time, final long timeSpan, @TimeConstants.Unit final int unit) {
        return TimeUtils.getDate(time, timeSpan, unit);
    }

    /**
     * 获取与给定时间等于时间差的 Date
     */
    public static Date getDate(final String time, @NonNull final java.text.DateFormat format, final long timeSpan, @TimeConstants.Unit final int unit) {
        return TimeUtils.getDate(time, format, timeSpan, unit);
    }

    /**
     * 获取与给定时间等于时间差的 Date
     */
    public static Date getDate(final Date date, final long timeSpan, @TimeConstants.Unit final int unit) {
        return TimeUtils.getDate(date, timeSpan, unit);
    }

    /**
     * 获取与当前时间等于时间差的时间戳
     */
    public static long getMillisByNow(final long timeSpan, @TimeConstants.Unit final int unit) {
        return TimeUtils.getMillisByNow(timeSpan, unit);
    }

    /**
     * 获取与当前时间等于时间差的时间字符串
     */
    public static String getStringByNow(final long timeSpan, @TimeConstants.Unit final int unit) {
        return TimeUtils.getStringByNow(timeSpan, unit);
    }

    /**
     * 获取与当前时间等于时间差的时间字符串
     */
    public static String getStringByNow(final long timeSpan, @NonNull final java.text.DateFormat format, @TimeConstants.Unit final int unit) {
        return TimeUtils.getStringByNow(timeSpan, format, unit);
    }

    /**
     * 获取与当前时间等于时间差的 Date
     */
    public static Date getDateByNow(final long timeSpan, @TimeConstants.Unit final int unit) {
        return TimeUtils.getDateByNow(timeSpan, unit);
    }

    /**
     * 判断是否今天
     */
    public static boolean isToday(final String time) {
        return TimeUtils.isToday(time);
    }

    /**
     * 判断是否今天
     */
    public static boolean isToday(final String time, @NonNull final java.text.DateFormat format) {
        return TimeUtils.isToday(time, format);
    }

    /**
     * 判断是否今天
     */
    public static boolean isToday(final Date date) {
        return TimeUtils.isToday(date);
    }

    /**
     * 判断是否今天.
     */
    public static boolean isToday(final long millis) {
        return TimeUtils.isToday(millis);
    }

    /**
     * 判断是否闰年
     */
    public static boolean isLeapYear(final String time) {
        return TimeUtils.isLeapYear(time);
    }

    /**
     * 判断是否闰年
     */
    public static boolean isLeapYear(final String time, @NonNull final java.text.DateFormat format) {
        return TimeUtils.isLeapYear(time, format);
    }

    /**
     * 判断是否闰年
     */
    public static boolean isLeapYear(final Date date) {
        return TimeUtils.isLeapYear(date);
    }

    /**
     * 判断是否闰年
     */
    public static boolean isLeapYear(final long millis) {
        return TimeUtils.isLeapYear(millis);
    }

    /**
     * 判断是否闰年
     */
    public static boolean isLeapYear(final int year) {
        return TimeUtils.isLeapYear(year);
    }

    /**
     * 获取中式星期
     */
    public static String getChineseWeek(final String time) {
        return TimeUtils.getChineseWeek(time);
    }

    /**
     * 获取中式星期
     */
    public static String getChineseWeek(final String time, @NonNull final java.text.DateFormat format) {
        return TimeUtils.getChineseWeek(time, format);
    }

    /**
     * 获取中式星期
     */
    public static String getChineseWeek(final Date date) {
        return TimeUtils.getChineseWeek(date);
    }

    /**
     * 获取中式星期
     */
    public static String getChineseWeek(final long millis) {
        return TimeUtils.getChineseWeek(millis);
    }

    /**
     * 获取美式式星期
     */
    public static String getUSWeek(final String time) {
        return TimeUtils.getUSWeek(time);
    }

    /**
     * 获取美式式星期
     */
    public static String getUSWeek(final String time, @NonNull final java.text.DateFormat format) {
        return TimeUtils.getUSWeek(time, format);
    }

    /**
     * 获取美式式星期
     */
    public static String getUSWeek(final Date date) {
        return TimeUtils.getUSWeek(date);
    }

    /**
     * 获取美式式星期
     */
    public static String getUSWeek(final long millis) {
        return TimeUtils.getUSWeek(millis);
    }

    /**
     * 根据日历字段获取值
     */
    public static int getValueByCalendarField(final String time, final int field) {
        return TimeUtils.getValueByCalendarField(time, field);
    }

    /**
     * 根据日历字段获取值
     */
    public static int getValueByCalendarField(final String time, @NonNull final java.text.DateFormat format, final int field) {
        return TimeUtils.getValueByCalendarField(time, format, field);
    }

    /**
     * 根据日历字段获取值
     */
    public static int getValueByCalendarField(final Date date, final int field) {
        return TimeUtils.getValueByCalendarField(date, field);
    }

    /**
     * 根据日历字段获取值
     */
    public static int getValueByCalendarField(final long millis, final int field) {
        return TimeUtils.getValueByCalendarField(millis, field);
    }

    /**
     * 获取生肖
     */
    public static String getChineseZodiac(final String time) {
        return TimeUtils.getChineseZodiac(time);
    }

    /**
     * 获取生肖
     */
    public static String getChineseZodiac(final String time, @NonNull final java.text.DateFormat format) {
        return TimeUtils.getChineseZodiac(time, format);
    }

    /**
     * 获取生肖
     */
    public static String getChineseZodiac(final Date date) {
        return TimeUtils.getChineseZodiac(date);
    }

    /**
     * 获取生肖
     */
    public static String getChineseZodiac(final long millis) {
        return TimeUtils.getChineseZodiac(millis);
    }

    /**
     * 获取生肖
     */
    public static String getChineseZodiac(final int year) {
        return TimeUtils.getChineseZodiac(year);
    }

    /**
     * 获取星座
     */
    public static String getZodiac(final String time) {
        return TimeUtils.getZodiac(time);
    }

    /**
     * 获取星座
     */
    public static String getZodiac(final String time, @NonNull final java.text.DateFormat format) {
        return TimeUtils.getZodiac(time, format);
    }

    /**
     * 获取星座
     */
    public static String getZodiac(final Date date) {
        return TimeUtils.getZodiac(date);
    }

    /**
     * 获取星座
     */
    public static String getZodiac(final long millis) {
        return TimeUtils.getZodiac(millis);
    }

    /**
     * 获取星座
     */
    public static String getZodiac(final int month, final int day) {
        return TimeUtils.getZodiac(month, day);
    }
}
