package com.example.kooperatywalubelska.database;

import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import java.util.Date;

public class TradeUnitProduct implements EntityWithDate {
    @PrimaryKey
    @Expose
    private int id;
    @Expose
    @ForeignKey(entity=TradeUnit.class,parentColumns = "id", childColumns = "tradeUnitId")
    private int tradeUnitId;
    @Expose
    private double price;

    private Date lastRefresh;

    public TradeUnitProduct(int id, int tradeUnitId, double price) {
        this.id=id;
        this.tradeUnitId=tradeUnitId;
        this.price=price;
    }
    public TradeUnitProduct(int id, int tradeUnitId, double price, Date lastRefresh) {
        this.id=id;
        this.tradeUnitId=tradeUnitId;
        this.price=price;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTradeUnitId() {
        return tradeUnitId;
    }

    public void setTradeUnitId(int tradeUnitId) {
        this.tradeUnitId = tradeUnitId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
