package com.turingoal.mengbao.common.android.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.turingoal.mengbao.common.android.constants.TgMengbaoConstantPattern4SimpleDateFormat;

/**
 * 工具类-》基础工具类-》日期工具类 建议使用jdk中的新的时间类
 */
public final class TgMengBaoDateUtil {

    private TgMengBaoDateUtil() {
        throw new Error("工具类不能实例化！");
    }

    public static final Integer SIXTY = 60;
    public static final Integer TWENTY_FOUR = 24;
    public static final Integer SEVEN = 7;
    public static final Integer FOUR = 4;
    public static final Date DEFAULT_START_DATE = string2Date("2000-01-01", TgMengbaoConstantPattern4SimpleDateFormat.YYYY_MM_DD); // 初始化开始时间
    public static final Date DEFAULT_END_DATE = string2Date("2046-12-31", TgMengbaoConstantPattern4SimpleDateFormat.YYYY_MM_DD); // 初始化结束时间

    /**
     * 格式化时间
     */
    public static String date2String(final Date date, final String formatStr) {
        if (date != null) {
            return new SimpleDateFormat(formatStr).format(date);
        } else {
            return "---";
        }
    }

    /**
     * 格式化时间
     */
    public static String date2String(final Date date) {
        return date2String(date, TgMengbaoConstantPattern4SimpleDateFormat.YYYY_MM_DD);
    }

    /**
     * 格式化时间
     */
    public static String time2String(final Date date) {
        return date2String(date, TgMengbaoConstantPattern4SimpleDateFormat.HH24_MM_SS);
    }

    /**
     * 格式化时间
     */
    public static String dateTime2String(final Date date) {
        return date2String(date, TgMengbaoConstantPattern4SimpleDateFormat.YYYY_MM_DD_HH24_MM_SS);
    }

    /**
     * 字符串转时间
     */
    public static Date string2Date(final String dateStr, final String formatStr) {
        if (dateStr != null) {
            try {
                return new SimpleDateFormat(formatStr).parse(dateStr);
            } catch (ParseException e) {
                return null;
            }
        } else {
            return null;
        }
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
     * 返回距离发帖时间的时间差
     */
    public String timeDistanceFormat(final Date startDate) {
        long timeLong = new Date().getTime() - startDate.getTime();
        if (timeLong <= 10 * 1000) {
            return "刚刚";
        } else if (timeLong < SIXTY * 1000) {
            return timeLong / 1000 + "秒前";
        } else if (timeLong < SIXTY * SIXTY * 1000) {
            timeLong = timeLong / 1000 / SIXTY;
            return timeLong + "分钟前";
        } else if (timeLong < SIXTY * SIXTY * TWENTY_FOUR * 1000) {
            timeLong = timeLong / SIXTY / SIXTY / 1000;
            return timeLong + "小时前";
        } else if (timeLong < SIXTY * SIXTY * TWENTY_FOUR * 1000 * SEVEN) {
            timeLong = timeLong / 1000 / SIXTY / SIXTY / TWENTY_FOUR;
            return timeLong + "天前";
        } else if (timeLong < SIXTY * SIXTY * TWENTY_FOUR * 1000 * SEVEN * FOUR) {
            timeLong = timeLong / 1000 / SIXTY / SIXTY / TWENTY_FOUR / SEVEN;
            return timeLong + "周前";
        } else {
            timeLong = timeLong / 1000 / SIXTY / SIXTY / TWENTY_FOUR;
            return timeLong + "天前";
        }
    }
}
