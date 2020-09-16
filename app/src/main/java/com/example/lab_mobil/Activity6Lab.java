package com.example.lab_mobil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Activity6Lab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity6_lab);
    }


    public void onClickLoadFromFile (View view){
    // чтение из файла

        ViewModelFile viewModelFile = new ViewModelFile(getApplication());
        String str = viewModelFile.readFile();

        TextView tv = findViewById(R.id.textView4);
        tv.setText(str);

    }
}