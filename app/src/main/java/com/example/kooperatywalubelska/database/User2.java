package com.example.kooperatywalubelska.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

@Entity
public class User2 implements EntityWithDate {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private String address;
    @Expose
    private String phone;
    @Expose
    private String email;

    private Date lastRefresh;

    public User2(String firstName, String lastName, String address, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public User2(String firstName, String lastName, String address, String phone, String email, Date date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.lastRefresh = date;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Date getLastRefresh() {
        return lastRefresh;
    }

    @Override
    public void setLastRefresh(Date lastRefresh) {
        this.lastRefresh = lastRefresh;
    }
}
