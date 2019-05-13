package com.example.kooperatywalubelska.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

@Entity
public class User implements EntityWithDate {
    @PrimaryKey
    @Expose
    private int id;
    @Expose
    private String login;
    @Expose
    private String password;
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
    @Expose
    private boolean activeAccount;
    @Expose
    private boolean administrator;
    @Expose
    private boolean supplier;

    private Date lastRefresh;

    public User(int id, String login, String password, String firstName, String lastName, String address, String phone, String email, boolean activeAccount, boolean administrator, boolean supplier) {
        this.id = id;
        this.login=login;
        this.password=password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.activeAccount = activeAccount;
        this.administrator = administrator;
        this.supplier=supplier;
    }

    public User(int id, String login, String password, String firstName, String lastName, String address, String phone, String email, boolean activeAccount, boolean administrator, boolean supplier,Date date) {
        this.id = id;
        this.login=login;
        this.password=password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.activeAccount = activeAccount;
        this.administrator = administrator;
        this.supplier=supplier;
        this.lastRefresh = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSupplier() {
        return supplier;
    }

    public void setSupplier(boolean supplier) {
        this.supplier = supplier;
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

    public boolean isActiveAccount() {
        return activeAccount;
    }

    public void setActiveAccount(boolean activeAccount) {
        this.activeAccount = activeAccount;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

    public Date getLastRefresh() {
        return lastRefresh;
    }

    public void setLastRefresh(Date lastRefresh) {
        this.lastRefresh = lastRefresh;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).
                append("firstName", firstName).
                append("lastName", lastName).
                toString();
    }

}
