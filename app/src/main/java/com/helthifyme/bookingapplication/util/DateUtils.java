package com.helthifyme.bookingapplication.util;

import com.helthifyme.bookingapplication.dto.Day;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Amardeep on 28/5/16.
 */
public class DateUtils {

    public static String FORMAT = "yyyy-MM-dd";
    public static String FORMAT2 = "yyyy-MM-dd HH:mm:ssZ";

    public static String DAY_MONTH = "d";
    public static String DAY_WEEK = "ccc";
    public static String MONTH = "MMMM";
    public static String TIME_SLOT_FORMAT = "hh:mm a";

    public static final SimpleDateFormat sdf = new SimpleDateFormat(FORMAT, Locale.getDefault());
    public static final SimpleDateFormat sdf2 = new SimpleDateFormat(FORMAT2, Locale.getDefault());

    public static final SimpleDateFormat SDF_DAY_MONTH = new SimpleDateFormat(DAY_MONTH, Locale.getDefault());
    public static final SimpleDateFormat SDF_DAY_WEEK = new SimpleDateFormat(DAY_WEEK, Locale.getDefault());
    public static final SimpleDateFormat SDF_MONTH = new SimpleDateFormat(MONTH, Locale.getDefault());
    public static final SimpleDateFormat SDF_TIME_SLOT_FORMAT = new SimpleDateFormat(TIME_SLOT_FORMAT, Locale.getDefault());

    public static void formatDay(String dateString, Day day) {
        try {
            Date date = sdf.parse(dateString);
            day.setDay(SDF_DAY_MONTH.format(date));
            day.setDayOfWeek(SDF_DAY_WEEK.format(date));
            day.setMonth(SDF_MONTH.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static String formatTimeSlot(String startTime, String endTime) {
        try {
            Date date1 = sdf2.parse(startTime);
            Date date2 = sdf2.parse(endTime);
            return SDF_TIME_SLOT_FORMAT.format(date1) + " - " + SDF_TIME_SLOT_FORMAT.format(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return startTime + " - " + endTime;
    }
}
