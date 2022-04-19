package com.example.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ViewModelOut extends AndroidViewModel {

    public ViewModelOut(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getMessage() {
        return Repository.getInstance().getMessage();
    }
}
