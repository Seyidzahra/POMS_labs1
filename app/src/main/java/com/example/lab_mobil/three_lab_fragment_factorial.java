package com.example.lab_mobil;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class three_lab_fragment_factorial extends Fragment {
    EditText num;
    static int calculateFactorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_three_lab, container, false);

        Button bt = view.findViewById(R.id.factorial);
        num = view.findViewById(R.id.editTextNumber);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (num.getText().toString().length() == 0 || num.getText().toString().length() >= 2) {
                    Toast.makeText(view.getContext(), "Введите число, меньше 10", Toast.LENGTH_LONG).show();
                    return;
                }
                int number = Integer.parseInt(num.getText().toString());
                int n = calculateFactorial(number);
                Toast.makeText(view.getContext(), String.valueOf(n), Toast.LENGTH_LONG).show();
            }
        });

     /*   Button op_activ = view.findViewById(R.id.button_open_activity);
        op_activ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), Activity_for_fragm1.class);
                startActivity(intent);
            }
        });
*/

        return view;



    }
}