package com.mvc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-26 20:18
 */
public class DateFormatUtil {
    private String datePattern;
    private SimpleDateFormat dateFormat;

    public void setDatePattern(String pattern) {
        this.datePattern = pattern;
    }

    public String getDatePattern() {
        return datePattern;
    }

    public DateFormatUtil() {
        this.datePattern = "yyyy-MM-dd HH:mm:ss SSS";
        dateFormat = new SimpleDateFormat(datePattern);
        dateFormat.setLenient(false);
    }

    public DateFormatUtil(String pattern) {
        this.datePattern = pattern;
        dateFormat = new SimpleDateFormat(datePattern);
        dateFormat.setLenient(false);
    }

    public String format(Date date) {
        return dateFormat.format(date);
    }

    public Date parse(String s) {
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            System.out.println(e.toString());
        }

        return new Date();
    }

    public static Date parse(int y, int M, int d) {
        return new Date(y,M,d);
    }

    public static Date parse(int y, int M, int d, int h, int m, int s) {
        return new Date(y,M,d,h,m,s);
    }

    public static Date toDay() {
        return new Date();
    }
}