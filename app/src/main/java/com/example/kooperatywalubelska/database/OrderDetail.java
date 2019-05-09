package com.example.kooperatywalubelska.database;

import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import java.util.Date;

public class OrderDetail implements EntityWithDate {

    @PrimaryKey
    @Expose
    private int id;

    @Expose
    @ForeignKey(entity = Product.class, parentColumns = "id", childColumns = "productId")
    private int productId;

    @Expose
    private int quantity;

    private Date lastRefresh;

    @Override
    public Date getLastRefresh() {
        return lastRefresh;
    }

    @Override
    public void setLastRefresh(Date lastRefresh) {
        this.lastRefresh = lastRefresh;
    }
}
