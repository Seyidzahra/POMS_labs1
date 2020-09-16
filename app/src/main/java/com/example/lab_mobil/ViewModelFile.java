package com.example.lab_mobil;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

public class ViewModelFile {
private Application app;



    public ViewModelFile(Application app) {
        this.app = app;
    }


    // чтение из файла
    public String readFile() {
        StringBuilder strRes = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(app.openFileInput("FILE_NAME")));
            String str = "";
            while ((str = br.readLine()) != null) {
                strRes.append(str).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strRes.toString();
    }



    // запись в файл
    public void writeFile(String str) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    app.openFileOutput("FILE_NAME", Context.MODE_PRIVATE | Context.MODE_APPEND)));
            bw.write(str);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
