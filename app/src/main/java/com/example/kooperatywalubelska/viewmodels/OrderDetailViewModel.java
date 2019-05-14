package com.example.kooperatywalubelska.viewmodels;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.kooperatywalubelska.database.Order;
import com.example.kooperatywalubelska.database.OrderDetail;
import com.example.kooperatywalubelska.database.OrderDetailRepository;
import com.example.kooperatywalubelska.database.OrderRepository;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class OrderDetailViewModel extends ViewModel {
    private OrderRepository orderRepository;
    private OrderDetailRepository orderDetailRepository;
    private LiveData<Order> order;
    private LiveData<List<OrderDetail>> orderOrderDetailsList;

    public LiveData<Order> getOrder() {
        return order;
    }

    public LiveData<List<OrderDetail>> getOrderOrderDetailsList() {
        return orderOrderDetailsList;
    }

    public void initOrRefreshOrderOrderDetailsList(String orderId) {
        if (orderOrderDetailsList == null) {
            orderOrderDetailsList = orderDetailRepository.getOrderOrderDetails(orderId);
        } else {
            orderDetailRepository.refreshOrderOrderDetails(orderId);
        }
    }

    public void initOrder(Date orderDate, String userId) {
        if (this.order != null) {
            Order order = this.order.getValue();
            if (order != null && order.getDate().equals(orderDate)) {
                return;
            }
        }
        order = orderRepository.getOrder(orderDate, userId);
    }

    @Inject
    public OrderDetailViewModel(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }
}