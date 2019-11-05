package com.peterguo.interview.java8.date;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {

    public static void main(String[] args) {

        /** LocalDate 表示的是时间 年月日 **/
        LocalDate localDate = LocalDate.of(2017, 1, 4);     // 初始化一个日期：2017-01-04
        int year = localDate.getYear();                     // 年份：2017
        Month month = localDate.getMonth();                 // 月份：JANUARY
        int dayOfMonth = localDate.getDayOfMonth();         // 月份中的第几天：4
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();     // 一周的第几天：WEDNESDAY
        int length = localDate.lengthOfMonth();             // 月份的天数：31
        boolean leapYear = localDate.isLeapYear();          // 是否为闰年：false

        /** LocalDate 表示的是时间 时分秒 **/
        LocalTime localTime = LocalTime.of(17, 23, 52);     // 初始化一个时间：17:23:52
        int hour = localTime.getHour();                     // 时：17
        int minute = localTime.getMinute();                 // 分：23
        int second = localTime.getSecond();                 // 秒：52

        /** LocalDateTime 表示的是时间 年月日时分秒 **/
        LocalDateTime ldt1 = LocalDateTime.of(2017, Month.JANUARY, 4, 17, 23, 52);

        LocalDate localDate1 = LocalDate.of(2017, Month.JANUARY, 4);
        LocalTime localTime1 = LocalTime.of(17, 23, 52);
        LocalDateTime ldt2 = localDate.atTime(localTime1);

        /** 可以相互转换 **/
        LocalDate date = ldt1.toLocalDate();
        LocalTime time = ldt1.toLocalTime();

        LocalDate localDate2 = LocalDate.now(ZoneId.systemDefault());


        /** 格式化输出日期**/
        String str1 = "2014==04==12 01时06分09秒";
        // 根据需要解析的日期、时间字符串定义解析所用的格式器
        DateTimeFormatter fomatter1 = DateTimeFormatter.ofPattern("yyyy==MM==dd HH时mm分ss秒");

        LocalDateTime dt1 = LocalDateTime.parse(str1, fomatter1);
        System.out.println(dt1); // 输出 2014-04-12T01:06:09

        String str2 = "2014$$$四月$$$13 20小时";
        DateTimeFormatter fomatter2 = DateTimeFormatter.ofPattern("yyy$$$MMM$$$dd HH小时");
        LocalDateTime dt2 = LocalDateTime.parse(str2, fomatter2);
        System.out.println(dt2); // 输出 2014-04-13T20:00
    }
}
