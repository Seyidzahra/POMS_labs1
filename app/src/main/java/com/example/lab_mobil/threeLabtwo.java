package com.example.lab_mobil;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class threeLabtwo extends Fragment {
    EditText editText,editText1 ;
    TextView tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_three_labtwo, container, false);

        Button bt = view.findViewById(R.id.okey);
        editText = view.findViewById(R.id.name);
        editText1 = view.findViewById(R.id.surname);
        tv = view.findViewById(R.id.textView2);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editText.getText().toString().length() == 0) {
                    Toast.makeText(view.getContext(), "Введите Имя", Toast.LENGTH_LONG).show();
                    return;
                }

                if (editText1.getText().toString().length() == 0) {
                    Toast.makeText(view.getContext(), "Введите фамилию", Toast.LENGTH_LONG).show();
                    return;
                }
                tv.append(editText.getText().toString() + " " + editText1.getText().toString());
            }
        });

        return view;
    }
}