package com.example.myapplication;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

@Database(
        entities = {ModelCard.class},
        version = 1,
        exportSchema = false
)
public abstract class LocalDataBase extends RoomDatabase {
    protected abstract DaoCard daoCard();

    static LocalDataBase init(Context context) {
        return Room.databaseBuilder(
                context.getApplicationContext(),
                LocalDataBase.class,
                "test_database"
        )
                .fallbackToDestructiveMigration()
                .build();
    }

    public void insertCard(ModelCard modelCard) {
        new Thread(() -> {
            daoCard().insertCard(modelCard);
        }).start();
    }

    public void insertAllCards(List<ModelCard> list) {
        new Thread(() -> {
            daoCard().deleteAllCards();
            for (ModelCard card: list ) {
                daoCard().insertCard(card);
            }
        }).start();
    }

    public LiveData<List<ModelCard>> getAllCards() {
        return daoCard().getAllCards();
    }
}
