package com.example.lab_mobil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class lab5_activity extends AppCompatActivity {
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5_activity);

        Intent intent = getIntent();
        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            String str = intent.getStringExtra(Intent.EXTRA_TEXT);
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }

    }

    public void brouserClick(View view) {
        //Uri address = Uri.parse("http://developer.alexanderklimov.ru");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
        Intent chosenIntent = Intent.createChooser(intent, "Заголовок в диалоговом окне");
        startActivity(chosenIntent);
    }


    public void asd(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "messageText");
        Intent chosenIntent = Intent.createChooser(intent, "Заголовок в диалоговом окне");
        startActivity(chosenIntent);
    }

}