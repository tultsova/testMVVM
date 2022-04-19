package com.example.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class ViewModelIn extends AndroidViewModel {

    public ViewModelIn(@NonNull Application application) {
        super(application);
    }

    public void setMessage(String message) {
        Repository.getInstance().setMessage(message);
    }

}
