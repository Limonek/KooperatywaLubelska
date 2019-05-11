package com.example.kooperatywalubelska.database;

import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import java.util.Date;

public class TradeUnit implements EntityWithDate {
    @PrimaryKey
    @Expose
    private int id;
    @Expose
    private String name;
    @Expose
    private String symbol;
    @Expose
    private int unityPrecision;

    private Date lastRefresh;

    public TradeUnit(int id,String name,String symbol,int unityPrecision) {
        this.id=id;
        this.name=name;
        this.symbol=symbol;
        this.unityPrecision=unityPrecision;
    }
    public TradeUnit(int id,String name,String symbol,int unityPrecision,Date lastRefresh) {
        this.id=id;
        this.name=name;
        this.symbol=symbol;
        this.unityPrecision=unityPrecision;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getUnityPrecision() {
        return unityPrecision;
    }

    public void setUnityPrecision(int unityPrecision) {
        this.unityPrecision = unityPrecision;
    }
}
