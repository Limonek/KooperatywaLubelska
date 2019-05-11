package com.example.kooperatywalubelska.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import java.util.Date;

@Entity
public class Supplier implements EntityWithDate {
    @PrimaryKey
    @Expose
    private int id;
    @Expose
    private String name;
    @Expose
    private String didcription;

    private Date lastRefresh;

    public Supplier(int id,String name,String didcription) {
        this.id=id;
        this.name=name;
        this.didcription=didcription;
    }
    public Supplier(int id,String name,String didcription,Date lastRefresh) {
        this.id=id;
        this.name=name;
        this.didcription=didcription;
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

    public String getDidcription() {
        return didcription;
    }

    public void setDidcription(String didcription) {
        this.didcription = didcription;
    }
}