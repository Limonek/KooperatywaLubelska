package com.example.kooperatywalubelska.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.Date;
import java.util.List;

@Dao
public interface UserDao extends EntityDao<User> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(User user);

    @Query("SELECT * FROM user WHERE id = :userId")
    LiveData<User> load(String userId);

    @Query("SELECT * FROM user WHERE id = :userId AND lastRefresh > :lastRefreshMax LIMIT 1")
    User hasEntity(String userId, Date lastRefreshMax);

    @Query("SELECT * FROM user")
    LiveData<List<User>> loadAllEntities();

    @Query("DELETE FROM user where id not in (:existingUserIds) ")
    void deleteAllEntitiesExcept(List<Integer> existingUserIds);
}