package com.example.kooperatywalubelska.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.kooperatywalubelska.database.User;
import com.example.kooperatywalubelska.database.UserRepository;

import java.util.List;

import javax.inject.Inject;

public class UserViewModel  extends ViewModel {
    private UserRepository userRepo;
    private LiveData<User> user;
    private LiveData<List<User>> userList;

    public LiveData<User> getUser() {
        return user;
    }

    public LiveData<List<User>> getUserList() {
        return userList;
    }

    public void initOrRefreshUsersList() {
        if (userList == null) {
            userList = userRepo.getAllEntities();
        }else{
            userRepo.refreshAllEntities();
        }
    }

    public void initUser(String userId) {
        if (this.user != null) {
            User user = this.user.getValue();
            if (user != null && Integer.toString(user.getId()).equals(userId)) {
                return;
            }
        }
        user = userRepo.getEntity(userId);
    }

    @Inject
    public UserViewModel(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
}
