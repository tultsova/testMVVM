package com.example.myapplication.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.ModelCard;
import com.example.myapplication.Repository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ViewModelRecycler extends AndroidViewModel {
    private final Repository repository;

    @Inject
    public ViewModelRecycler(@NonNull Application application, Repository repository) {
        super(application);
        this.repository=repository;
    }

    public LiveData<List<ModelCard>> getAllCards() {
        return repository.getAllCards();
    }
}
