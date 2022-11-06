package com.example.group28assignmentapp.database.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.group28assignmentapp.database.User;

import java.util.List;

public class UserViewModel extends ViewModel {
    private final MutableLiveData<List<String>> _listOfUsernames = new MutableLiveData<>();
    public final LiveData<List<String>> listOfUsernames = _listOfUsernames;

    private final MutableLiveData<User> _user = new MutableLiveData<>();
    public final LiveData<User> user = _user;

}
