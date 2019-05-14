package com.example.kooperatywalubelska.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.Date;
import java.util.List;

@Dao
public interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(Order order);

    @Query("SELECT * FROM `Order`")
    List<Order> loadAllOrders();

    @Query("SELECT * FROM `Order` WHERE id = :orderId AND lastRefresh > :lastRefreshMax LIMIT 1")
    Order hasOrder(String orderId, Date lastRefreshMax);

    @Query("SELECT * FROM `Order` WHERE date = :orderDate AND lastRefresh > :lastRefreshMax LIMIT 1")
    Order hasOrder(Date orderDate, Date lastRefreshMax);

    @Query("SELECT * FROM `Order` where id = :orderId")
    LiveData<Order> loadOrder(String orderId);

    @Query("SELECT * FROM `Order` where date = :date")
    LiveData<Order> loadOrder(Date date);

    @Query("DELETE FROM `Order` where id not in (:existingOrderIds) and id == :orderId")
    void deleteAllOrdersExcept(List<Integer> existingOrderIds, String orderId);
}
