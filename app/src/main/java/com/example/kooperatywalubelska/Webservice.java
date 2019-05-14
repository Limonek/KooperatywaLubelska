package com.example.kooperatywalubelska;

import com.example.kooperatywalubelska.database.GsonListDecorator;
import com.example.kooperatywalubelska.database.Prediction;
import com.example.kooperatywalubelska.database.Product;
import com.example.kooperatywalubelska.database.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Webservice {
    @GET("/get_user_details.php")
    Call<User> getUser(@Query("user_id") String userId);

    @GET("/get_all_users.php")
    Call<GsonListDecorator<User>> getAllUsers();

    @GET("/get_all_user_ids.php")
    Call<GsonListDecorator<Integer>> getExistingUserIds();

    @GET("/get_product_details.php")
    Call<Product> getProduct(@Query("user_id") String userId);

    @GET("/get_all_products.php")
    Call<GsonListDecorator<Product>> getAllProducts();

    @GET("/get_all_product_ids.php")
    Call<GsonListDecorator<Integer>> getExistingProductIds();

    @GET("/predykcja.php")
    Call<GsonListDecorator<Prediction>> getPredictionForProduct(@Query("month") String month, @Query("product_id") int productId);

}
