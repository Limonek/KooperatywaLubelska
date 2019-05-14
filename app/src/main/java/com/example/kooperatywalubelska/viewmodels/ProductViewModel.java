package com.example.kooperatywalubelska.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.kooperatywalubelska.database.Product;
import com.example.kooperatywalubelska.database.ProductRepository;

import java.util.List;

import javax.inject.Inject;

public class ProductViewModel extends ViewModel {
    private ProductRepository productRepository;
    private LiveData<Product> product;
    private LiveData<List<Product>> allProductsList;
    private LiveData<List<Product>> notOrderedProductsList;

    public LiveData<Product> getProduct() {
        return product;
    }

    public LiveData<List<Product>> getAllProductsList() {
        return allProductsList;
    }

    public LiveData<List<Product>> getNotOrderedProductsList() {
        return notOrderedProductsList;
    }

    public void initNotOrderedProductsList(){
        if (notOrderedProductsList == null) {
            notOrderedProductsList = productRepository.getNotOrderedProductsList();
        }
    }

    public void initOrRefreshProductsList() {
        if (allProductsList == null) {
            allProductsList = productRepository.getAllEntities();
        }else{
            productRepository.refreshAllEntities();
        }
    }

    public void initProduct(String productId) {
        if (this.product != null) {
            Product product = this.product.getValue();
            if (product != null && Integer.toString(product.getId()).equals(productId)) {
                return;
            }
        }
        product = productRepository.getEntity(productId);
    }

    @Inject
    public ProductViewModel(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
