package com.example.kooperatywalubelska.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.Date;
import java.util.List;

@Dao
public interface OrderDetailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(OrderDetail orderDetail);

    @Query("SELECT * FROM `OrderDetail`")
    List<OrderDetail> loadAllOrderDetails();

    @Query("SELECT o.*, p.name as `productName` FROM OrderDetail o join Product p on p.id = o.productId WHERE o.id = :orderDetailId AND o.lastRefresh > :lastRefreshMax LIMIT 1")
    OrderDetail hasEntity(String orderDetailId, Date lastRefreshMax);

    @Query("SELECT o.*, p.name as `productName` FROM OrderDetail o join Product p on p.id = o.productId where orderId = :orderId")
    LiveData<List<OrderDetail>> loadOrderOrderDetails(String orderId);

    @Query("DELETE FROM OrderDetail where id not in (:existingOrderDetailIds) and orderId == :orderId")
    void deleteAllOrderOrderDetailsExcept(List<Integer> existingOrderDetailIds, String orderId);

    @Query("DELETE FROM OrderDetail where id = :id")
    void deleteOrderDetail(Integer id);
}
