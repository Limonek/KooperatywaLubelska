package com.example.kooperatywalubelska.database;

import com.example.kooperatywalubelska.Webservice;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import retrofit2.Call;

public class ProductRepository extends EntityRepository<Product> {

    @Override
    public Call<GsonListDecorator<Integer>> getExistingEntityIds() {
        return webservice.getExistingUserIds();
    }

    @Override
    public Call<GsonListDecorator<Product>> getEntitiesToUpdate() {
        return webservice.getAllProducts();
    }

    @Override
    public Call<Product> getEntityFromWebservice(String entityId) {
        return webservice.getProduct(entityId);
    }

    @Inject
    public ProductRepository(Webservice webservice, ProductDao productDao, Executor executor) {
        super(webservice,  productDao,  executor);
    }
}
