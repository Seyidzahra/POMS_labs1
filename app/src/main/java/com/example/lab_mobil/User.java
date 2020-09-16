package com.example.lab_mobil;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

// POJO класс

@Entity(tableName = "Users")
public class User {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name,surname,nam_sur;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNam_sur() {
        return nam_sur;
    }

    public void setNam_sur(String nam_sur) {
        this.nam_sur = nam_sur;
    }

    public User(int id, String name, String surname, String nam_sur) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nam_sur = nam_sur;
    }

    @Ignore
    public User(String name, String surname, String nam_sur) {
        this.name = name;
        this.surname = surname;
        this.nam_sur = nam_sur;
    }
}
