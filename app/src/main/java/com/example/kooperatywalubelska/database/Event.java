package com.example.kooperatywalubelska.database;

import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import java.util.Date;

public class Event implements EntityWithDate {
    @PrimaryKey
    @Expose
    private int id;
    @Expose
    private String name;
    @Expose
    private String decsription;
    @Expose
    private Date date;
    @Expose
    private int minimalParticipantsAmount;
    @Expose
    private int maximalParticipantsAmount;

    private Date lastRefresh;

    public Event(int id,String name,String decsription,Date date,int minimalParticipantsAmount,int maximalParticipantsAmount) {
        this.id=id;
        this.name=name;
        this.decsription=decsription;
        this.date=date;
        this.minimalParticipantsAmount=minimalParticipantsAmount;
        this.maximalParticipantsAmount=maximalParticipantsAmount;
    }
    public Event(int id,String name,String decsription,Date date,int minimalParticipantsAmount,int maximalParticipantsAmount,Date lastRefresh) {
        this.id=id;
        this.name=name;
        this.decsription=decsription;
        this.date=date;
        this.minimalParticipantsAmount=minimalParticipantsAmount;
        this.maximalParticipantsAmount=maximalParticipantsAmount;
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

    public String getDecsription() {
        return decsription;
    }

    public void setDecsription(String decsription) {
        this.decsription = decsription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMinimalParticipantsAmount() {
        return minimalParticipantsAmount;
    }

    public void setMinimalParticipantsAmount(int minimalParticipantsAmount) {
        this.minimalParticipantsAmount = minimalParticipantsAmount;
    }

    public int getMaximalParticipantsAmount() {
        return maximalParticipantsAmount;
    }

    public void setMaximalParticipantsAmount(int maximalParticipantsAmount) {
        this.maximalParticipantsAmount = maximalParticipantsAmount;
    }
}
