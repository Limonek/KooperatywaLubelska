package com.example.kooperatywalubelska.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {User.class, Product.class, Order.class, OrderDetail.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    public abstract ProductDao productDao();

    public abstract OrderDetailDao orderDetailDao();

    public abstract OrderDao orderDao();

}
