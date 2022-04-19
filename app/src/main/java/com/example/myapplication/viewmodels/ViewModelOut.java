package com.example.myapplication.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.Repository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ViewModelOut extends AndroidViewModel {
    private final Repository repository;

    @Inject
    public ViewModelOut(@NonNull Application application, Repository repository) {
        super(application);
        this.repository=repository;
    }
    public LiveData<String> getMessage() {
        return repository.getMessage();
    }
}
