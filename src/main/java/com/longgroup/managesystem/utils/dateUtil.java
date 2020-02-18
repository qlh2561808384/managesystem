package com.longgroup.managesystem.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class dateUtil {
    /*
     *  获取当前时间之Date
     *  获取当前时间 转换为指定格式的String时间
     * */
    public static String get24HCurrentTime_Date(String format){
        Date date = new Date();
        SimpleDateFormat sdf = null;
        if ("ymd".equals(format)) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        } else if ("ymdhms".equals(format)) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        String currentTime = sdf.format(date);
        return currentTime;
    }
    /*
     *  获取当前时间之Calendar
     *  获取当前时间 转换为指定格式的String时间
     * */
    public static String get24HCurrentTime_Calendar(String format){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = null;
        if ("ymd".equals(format)) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        } else if ("ymdhms".equals(format)) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        String currentTime = sdf.format(calendar.getTime());
        return currentTime;
    }

    /*
     * 获取当前时间之Calendar
     * */
    public static String get24HCurrentTimeAdd_Calendar(String format){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = null;
        if ("ymd".equals(format)) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        } else if ("ymdhms".equals(format)) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        /*在当前时间基础上加一年*/
        calendar.add(Calendar.YEAR, 1);
        /*在当前时间基础上加三个月*/
//        calendar.add(Calendar.MONTH,3);
        /*在当前时间基础上加十天*/
//        calendar.add(Calendar.DAY_OF_YEAR,10);
        String currentTime = sdf.format(calendar.getTime());
        return currentTime;
    }
    /*
     *  说明：传入一个String类型的时间  给你转成 Date类型
     * String类型的时间转Date类型的时间 年-月-日
     * time :
     *      表示日期
     *          格式 ：年-月-日
     * LocalDate :
     *      当前时间
     *          格式 ： 年-月-日
     * */
    public static Date stringToData(String time) {
        Date dt = null;
        String[] date = null;
        if (!time.isEmpty()) {
            date = time.split("-");
            LocalDate localDate = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
            //获取时区
            ZoneId zoneId = ZoneId.systemDefault();
            //初始化当前时区的时间
            Instant instant = localDate.atStartOfDay().atZone(zoneId).toInstant();
            dt = Date.from(instant);
        }
        return dt;
    }
    /*
    *   获取数据库Timestamp类型 用于实体类
    * */
    public static Timestamp getSqlTimeStamp(){
        Calendar calendar = Calendar.getInstance();
        long timeInMillis = calendar.getTimeInMillis();
        Timestamp timestamp = new Timestamp(timeInMillis);
        return timestamp;
    }

    /*
    *   说明：获取当前时间 转换成 指定格式的Date类型
    *   format:你想要的转换的格式
    * */
    @Deprecated
    public static Date strConverseDate(String format){
        Date date = new Date();
        SimpleDateFormat sdf = null;
        if ("ymd".equals(format)) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        } else if ("ymdhms".equals(format)) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        String simDate = sdf.format(date);
        ParsePosition pos = new ParsePosition(0);
        Date nowdate = null;
        try {
            nowdate = sdf.parse(simDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return nowdate;
    }

    /*
     *  获取一个注册码 时间+uuid
     *
     * */
    public static String getUuid() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        String date = get24HCurrentTimeAdd_Calendar("ymd").toString().replaceAll("-", "");
        return date + uuid;
    }
    /*
     *  获取指定个数注册码 时间+uuid
     *
     * */
    public static String[] getMoreUUID(int number){
        if(number < 1){
            return null;
        }
        String[] moreUuid = new String[number];
        for (int i = 0; i < number; i++) {
            moreUuid[i] = getUuid();
        }
        return moreUuid;
    }
}
