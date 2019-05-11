package com.example.kooperatywalubelska.database;

import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import java.util.Date;

public class UserEvent implements EntityWithDate {
    @Expose
    @ForeignKey(entity = User.class,parentColumns = "id",childColumns = "userId")
    private int userId;
    @Expose
    @ForeignKey(entity = Event.class,parentColumns = "id",childColumns = "eventId")
    private int eventId;

    private Date lastRefresh;

    public UserEvent(int userId,int eventId) {
        this.userId=userId;
        this.eventId=eventId;
    }
    public UserEvent(int userId,int eventId,Date lastRefresh) {
        this.userId=userId;
        this.eventId=eventId;
        this.lastRefresh=lastRefresh;
    }

    @Override
    public Date getLastRefresh() {
        return lastRefresh;
    }

    @Override
    public void setLastRefresh(Date lastRefresh) {
        this.lastRefresh=lastRefresh;
    }
}
