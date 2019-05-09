package com.example.kooperatywalubelska.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.kooperatywalubelska.database.ProductRepository;

import javax.inject.Inject;

public class ProductViewModelFactory implements ViewModelProvider.Factory {
    private ProductRepository productRepo;

    @Inject
    public ProductViewModelFactory(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ProductViewModel(productRepo);
    }
}
