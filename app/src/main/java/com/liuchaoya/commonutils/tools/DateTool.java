package com.liuchaoya.commonutils.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *  日期类
 */
public class DateTool {

    private static final long INTERVAL_IN_MILLISECONDS = 60 * 1000;

    /*
     * 获取当前时间，以yyyyMMddHHmmss形式返回
     */
    public static String getNowDate() {
        String nowDate = "";
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        nowDate = format.format(date);
        return nowDate;
    }


    /*
     * 获取当前时间，以yyyyMMddHHmmss形式返回
     */
    public static String getNowDate(String yyyyMMddHHmmss) {
        String nowDate = "";
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat(yyyyMMddHHmmss);
        nowDate = format.format(date);
        return nowDate;
    }

    /*
     * 将以 yyyyMMddHHmmss格式的时间转换为date类型
     */
    public static Date getDate(String time) {

        Date date = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /*
     * 将固定格式的时间转换为date类型
     */
    public static Date getDate(String time, String formatStyle) {
        Date date = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat(formatStyle);
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /*
     * 将date转换为自己想要的形式
     */
    public static String getStringDate(Date date, String formatStyle) {
        String stringDate = "";
        SimpleDateFormat format = new SimpleDateFormat(formatStyle);
        stringDate = format.format(date);
        return stringDate;
    }

    /*
     * 将long型的时间，转换为自己想要的格式
     */
    public static String getStringDate(long time, String formatStyle) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        SimpleDateFormat format = new SimpleDateFormat(formatStyle);
        String stringDate = format.format(calendar.getTime());
        return stringDate;
    }

    /*
     * 将时间从yyyyMMddHHmmss格式转化为想要的格式
     */
    public static String getStringDate(String time, String formatStyle) {
        Date date = getDate(time);
        String stringDate = "";
        SimpleDateFormat format = new SimpleDateFormat(formatStyle);
        stringDate = format.format(date);
        return stringDate;
    }

    /*
     * 将时间从格式1转化为格式2
     */
    public static String getStringDate(String time, String formatStyle1,
                                       String formatStyle2) {
        Date date = getDate(time, formatStyle1);
        String stringDate = "";
        SimpleDateFormat format = new SimpleDateFormat(formatStyle2);
        stringDate = format.format(date);
        return stringDate;
    }

    /*
     * 是否是今天
     */
    private static boolean isToday(long inputTime) {

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);
        Date startDate = calendar1.getTime();
        long startTime = startDate.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.HOUR_OF_DAY, 23);
        calendar2.set(Calendar.MINUTE, 59);
        calendar2.set(Calendar.SECOND, 59);
        calendar2.set(Calendar.MILLISECOND, 999);
        Date endDate = calendar2.getTime();
        long endTime = endDate.getTime();

        return inputTime > startTime && inputTime < endTime;
    }

    /*
     * 是否是昨天
     */
    private static boolean isYesterday(long inputTime) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.DATE, -1);
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);

        Date startDate = calendar1.getTime();
        long startTime = startDate.getTime();

        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.DATE, -1);
        calendar2.set(Calendar.HOUR_OF_DAY, 23);
        calendar2.set(Calendar.MINUTE, 59);
        calendar2.set(Calendar.SECOND, 59);
        calendar2.set(Calendar.MILLISECOND, 999);
        Date endDate = calendar2.getTime();
        long endTime = endDate.getTime();

        return inputTime > startTime && inputTime < endTime;
    }

    /*
     * 展示时间
     */
    public static String getTimestampString(long messageTime) {

        messageTime = messageTime * 1000;
        Date messageDate = new Date(messageTime);
        String format = null;

        if (isToday(messageTime)) {
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTime(messageDate);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);

            format = "HH:mm";

            if (hour > 17) {
                format = "晚上 hh:mm";

            } else if (hour >= 0 && hour <= 6) {
                format = "凌晨 hh:mm";
            } else if (hour > 11 && hour <= 17) {
                format = "下午 hh:mm";

            } else {
                format = "上午 hh:mm";
            }
        } else if (isYesterday(messageTime)) {
            format = "昨天 HH:mm";

        } else {
            format = "M月d日 HH:mm";
        }

        return new SimpleDateFormat(format, Locale.CHINA).format(messageDate);
    }

    /*
     * 两个时间是否足够接近
     */
    public static boolean isCloseEnough(long time1, long time2) {
        long delta = time1 - time2;
        if (delta < 0) {
            delta = -delta;
        }
        return delta < INTERVAL_IN_MILLISECONDS;
    }

	/*
    * 拼接时间字符串
	* 处理时间选择工具返回的数据为yyyy-MM-dd格式
	* */

    public static String jointDateString(String separator, int year, int month, int day) {
        return year + separator + (month < 9 ? "0" : "") + (month + 1) + separator + (day < 10 ? "0" : "") + day;
    }
}
