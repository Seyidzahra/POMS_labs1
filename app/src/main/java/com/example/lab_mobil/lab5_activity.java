package com.example.lab_mobil;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lab5_activity extends AppCompatActivity implements View.OnClickListener {
    private MyReceiver_For5Lab myReceiver_for5Lab;


    TextView tvName;
    Button btnName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5_activity);

        myReceiver_for5Lab = new MyReceiver_For5Lab(getApplication());
        IntentFilter intentFilter = new IntentFilter("AA");
        intentFilter.addCategory(Intent.CATEGORY_DEFAULT);
        registerReceiver(myReceiver_for5Lab, intentFilter);

        Intent intent = getIntent();
        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            String str = intent.getStringExtra(Intent.EXTRA_TEXT);
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }

        tvName = findViewById(R.id.tv_name);
        btnName = findViewById(R.id.button_name);
        btnName.setOnClickListener(this);
    }

    public void brouserClick(View view) {
        //Uri address = Uri.parse("http://developer.alexanderklimov.ru");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
        Intent chosenIntent = Intent.createChooser(intent, "Заголовок в диалоговом окне");
        startActivity(chosenIntent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver_for5Lab);
    }

    public void asd(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "messageText");
        Intent chosenIntent = Intent.createChooser(intent, "Заголовок в диалоговом окне");
        startActivity(chosenIntent);
    }

    public void onClickFor5Lab(View view) {
       Intent intentMyIntentServise = new Intent(this, MyIntentService_for_5.class);
       EditText num2 = findViewById(R.id.editTextNumber5);
// СДЕЛАТЬ ПРОВЕРКИ

       int n2= Integer.parseInt(num2.getText().toString());

       intentMyIntentServise.putExtra("num2", n2);
       startService(intentMyIntentServise);
    }
    public void onClick_for_lab6(View view) {
        Intent intent = new Intent(this, Activity6Lab.class);
        startActivity(intent);

    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent (this, NameActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data ==null) {
        return;
        }
        String name = data.getStringExtra("name");
        tvName.setText("Привет, "+ name + "!");
        
    }
}