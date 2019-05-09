package com.example.kooperatywalubelska.database;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import java.util.Date;

@Entity
public class Order implements EntityWithDate {

    private Date lastRefresh;

    @PrimaryKey
    @Expose
    private int id;

    @Expose
    @ForeignKey(entity = User.class, parentColumns = "id", childColumns = "userId")
    private int userId;

    @Expose
    private Date date;

    @Override
    public Date getLastRefresh() {
        return lastRefresh;
    }

    @Override
    public void setLastRefresh(Date lastRefresh) {
        this.lastRefresh = lastRefresh;
    }
}
