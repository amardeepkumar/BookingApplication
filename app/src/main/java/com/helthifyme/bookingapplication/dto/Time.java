
package com.helthifyme.bookingapplication.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.helthifyme.bookingapplication.data.AbstractExpandableDataProvider;

public class Time extends AbstractExpandableDataProvider.ChildData {

    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("is_booked")
    @Expose
    private Boolean isBooked;
    @SerializedName("is_expired")
    @Expose
    private Boolean isExpired;
    @SerializedName("slot_id")
    @Expose
    private Integer slotId;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    private transient String mText;
    private transient long mId;
    private transient boolean mPinned;

    /**
     * 
     * @return
     *     The endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 
     * @param endTime
     *     The end_time
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 
     * @return
     *     The isBooked
     */
    public boolean getIsBooked() {
        return isBooked;
    }

    @Override
    public boolean getIsAvailable() {
        return !isBooked && !isExpired;
    }

    /**
     * 
     * @param isBooked
     *     The is_booked
     */
    public void setIsBooked(Boolean isBooked) {
        this.isBooked = isBooked;
    }

    /**
     * 
     * @return
     *     The isExpired
     */
    public Boolean getIsExpired() {
        return isExpired;
    }

    /**
     * 
     * @param isExpired
     *     The is_expired
     */
    public void setIsExpired(Boolean isExpired) {
        this.isExpired = isExpired;
    }

    /**
     * 
     * @return
     *     The slotId
     */
    public Integer getSlotId() {
        return slotId;
    }

    /**
     * 
     * @param slotId
     *     The slot_id
     */
    public void setSlotId(Integer slotId) {
        this.slotId = slotId;
    }

    /**
     * 
     * @return
     *     The startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 
     * @param startTime
     *     The start_time
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public long getChildId() {
        return mId;
    }

    @Override
    public String getText() {
       return mText;
    }

    @Override
    public void setPinned(boolean pinned) {
        mPinned = pinned;
    }

    @Override
    public boolean isPinned() {
        return mPinned;
    }

    public void setChildId(long id) {
        this.mId = id;
    }

    public void setText(String text) {
        mText = text;
    }
}
