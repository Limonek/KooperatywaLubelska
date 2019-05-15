package com.example.kooperatywalubelska.database;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import java.util.Date;

@Entity
public class OrderDetail implements EntityWithDate {

    public OrderDetail() {
    }

    @PrimaryKey(autoGenerate = true)
    @Expose
    private int id;

    @Expose
    @ForeignKey(entity = Product.class, parentColumns = "id", childColumns = "productId")
    private int productId;

    @Expose
    private int quantity;

    @Expose
    @ForeignKey(entity = TradeUnit.class, parentColumns = "id", childColumns = "tradeUnitId")
    private int tradeUnitId;

    @Expose
    @ForeignKey(entity = Order.class, parentColumns = "id", childColumns = "orderId")
    private int orderId;

    private Date lastRefresh;

    String productName;

    @Ignore
    public OrderDetail(int quantity, int productId, int tradeUnitId, int orderId) {
        this.quantity = quantity;
        this.productId = productId;
        this.tradeUnitId = tradeUnitId;
        this.orderId = orderId;
    }

    @Ignore
    public OrderDetail(int id, int quantity, int productId, int tradeUnitId, Date lastRefresh) {
        this.id = id;
        this.quantity = quantity;
        this.productId = productId;
        this.tradeUnitId = tradeUnitId;
        this.lastRefresh = lastRefresh;
    }

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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTradeUnitId() {
        return tradeUnitId;
    }

    public void setTradeUnitId(int tradeUnitId) {
        this.tradeUnitId = tradeUnitId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}
