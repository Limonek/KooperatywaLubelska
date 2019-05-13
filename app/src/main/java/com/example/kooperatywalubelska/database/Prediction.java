package com.example.kooperatywalubelska.database;

import com.google.gson.annotations.Expose;

import java.util.Date;

public class Prediction implements EntityWithDate {
    @Expose
    private String rok;
    @Expose
    private int ilosc;

    private Date lastRefresh;

    @Override
    public Date getLastRefresh() {
        return lastRefresh;
    }

    @Override
    public void setLastRefresh(Date lastRefresh) {
        this.lastRefresh=lastRefresh;
    }

    public String getRok() {
        return rok;
    }

    public void setRok(String rok) {
        this.rok = rok;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
}
