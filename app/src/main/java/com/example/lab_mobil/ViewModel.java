package com.example.lab_mobil;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel {
    private static UsersDatabase database;
    private List<User> users;

    public ViewModel(Context context) {
        database = UsersDatabase.getInstance(context);
        users = database.usersDao().getAll();
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void insertUser(User user) {
        new InsertTask().execute(user);
    }


    private static class InsertTask extends AsyncTask<User, Void, Void> {
        @Override
        protected Void doInBackground(User... users) {
            if (users != null && users.length >0) {
                database.usersDao().insertUser(users[0]);
            }
            return null;
        }
    }

}
