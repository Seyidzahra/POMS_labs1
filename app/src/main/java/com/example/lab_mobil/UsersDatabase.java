package com.example.lab_mobil;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UsersDatabase extends RoomDatabase {
    private static UsersDatabase database;
    private static final String DB_NAME = "Users.db";
    private static final Object LOCK = new Object();

    public static UsersDatabase getInstance(Context context){
        synchronized (LOCK) {
            if (database == null) {
                database = Room.databaseBuilder(context, UsersDatabase.class, DB_NAME)
                        .allowMainThreadQueries() 
                        .build();
            }
        }
        return database;
    }

    public abstract UsersDAO usersDao();
}
