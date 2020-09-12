package com.example.lab_mobil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class lab4_activity_spisok extends AppCompatActivity {

    private ArrayList<User> users  = new ArrayList<>();

    RecyclerView rv;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab4_spisok);


        Intent intent = getIntent();
        users = intent.<User>getParcelableArrayListExtra("1");


        rv = findViewById(R.id.RecyclerView);
        //размещение сверху вниз
        rv.setLayoutManager(new LinearLayoutManager(this));


    adapter = new MyAdapter(users);
    adapter.notifyDataSetChanged();
    rv.setAdapter(adapter);
    }
}