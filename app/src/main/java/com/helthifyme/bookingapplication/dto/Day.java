
package com.helthifyme.bookingapplication.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Day {

    @SerializedName("afternoon")
    @Expose
    private List<Time> afternoon = new ArrayList<>();
    @SerializedName("evening")
    @Expose
    private List<Time> evening = new ArrayList<>();
    @SerializedName("morning")
    @Expose
    private List<Time> morning = new ArrayList<>();
    private transient String day;
    private transient String dayOfWeek;
    private transient String month;

    /**
     * 
     * @return
     *     The time
     */
    public List<Time> getAfterNoon() {
        return afternoon;
    }

    /**
     * 
     * @param afternoon
     *     The time
     */
    public void setAfterNoon(List<Time> afternoon) {
        this.afternoon = afternoon;
    }

    /**
     * 
     * @return
     *     The evening
     */
    public List<Time> getEvening() {
        return evening;
    }

    /**
     * 
     * @param evening
     *     The evening
     */
    public void setEvening(List<Time> evening) {
        this.evening = evening;
    }

    /**
     * 
     * @return
     *     The morning
     */
    public List<Time> getMorning() {
        return morning;
    }

    /**
     * 
     * @param morning
     *     The morning
     */
    public void setMorning(List<Time> morning) {
        this.morning = morning;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

}
