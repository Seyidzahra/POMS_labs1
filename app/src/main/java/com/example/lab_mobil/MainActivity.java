package com.example.lab_mobil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    TextView tvContextMenu;
    private ViewModel viewModel;
    private static SharedPreferences sharedPref;
    public static final String FONT_SIZE = "FONT_SIZE";
    int sizeFont, translatedProgress;
    TextView tv_text;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContextMenu = findViewById(R.id.context_menu);
        registerForContextMenu(tvContextMenu);

        tv_text = findViewById(R.id.tv_text);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);

        loadSizeFont();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            case R.id.context_menu:
                menu.add(0, 10, 0, "Открыть 4 лаб");
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 10:
                Intent intent = new Intent(this, lab4_activity_spisok.class);
                startActivity(intent);
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void click(View view) {
        EditText editText = findViewById(R.id.name);
        EditText editText1 = findViewById(R.id.surname);
        if (editText.getText().toString().length() == 0) {
            Toast.makeText(this, R.string.noname, Toast.LENGTH_LONG).show();
            return;
        }

        if (editText1.getText().toString().length() == 0) {
            Toast.makeText(this, R.string.nosurname, Toast.LENGTH_LONG).show();
            return;
        }
        TextView tv = findViewById(R.id.textView2);
        tv.setText(R.string.hello);
        tv.append(editText.getText().toString() + " " + editText1.getText().toString());

       //заполнение
        User user = new User(editText.getText().toString(), editText1.getText().toString(),
                editText.getText().toString() + " " + editText1.getText().toString());
        viewModel = new ViewModel(this);
        viewModel.insertUser(user);
    }

    public void lab(View view) {
        Intent intent = new Intent(this, threelab_activity.class);
        startActivity(intent);

    }

    public void lab5(View view) {
        Intent intent = new Intent(this, lab5_activity.class);
        startActivity(intent);
    }
    public void onClick_lab8(View view) {
        Intent intent = new Intent(this, Activity_for_8_lab.class);
        startActivity(intent);
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        translatedProgress = i + 12;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast.makeText(this,"Раземр текста = " + String.valueOf(translatedProgress), Toast.LENGTH_SHORT).show();
        sizeFont = translatedProgress;
        saveSizeFont();
        tv_text.setTextSize(sizeFont);
    }

    void saveSizeFont() {
        sharedPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sharedPref.edit();
        ed.putInt(FONT_SIZE, sizeFont);
        ed.apply();
    }

    void loadSizeFont() {
        sharedPref = getPreferences(MODE_PRIVATE);
        int size = sharedPref.getInt(FONT_SIZE, 12);
       // Toast.makeText(this, "Раземр текста = " + String.valueOf(size), Toast.LENGTH_SHORT).show();
        tv_text.setTextSize(size);
        seekBar.setProgress(size-12);
    }
}