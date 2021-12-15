package com.example.elasticsearch.util;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author Kalend
 */
public class DateUtil {

    /**
     * 设置年
     *
     * @param date   时间
     * @param amount 年数，-1表示减少
     * @return 设置后的时间
     */
    public static Date setYears(Date date, int amount) {
        return set(date, Calendar.YEAR, amount);
    }

    /**
     * 设置月
     *
     * @param date   时间
     * @param amount 月数，-1表示减少
     * @return 设置后的时间
     */
    public static Date setMonths(Date date, int amount) {
        return set(date, Calendar.MONTH, amount);
    }

    /**
     * 设置周
     *
     * @param date   时间
     * @param amount 周数，-1表示减少
     * @return 设置后的时间
     */
    public static Date setWeeks(Date date, int amount) {
        return set(date, Calendar.WEEK_OF_YEAR, amount);
    }

    /**
     * 设置天
     *
     * @param date   时间
     * @param amount 天数，-1表示减少
     * @return 设置后的时间
     */
    public static Date setDays(Date date, int amount) {
        return set(date, Calendar.DATE, amount);
    }

    /**
     * 设置小时
     *
     * @param date   时间
     * @param amount 小时数，-1表示减少
     * @return 设置后的时间
     */
    public static Date setHours(Date date, int amount) {
        return set(date, Calendar.HOUR_OF_DAY, amount);
    }

    /**
     * 设置分钟
     *
     * @param date   时间
     * @param amount 分钟数，-1表示减少
     * @return 设置后的时间
     */
    public static Date setMinutes(Date date, int amount) {
        return set(date, Calendar.MINUTE, amount);
    }

    /**
     * 设置秒
     *
     * @param date   时间
     * @param amount 秒数，-1表示减少
     * @return 设置后的时间
     */
    public static Date setSeconds(Date date, int amount) {
        return set(date, Calendar.SECOND, amount);
    }

    /**
     * 设置毫秒
     *
     * @param date   时间
     * @param amount 毫秒数，-1表示减少
     * @return 设置后的时间
     */
    public static Date setMilliseconds(Date date, int amount) {
        return set(date, Calendar.MILLISECOND, amount);
    }

    /**
     * 设置日期属性
     *
     * @param date          时间
     * @param calendarField 更改的属性
     * @param amount        更改数，-1表示减少
     * @return 设置后的时间
     */
    private static Date set(Date date, int calendarField, int amount) {
        Assert.notNull(date, "The date must not be null");
        Calendar c = Calendar.getInstance();
        c.setLenient(false);
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }

    public static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_DATE = "yyyy-MM-dd";
    public static final String PATTERN_TIME = "HH:mm:ss";

    public static final ConcurrentDateFormatUtil DATETIME_FORMAT = ConcurrentDateFormatUtil.of(PATTERN_DATETIME);
    public static final ConcurrentDateFormatUtil DATE_FORMAT = ConcurrentDateFormatUtil.of(PATTERN_DATE);
    public static final ConcurrentDateFormatUtil TIME_FORMAT = ConcurrentDateFormatUtil.of(PATTERN_TIME);

    /**
     * 日期时间格式化
     *
     * @param date 时间
     * @return 格式化后的时间
     */
    public static String formatDateTime(Date date) {
        return DATETIME_FORMAT.format(date);
    }

    /**
     * 日期格式化
     *
     * @param date 时间
     * @return 格式化后的时间
     */
    public static String formatDate(Date date) {
        return DATE_FORMAT.format(date);
    }

    /**
     * 时间格式化
     *
     * @param date 时间
     * @return 格式化后的时间
     */
    public static String formatTime(Date date) {
        return TIME_FORMAT.format(date);
    }

    /**
     * 日期格式化
     *
     * @param date    时间
     * @param pattern 表达式
     * @return 格式化后的时间
     */
    public static String format(Date date, String pattern) {
        return ConcurrentDateFormatUtil.of(pattern).format(date);
    }

    /**
     * 获取传入时间前一天的结束时间
     *
     * @return Date
     */
    public static Date getBeforeDayEndTime() {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, -1);
        ca.set(Calendar.HOUR_OF_DAY, 23);
        ca.set(Calendar.MINUTE, 59);
        ca.set(Calendar.SECOND, 59);
        return ca.getTime();
    }

    /**
     * 获取传入时间前一天的开始时间
     *
     * @return Date
     */
    public static Date getBeforeDayStartTime() {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, -1);
        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        ca.set(Calendar.MILLISECOND, 0);
        return ca.getTime();
    }

    /**
     * 函数功能描述:把只有小时和分钟的时间转为Calendar对象
     * 函数使用场景:比如 “08:00”转换为当天的Calendar对象
     *
     * @param time 只有小时和分钟的时间（以冒号隔开）
     * @return
     */
    public static Calendar getCalendarByMiniteAndSecond(String time) {
        Calendar calendar = Calendar.getInstance();
        if (!StringUtils.isEmpty(time)) {
            String[] times = time.split(":");
            calendar.set(11, Integer.parseInt(times[0]));
            calendar.set(12, Integer.parseInt(times[1]));
            calendar.set(13, 00);
            calendar.set(14, 000);
            return calendar;
        }
        return null;
    }
}
