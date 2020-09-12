package com.example.lab_mobil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class threelab_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dva_fragmenta);
    }

    public void openActiv1(View view) {
        Intent intent = new Intent(this, Activity_for_fragm1.class);
        startActivity(intent);

    }

    public void openActiv2(View view) {
        Intent intent = new Intent(this, Activity_for_fragm2.class);
        startActivity(intent);
    }
}