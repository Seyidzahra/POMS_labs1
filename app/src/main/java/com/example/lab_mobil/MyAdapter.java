package com.example.lab_mobil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.DataHolder> {
    private List<User> list;

    //конструктор
    public MyAdapter(List<User> users) {
        list = users;
    }

    //создание 1 строки списка
    @NonNull
    @Override
    public MyAdapter.DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new DataHolder(view);
    }

    //заполнение строки списка
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.DataHolder holder, int position) {
        holder.zapolneniye(list.get(position));
    }

    //количество строк
    @Override
    public int getItemCount() {
        return list.size();
    }

    //класс работа с одним элементом списка
    class DataHolder extends RecyclerView.ViewHolder {
        private TextView name, surname, name_sur;

        public DataHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            surname = itemView.findViewById(R.id.surname);
            name_sur = itemView.findViewById(R.id.name_sur);
        }

        public void zapolneniye(User user) {
            name.setText(user.name);
            surname.setText(user.surname);
            name_sur.setText(user.nam_sur);
        }
    }
}
