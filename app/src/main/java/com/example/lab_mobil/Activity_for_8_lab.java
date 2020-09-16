package com.example.lab_mobil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Activity_for_8_lab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_8_lab);
    }


    public void onClick_povorot(View view) {
        ImageView img = findViewById(R.id.imageView);
        Animation rotation = AnimationUtils.loadAnimation(this, R.anim.povorot);
        img.startAnimation(rotation);

    }
    public void onClick_translasiya(View view) {
        ImageView img = findViewById(R.id.imageView);
        Animation tr = AnimationUtils.loadAnimation(this, R.anim.translasiya);
        img.startAnimation(tr);
    }
    public void onClick_alpha(View view) {
        ImageView img = findViewById(R.id.imageView);
        Animation al = AnimationUtils.loadAnimation(this, R.anim.alpha);
        img.startAnimation(al);
    }
    public void onClick_mashtab(View view) {
        ImageView img = findViewById(R.id.imageView);
        Animation mash = AnimationUtils.loadAnimation(this, R.anim.mashtab);
        img.startAnimation(mash);
    }





}