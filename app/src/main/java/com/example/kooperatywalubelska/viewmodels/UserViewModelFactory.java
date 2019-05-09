package com.example.kooperatywalubelska.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.kooperatywalubelska.database.UserRepository;

public class UserViewModelFactory  implements ViewModelProvider.Factory {
    private UserRepository userRepo;

    public UserViewModelFactory(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new UserViewModel(userRepo);
    }
}
