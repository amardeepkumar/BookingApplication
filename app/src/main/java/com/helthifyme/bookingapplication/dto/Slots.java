
package com.helthifyme.bookingapplication.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Slots {

    @SerializedName("date")
    @Expose
    private Day date;

    /**
     * 
     * @return
     *     The date
     */
    public Day getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(Day date) {
        this.date = date;
    }

}
