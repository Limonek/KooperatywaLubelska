package com.example.kooperatywalubelska.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.kooperatywalubelska.database.OrderDetailRepository;
import com.example.kooperatywalubelska.database.OrderRepository;

public class OrderDetailViewModelFactory implements ViewModelProvider.Factory {
    private OrderRepository orderRepo;
    private OrderDetailRepository orderDetailRepository;

    public OrderDetailViewModelFactory(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
        this.orderRepo = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new OrderDetailViewModel(orderRepo, orderDetailRepository);
    }
}
