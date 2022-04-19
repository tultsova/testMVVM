package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface DaoCard {
    @Insert
    void insertCard(ModelCard modelCard);
    @Delete
    void deleteCard(ModelCard modelCard);
    @Query("DELETE FROM card_table")
    void deleteAllCards();
    @Transaction
    @Query("SELECT * FROM card_table")
    LiveData<List<ModelCard>> getAllCards();
}
