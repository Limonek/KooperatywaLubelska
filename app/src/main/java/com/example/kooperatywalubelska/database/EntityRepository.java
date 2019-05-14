package com.example.kooperatywalubelska.database;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.kooperatywalubelska.Webservice;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class EntityRepository<Entity extends EntityWithDate> {
    private static int FRESH_TIMEOUT_IN_MINUTES = 1;
    public static int FRESH_TIMEOUT_IN_SECONDS = 15;
    protected final Webservice webservice;
    protected final EntityDao<Entity> entityDao;
    private final Executor executor;

    public abstract Call<GsonListDecorator<Integer>> getExistingEntityIds();

    public abstract Call<GsonListDecorator<Entity>> getEntitiesToUpdate();

    public abstract Call<Entity> getEntityFromWebservice(String entityId);

    public EntityRepository(Webservice webservice, EntityDao<Entity> entityDao, Executor executor) {
        this.webservice = webservice;
        this.entityDao = entityDao;
        this.executor = executor;
    }

    public LiveData<List<Entity>> getAllEntities() {
        refreshAllEntities();
        return entityDao.loadAllEntities();
    }

    public LiveData<Entity> getEntity(String enityId) {
        refreshEntity(enityId);
        return entityDao.load(enityId);
    }

    private Callback<GsonListDecorator<Entity>> entitiesToUpdateCallback = new Callback<GsonListDecorator<Entity>>() {
        @Override
        public void onResponse(Call<GsonListDecorator<Entity>> call, Response<GsonListDecorator<Entity>> response) {
            Log.e("TAG", "DATA REQUEST " + call.request().toString());
            executor.execute(() -> {
                GsonListDecorator<Entity> gsonListDecorator = response.body();
                if (response.body().getArrayList() != null)
                    for (Entity entity : gsonListDecorator.getArrayList()) {
                        entityDao.save(entity);
                        Log.e("TAG", entity.toString());
                    }
            });
        }

        @Override
        public void onFailure(Call<GsonListDecorator<Entity>> call, Throwable t) {
            Log.e("TAG", "Call<GsonListDecorator<Entity>>: " + call.toString());
            Log.e("TAG", "Call<GsonListDecorator<Entity>>.request: " + call.request().toString());
            Log.e("TAG", "Throwable: " + t.toString());
        }
    };

    Callback<GsonListDecorator<Integer>> deleteAllButSpecifiedIdsCallback = new Callback<GsonListDecorator<Integer>>() {
        @Override
        public void onResponse(Call<GsonListDecorator<Integer>> call, Response<GsonListDecorator<Integer>> response) {
            executor.execute(() -> {
                GsonListDecorator<Integer> integerList = response.body();
                entityDao.deleteAllEntitiesExcept(integerList.getArrayList());
            });
        }

        @Override
        public void onFailure(Call<GsonListDecorator<Integer>> call, Throwable t) {
            Log.e("TAG", "Call<IntegerList>: " + call.toString());
            Log.e("TAG", "Call<IntegerList>.request: " + call.request().toString());
            Log.e("TAG", "Throwable: " + t.toString());
        }
    };

    public void refreshAllEntities() {
        executor.execute(() -> {
            getEntitiesToUpdate().enqueue(entitiesToUpdateCallback);
            getExistingEntityIds().enqueue(deleteAllButSpecifiedIdsCallback);
        });
    }

    Callback<Entity> saveEntityCallback = new Callback<Entity>() {
        @Override
        public void onResponse(Call<Entity> call, Response<Entity> response) {
            Log.e("TAG", "DATA REQUEST " + call.request().toString());
            executor.execute(() -> {
                Entity entity = response.body();
                entity.setLastRefresh(new Date());
                entityDao.save(entity);
                Log.e("TAG", entity.toString());
            });
        }

        @Override
        public void onFailure(Call<Entity> call, Throwable t) {
            Log.e("TAG", "Call<Entity>: " + call.toString());
            Log.e("TAG", "Request: " + call.request().toString());
            Log.e("TAG", "Request.body: " + call.request().body());
            Log.e("TAG", "Throwable: " + t.toString());
        }
    };

    private void refreshEntity(final String entityId) {
        executor.execute(() -> {
            Entity entity = entityDao.hasEntity(entityId, getMaxRefreshTime(new Date()));
            boolean entityNotExists = entity == null;
            if (entityNotExists) {
                Log.e("TAG", "ENTITY NOT EXISTS " + entityId);
                getEntityFromWebservice(entityId).enqueue(saveEntityCallback);
            } else
                Log.e("TAG", "ENTITY EXISTS " + entity.toString());
        });
    }

    public static Date getMaxRefreshTime(Date currentDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
//        cal.add(Calendar.MINUTE, -FRESH_TIMEOUT_IN_MINUTES);
        cal.add(Calendar.SECOND, -FRESH_TIMEOUT_IN_SECONDS);
        return cal.getTime();
    }
}
