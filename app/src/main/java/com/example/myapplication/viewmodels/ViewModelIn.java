package com.example.myapplication.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.myapplication.Repository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ViewModelIn extends AndroidViewModel {
    private final Repository repository;

    @Inject
    public ViewModelIn(@NonNull Application application, Repository repository) {
        super(application);
        this.repository=repository;
    }

    public void setMessage(String message) {
        repository.setMessage(message);
    }

}
