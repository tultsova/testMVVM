package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "card_table")
public class ModelCard {
    @PrimaryKey
    @NonNull
    private Long id;
    private String name;
    private String lastname;
    private int age;

    public ModelCard(String name, String lastname, int age) {
        this.id = UUID.randomUUID().getMostSignificantBits();
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
