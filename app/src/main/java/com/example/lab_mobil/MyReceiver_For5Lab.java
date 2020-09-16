package com.example.lab_mobil;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MyReceiver_For5Lab extends BroadcastReceiver {

    Application app;
    public MyReceiver_For5Lab(Application app) {
        this.app = app;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String STR = intent.getStringExtra("STR");
        Toast.makeText(context, STR, Toast.LENGTH_SHORT).show();

        ViewModelFile  viewModelFile = new ViewModelFile(app);
        viewModelFile.writeFile(STR);
    }




}
