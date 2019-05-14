package com.example.kooperatywalubelska.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.Date;
import java.util.List;

@Dao
public interface ProductDao extends EntityDao<Product> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(Product product);

    @Query("SELECT * FROM Product")
    List<Product>loadAllProducts();

    @Query("SELECT * FROM Product WHERE id = :productId")
    LiveData<Product> load(String productId);

    @Query("SELECT * FROM Product WHERE id = :productId AND lastRefresh > :lastRefreshMax LIMIT 1")
    Product hasEntity(String productId, Date lastRefreshMax);

    @Query("SELECT * FROM Product")
    LiveData<List<Product>>loadAllEntities();

    @Query("SELECT * FROM Product product where exists (select * from OrderDetail orderDetail where product.id = orderDetail.id)")
    LiveData<List<Product>> loadOrderedProducts();

    @Query("SELECT * FROM Product product where not exists (select * from OrderDetail orderDetail where product.id = orderDetail.productId)")
    LiveData<List<Product>> loadNotOrderedProducts();

    @Query("DELETE FROM Product where id not in (:existingProductIds)")
    void deleteAllEntitiesExcept(List<Integer> existingProductIds);

}
