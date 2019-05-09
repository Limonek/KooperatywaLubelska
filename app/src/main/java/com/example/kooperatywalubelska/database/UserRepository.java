package com.example.kooperatywalubelska.database;

import com.example.kooperatywalubelska.Webservice;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import retrofit2.Call;

public class UserRepository  extends EntityRepository<User> {

    @Override
    public Call<GsonListDecorator<Integer>> getExistingEntityIds() {
        return webservice.getExistingUserIds();
    }

    @Override
    public Call<GsonListDecorator<User>> getEntitiesToUpdate() {
        return webservice.getAllUsers();
    }

    @Override
    public Call<User> getEntityFromWebservice(String entityId) {
        return webservice.getUser(entityId);
    }

    @Inject
    public UserRepository(Webservice webservice, UserDao userDao, Executor executor) {
        super(webservice,  userDao,  executor);
    }
}
