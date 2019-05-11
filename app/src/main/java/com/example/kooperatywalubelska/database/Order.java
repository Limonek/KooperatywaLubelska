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

    public Order(int id,int userId,Date date) {
        this.id=id;
        this.userId=userId;
        this.date=date;
    }
    public Order(int id,int userId,Date date,Date lastRefresh) {
        this.id=id;
        this.userId=userId;
        this.date=date;
        this.lastRefresh=lastRefresh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
