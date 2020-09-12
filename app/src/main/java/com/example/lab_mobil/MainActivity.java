package com.example.lab_mobil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tvContextMenu;

    private ArrayList<User> users  = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContextMenu = findViewById(R.id.context_menu);
        registerForContextMenu(tvContextMenu);
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
                intent.putParcelableArrayListExtra("1", users);
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
        User user = new User(editText.getText().toString(), editText1.getText().toString(), editText.getText().toString() + " " + editText1.getText().toString());
        users.add(user);
        Toast.makeText(this, String.valueOf(users.size()), Toast.LENGTH_LONG).show();



    }

    public void lab(View view) {
        Intent intent = new Intent(this, threelab_activity.class);
        startActivity(intent);

    }

    public void lab5(View view) {
        Intent intent = new Intent(this, lab5_activity.class);
        startActivity(intent);
    }
}