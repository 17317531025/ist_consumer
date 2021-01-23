package com.ist.kafka.consumer.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Slf4j
public class DateUtil {
    public static String PATTERN_DATE_TIME = "yyyyMMddHHmmss";
    public static String PATTERN_MS_DATE_TIME = "yyyyMMddHHmmssSSS";
    public static String PATTERN_DATE_TIME_1 = "yyyy-MM-dd HH:mm:ss";
    public static String PATTERN_DATE_TIME_2 = "yyyy-MM-dd HH:mm:ss SSS";
    public static String PATTERN_DATE = "yyyyMMdd";
    public static String PATTERN_DATE_1 = "yyyy-MM-dd";
    public static String PATTERN_DATE_GMT = "E MMM dd HH:mm:ss zzz yyyy";
    public static String PATTERN_DATE_CST = "EEE MMM dd HH:mm:ss zzz yyyy";

    /**
     * 按照指定日期格式将日期字符串转换为Date
     * @param dateStr
     * @param pattern
     * @return Date
     */
    public static final Date formatDateStr(String dateStr, String pattern)
    {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(pattern);
        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            log.error("DateUtil.formatDateStr exception:", e);
        }
        return date;
    }


    public static String getString(Date date){
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }


    public static String getString(Date date, String pattern){
        if (date == null) {
            return null;
        }
        if (StringUtils.isBlank(pattern)) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static boolean check(String startDateStr, String endDateEnd, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        try {
            return sdf.parse(startDateStr).before(sdf.parse(endDateEnd));
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Date parseDateFromStrMonth(String str, boolean beginFlag){
        Date temp;
        if (StringUtils.isNotBlank(str)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

            try {
                temp = sdf.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            temp = new Date();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(temp);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        if (beginFlag) {
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
        } else {
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+1);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)-1);
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
        }
        return calendar.getTime();
    }

    public static Date parseDateFromStrDay(String str, boolean beginFlag){
        Date temp;
        if (StringUtils.isNotBlank(str)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            try {
                temp = sdf.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            temp = new Date();
        }
        return getDate(temp, beginFlag);
    }

    public static Date getDate(Date date, boolean beginFlag){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (beginFlag) {
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
        } else {
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
        }
        return calendar.getTime();
    }

    public static boolean checkPattern(String birthday, String pattern) {
        if (birthday == null || "".equals(birthday)) {
            return false;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.format(birthday);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
