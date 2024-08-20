package com.huyva.base.utils;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeUtils {

    public static final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static final String CMS_DATE_FORMAT = "dd/MM/yyyy";
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT);
    public static final SimpleDateFormat CMS_SIMPLE_DATE_FORMAT = new SimpleDateFormat(CMS_DATE_FORMAT);
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(CMS_DATE_FORMAT);

    private static final String excelFormat = "dd/MM/yyyy";
    public static final SimpleDateFormat EXCEL_FORMAT = new SimpleDateFormat(excelFormat);

    private static final String numberFormat = "yyyyMMdd";
    public static final SimpleDateFormat NUMBER_FORMAT = new SimpleDateFormat(numberFormat);

    private static final String numberWithHourFormat = "yyyyMMddHH";
    public static final SimpleDateFormat NUMBER_HOUR_FORMAT = new SimpleDateFormat(numberWithHourFormat);

    public static final SimpleDateFormat NUMBER_HOUR_STRING_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH");
    public static final String DD_MM_YYYY_F1 = "dd/MM/yyyy";
    public static final String DD_MM_YYYY_F2 = "dd-MM-yyyy";
    static {
        CMS_SIMPLE_DATE_FORMAT.setLenient(false);
    }


    public static String convertLongToStringDate(long time){

        try {
            String dateTime  = String.valueOf(time);

            Date date = NUMBER_FORMAT.parse(dateTime);


            return EXCEL_FORMAT.format(date);

        } catch (Exception e){
            return null;
        }
    }


    public static String convertLongToStringDateAndHour(long time){

        try {
            String dateTime  = String.valueOf(time);

            Date date = NUMBER_HOUR_FORMAT.parse(dateTime);


            return NUMBER_HOUR_STRING_FORMAT.format(date);

        } catch (Exception e){
            return null;
        }
    }

    public static String convertDateToStringDateAndHour(Date date){

        try {

            return NUMBER_HOUR_STRING_FORMAT.format(date);

        } catch (Exception e){
            return null;
        }
    }

    public static Long convertDateToLong(Date time){
        try {
            return Long.valueOf(NUMBER_FORMAT.format(time));
        } catch (Exception e){
            return 0L;
        }
    }

    public static Long convertDateToLongWithHour(Date time){
        try {
            return Long.valueOf(NUMBER_HOUR_FORMAT.format(time));
        } catch (Exception e){
            return 0L;
        }
    }

    public static LocalTime stringToTime(String time) {
        try {
            return LocalTime.parse(time, TIME_FORMATTER);
        } catch (Exception e) {
            return null;
        }
    }

    public static String timeToString(LocalTime time) {
        try {
            return time.format(TIME_FORMATTER);
        } catch (Exception e) {
            return null;
        }
    }

    public static LocalTime secondOfDayToLocalTime(int second) {
        try {
            return LocalTime.ofSecondOfDay(second);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date convertExcelFormat(String time) {
        try {
            return EXCEL_FORMAT.parse(time);
        } catch (Exception e) {
            return null;
        }

    }

    public static String dateToString(Date date) {
        if (date == null) return null;
        try {
            return SIMPLE_DATE_FORMAT.format(date);

        } catch (Exception e) {


        }
        return null;
    }

    public static Date stringToDateCMS(String source) {
        if (StringUtils.isEmpty(source)) return null;
        try {
            return CMS_SIMPLE_DATE_FORMAT.parse(source);

        } catch (Exception e) {


        }
        return null;
    }

    public static LocalDate stringToLocalDateCMs(String source) {
        if (StringUtils.isEmpty(source)) return null;
        try {
            return LocalDate.parse(source, DATE_FORMATTER);

        } catch (Exception e) {
           e.printStackTrace();
        }
        return null;
    }

    public static String localDateToStringCMs(LocalDate source) {
        if (source == null) return null;
        try {
            return DATE_FORMATTER.format(source);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String dateToStringCMS(Date date) {
        if (date == null) return null;
        try {
            return CMS_SIMPLE_DATE_FORMAT.format(date);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }


    public static Date stringToDate(String date) {
        if (StringUtils.isEmpty(date)) return null;
        try {
            return SIMPLE_DATE_FORMAT.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static DateRemain getRemain(Date begin, Date expired) {

        long dateIff = expired.getTime() - begin.getTime();

        if (dateIff <= 0) {
            return new DateRemain(0, TimeUnit.MILLISECONDS);
        }

        if (dateIff >= 86400000) {
            return new DateRemain(TimeUnit.DAYS.convert(dateIff, TimeUnit.MILLISECONDS), TimeUnit.DAYS);
        } else if (dateIff >= 3600000) {
            return new DateRemain(TimeUnit.HOURS.convert(dateIff, TimeUnit.MILLISECONDS), TimeUnit.HOURS);
        } else if (dateIff >= 60000) {
            return new DateRemain(TimeUnit.MINUTES.convert(dateIff, TimeUnit.MILLISECONDS), TimeUnit.MINUTES);
        } else {
            return new DateRemain(0, TimeUnit.MILLISECONDS);
        }


    }

    public static synchronized Date safeAddSecond(Date date, int second) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, second);
        return cal.getTime();

    }

    public static synchronized Date safeAddBeginDay(Date date, int day) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.add(Calendar.DAY_OF_MONTH, day);

        return cal.getTime();

    }

    public static DateRange getFirstAndEndOfDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);

        Date start = new Date(calendar.getTimeInMillis());
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        Date end = new Date(calendar.getTimeInMillis());

        return new DateRange(start, end);

    }

    public static Date getCurrentDateTime() {

        return new Date();
    }

    public static String getRemainStr(Date begin, Date expired) {
        DateRemain d = getRemain(begin, expired);


        return d.getValue() + " " + getTimeLabel(d.getTimeUnit());
    }

    public static String getTimeLabel(TimeUnit timeUnit) {
        switch (timeUnit) {
            case DAYS:
                return "Ngày";
            case HOURS:
                return "Giờ";
            case MINUTES:
                return "Phút";
            case SECONDS:
                return "Giây";
            default:
                return "";
        }
    }


    @Data
    public static class DateRemain {

        private long value;
        private TimeUnit timeUnit;

        public DateRemain(long value, TimeUnit timeUnit) {
            this.value = value;
            this.timeUnit = timeUnit;
        }

        public DateRemain() {

        }
    }

    @Data
    public static class DateRange {
        private Date first;
        private Date end;

        public DateRange(Date first, Date end) {
            this.first = first;
            this.end = end;
        }
    }

    public static String millisecondsToString(long milliseconds) {
        try {
            Date date = new Date(milliseconds);
            return SIMPLE_DATE_FORMAT.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static boolean match_dd_MM_yyyy(String datestr) {

        if (StringUtils.isBlank(datestr)) return false;

        try {

            CMS_SIMPLE_DATE_FORMAT.parse(datestr);

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public static boolean isExpire(Date expireDate) {

        return expireDate != null && getCurrentDateTime().compareTo(expireDate) >= 0;
    }

    public static String convertDateToString(Date date, String pattern) {

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

        String result = dateFormat.format(date);

        return result;
    }

    public static Date convertStringToDate(String s, String pattern) {
        if (StringUtils.isBlank(s)) {
            return null;
        }
        Date date = null;
        try {
            date = new SimpleDateFormat(pattern).parse(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
}