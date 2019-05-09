package com.example.kooperatywalubelska.database;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import java.util.Date;

@Entity
public class Product implements EntityWithDate {
    @PrimaryKey
    @Expose
    private int id;
    @Expose
    private String name;
    @Expose
    private String description;
    @Expose
    private boolean availability;
    @Expose
    private int minimalAmount;
    @Expose
    private int maximalAmount;
    @Expose
    @ForeignKey(entity = Supplier.class, parentColumns = "id", childColumns = "supplierId")
    private int supplierId;
    @Expose
    @ForeignKey(entity = Supplier.class, parentColumns = "id", childColumns = "categoryId")
    private int categoryId;

    private Date lastRefresh;

    @Override
    public Date getLastRefresh() {
        return lastRefresh;
    }

    @Override
    public void setLastRefresh(Date lastRefresh) {
        this.lastRefresh = lastRefresh;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getMinimalAmount() {
        return minimalAmount;
    }

    public void setMinimalAmount(int minimalAmount) {
        this.minimalAmount = minimalAmount;
    }

    public int getMaximalAmount() {
        return maximalAmount;
    }

    public void setMaximalAmount(int maximalAmount) {
        this.maximalAmount = maximalAmount;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
