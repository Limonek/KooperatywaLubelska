package com.example.kooperatywalubelska.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import java.util.Date;

@Entity
public class Category implements EntityWithDate {
    @PrimaryKey
    @Expose
    private int id;
    @Expose
    private String name;

    private Date lastRefresh;

    public Category(int id,String name) {
        this.id=id;
        this.name=name;
    }
    public Category(int id,String name,Date date) {
        this.id=id;
        this.name=name;
        this.lastRefresh=date;
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

}
