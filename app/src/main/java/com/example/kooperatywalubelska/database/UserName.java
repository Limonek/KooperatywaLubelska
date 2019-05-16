package com.example.kooperatywalubelska.database;

import androidx.room.Entity;

import com.google.gson.annotations.Expose;

import java.util.Date;

@Entity
public class UserName implements EntityWithDate {
    @Expose
    private String firstName;
    @Expose
    private String lastName;

    private Date lastRefresh;

    public UserName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserName(String firstName, String lastName, Date date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastRefresh = date;
    }

    @Override
    public Date getLastRefresh() {
        return lastRefresh;
    }

    @Override
    public void setLastRefresh(Date lastRefresh) {
        this.lastRefresh=lastRefresh;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
