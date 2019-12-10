package com.jijian.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author wangshangyi
 * @version V1.0  2019/9/23 10:05
 * @description
 */
public class DateTimeUtil {

    /**
     * 日期时间格式转字符串 yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String dateTimeToStr(String formatStr, Date date) {
        if (date == null || StringUtils.isBlank(formatStr)) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                formatStr);
        return dateFormat.format(date);
    }

    /**
     * 字符串转换成日期
     *
     * @param formatStr 转换格式
     * @param dateStr   需要转换的日期时间字符串
     * @return date
     */
    public static Date strToDate(String formatStr, String dateStr) {
        if (StringUtils.isBlank(dateStr) || StringUtils.isBlank(formatStr)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 当前日期 yyyy-MM-dd
     *
     * @return
     */
    public static String getCurDate() {
        return (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
    }

    /**
     * 获取当前时间（HH:mm:ss）
     * @return
     */
    public static String getCurrentTime() {
        return dateTimeToStr("HH:mm:ss", new Date());
    }

    /**
     * 获取当前日期时间（yyyy-MM-dd HH:mm:ss）
     * @return
     * @author wangshangyi
     */
    public static String getCurrentDateTime() {
        return dateTimeToStr("yyyy-MM-dd HH:mm:ss", new Date());
    }

    /**
     * 在给定的日期加上或减去指定月份后的日期
     *
     * @param sourceDate 原始时间
     * @param month      要调整的月份，向前为负数，向后为正数
     * @return
     */
    public static Date stepMonth(Date sourceDate, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.MONTH, month);

        return c.getTime();
    }

    /**
     * 时间戳转Unix时间戳
     *
     * @param timestamp
     * @return
     */
    public static long toUnixTimeStamp(long timestamp) {
        return timestamp / 1000;
    }

    /**
     * 第二天0点的 unix时间
     * @param date
     * @return
     */
    public static Long tomorrowZeroUnixTimeStamp(Date date){
        if (date == null){
            return null ;
        }
        Date tomorrow =strToDate("yyyy-MM-dd HH:mm:ss", dateAdd(1,date)+" 00:00:00");
        if (tomorrow == null){return null;}
        return toUnixTimeStamp(tomorrow.getTime());
    }

    /**
     * 判断今天是否是生日
     *
     * @param birthday
     * @return
     * @author wangshangyi
     */
    public static boolean todayIsBirthday(Date birthday) {
        if (birthday == null) {
            return false;
        }
        String today = getCurDate();
        String birthdayStr = dateTimeToStr("yyyy-MM-dd", birthday);
        return StringUtils.equals(today, birthdayStr);
    }


    /**
     * 日期加减天数（正数加，负数减）
     *
     * @param count 加减天数（1或者-1）
     * @param date  （操作日期）
     * @return
     * @author wangshangyi
     */
    public static String dateAdd(int count, Date date) {
        if (date == null) {
            return null;
        }
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.DATE, count);
        return dateTimeToStr("yyyy-MM-dd", ca.getTime());
    }

    /**
     * 根据生日计算年龄
     * @param birthday 生日
     * @return java.lang.String
     * @date  2019/10/11 18:01
     * @author wangshangyi
     */
    public static String getAgeByBirthday(Date birthday) {
        Calendar now = Calendar.getInstance();
        Calendar b = Calendar.getInstance();
        b.setTime(birthday);
        int year = now.get(Calendar.YEAR) - b.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) - b.get(Calendar.MONTH);
        if (month < 0) {
            month = 12 - b.get(Calendar.MONTH) + now.get(Calendar.MONTH);
            year -= 1;
        }
        return String.format("%d岁%d个月",year,month);
    }

    /**
     * 给时间添加 时分秒(00:00:00)
     */
    public static String returnZeroMinute(String dateTime) {
        return dateTime + " 00:00:00";
    }

    /**
     * 给时间添加 时分秒(23:59:59)
     */
    public static String returnMaxMinute(String dateTime) {
        return dateTime + " 23:59:59";
    }
}
