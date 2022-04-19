package com.example.myapplication;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Repository {

    private MutableLiveData<String> message;
    private final LocalDataBase dataBase;

    @Inject
    public Repository(Application application) {
        dataBase = LocalDataBase.init(application);

        List<ModelCard> data = new ArrayList<>();
        data.add(new ModelCard("имя", "фамилия", 5));
        data.add(new ModelCard("имя", "фамилия", 5));
        data.add(new ModelCard("имя", "фамилия", 5));
        data.add(new ModelCard("имя", "фамилия", 5));
        data.add(new ModelCard("имя", "фамилия", 5));

        dataBase.insertAllCards(data);

        message = new MutableLiveData<>();
        message.postValue("");
    }

    public void setMessage(String message) {
        this.message.postValue(message);
    }

    public LiveData<String> getMessage() {
        return message;
    }

    public LiveData<List<ModelCard>> getAllCards() {
        return dataBase.getAllCards();
    }
}
