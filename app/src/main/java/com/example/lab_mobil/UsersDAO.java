package com.example.lab_mobil;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UsersDAO {
    @Query("SELECT * FROM users")
    List<User> getAll();

    @Insert
    void insertUser(User user);

}
