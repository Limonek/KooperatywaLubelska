package com.example.kooperatywalubelska.di;

import android.app.Application;

import androidx.room.Room;

import com.example.kooperatywalubelska.Webservice;
import com.example.kooperatywalubelska.database.OrderDao;
import com.example.kooperatywalubelska.database.OrderDetailDao;
import com.example.kooperatywalubelska.database.OrderDetailRepository;
import com.example.kooperatywalubelska.database.OrderRepository;
import com.example.kooperatywalubelska.database.ProductDao;
import com.example.kooperatywalubelska.database.ProductRepository;
import com.example.kooperatywalubelska.database.UserDao;
import com.example.kooperatywalubelska.database.UserDatabase;
import com.example.kooperatywalubelska.database.UserRepository;
import com.example.kooperatywalubelska.viewmodels.OrderDetailViewModelFactory;
import com.example.kooperatywalubelska.viewmodels.ProductViewModelFactory;
import com.example.kooperatywalubelska.viewmodels.UserViewModelFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Singleton
    @Provides
    Gson providesGson() {
        return new GsonBuilder().create();
    }

    private static String BASE_URL = "http://kooperatywa.cba.pl/";

    @Singleton
    @Provides
    Retrofit providesRetrofit(Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();
    }

    @Singleton
    @Provides
    Webservice providesWebservice(Retrofit retrofit) {
        return retrofit.create(Webservice.class);
    }

    @Provides
    @Singleton
    UserDao providesUserDao(UserDatabase userDatabase) {
        return userDatabase.userDao();
    }

    @Provides
    @Singleton
    ProductDao providesProductDao(UserDatabase userDatabase) {
        return userDatabase.productDao();
    }

    @Provides
    @Singleton
    OrderDao providesOrderDao(UserDatabase userDatabase) {
        return userDatabase.orderDao();
    }

    @Provides
    @Singleton
    OrderDetailDao providesOrderDatailDao(UserDatabase userDatabase) {
        return userDatabase.orderDetailDao();
    }

    @Provides
    Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @Singleton
    @Provides
    UserDatabase provideUserDatabase(Application application) {
        return Room.databaseBuilder(application, UserDatabase.class, "UserDatabase.db").build();
    }

    @Singleton
    @Provides
    UserViewModelFactory provideUserViewModelFactory(UserRepository userRepository) {
        return new UserViewModelFactory(userRepository);
    }

    @Singleton
    @Provides
    ProductViewModelFactory provideProductViewModelFactory(ProductRepository productRepository) {
        return new ProductViewModelFactory(productRepository);
    }

    @Singleton
    @Provides
    OrderDetailViewModelFactory provideOrderDetailViewModelFactory(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
        return new OrderDetailViewModelFactory(orderRepository, orderDetailRepository);
    }

}
