package com.example.kooperatywalubelska.database;

import androidx.lifecycle.LiveData;

import java.util.Date;
import java.util.List;

public interface EntityDao<Entity> {
    LiveData<List<Entity>> loadAllEntities();

    LiveData<Entity> load(String enityId);

    Entity hasEntity(String entityId, Date lastRefreshMax);

    void save(Entity entity);

    void deleteAllEntitiesExcept(List<Integer> existingUserIds);
}
