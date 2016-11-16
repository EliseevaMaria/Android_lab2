package com.example.eliseeva.lab1;

import java.util.Calendar;

public class CalendarConverter {
    public static String getTime(Calendar calendar){
        String hour = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
        if(hour.length() == 1)
            hour = "0" + hour;
        String minute = Integer.toString(calendar.get(Calendar.MINUTE));
        if(minute.length() == 1)
            minute = "0" + minute;

        return hour + ":" + minute;
    }

    public static String getDate(Calendar calendar){
        String day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
        if(day.length() == 1)
            day = "0" + day;
        String month = Integer.toString(calendar.get(Calendar.MONTH) + 1);
        if(month.length() == 1)
            month = "0" + month;
        return day + "." + month + "."
                + calendar.get(Calendar.YEAR);
    }

    public static String getDateTime(Calendar calendar){
        String day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
        if(day.length() == 1)
            day = "0" + day;
        String month = Integer.toString(calendar.get(Calendar.MONTH) + 1);
        if(month.length() == 1)
            month = "0" + month;
        String hour = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
        if(hour.length() == 1)
            hour = "0" + hour;
        String minute = Integer.toString(calendar.get(Calendar.MINUTE));
        if(minute.length() == 1)
            minute = "0" + minute;

        return day + "." + month + "."
                + calendar.get(Calendar.YEAR) + " " + hour + ":" + minute;

    }
}