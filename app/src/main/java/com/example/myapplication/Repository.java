package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class Repository {
    private static Repository instance;

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    private MutableLiveData<String> message;

    private Repository() {
        message = new MutableLiveData<>();
        message.postValue("");
        new Thread(() -> {
            while (true) {
                message.postValue(message.getValue()+"1");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void setMessage(String message) {
        this.message.postValue(message);
    }

    public LiveData<String> getMessage() {
        return message;
    }
}
