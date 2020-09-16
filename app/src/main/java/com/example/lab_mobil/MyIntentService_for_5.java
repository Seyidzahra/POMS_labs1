package com.example.lab_mobil;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MyIntentService_for_5 extends IntentService {

    public MyIntentService_for_5() {
        super("MyIntentService_for_5");
    }
int schotchik = 0;

    public int YourFunc(int num2) {
        for (int i=2;i<num2;i++){
            if(checkSimple(i))
                schotchik++;
        }
        return schotchik;
    }

    public static boolean checkSimple(int i){
        if (i<=1)
            return false;
        else if (i <=3)
            return true;
        else if (i%2==0 || i %3 ==0)
            return false;
        int n = 5;
        while (n*n <=i){
            if (i % n ==0 || i % (n+2) == 0)
                return false;
            n=n+6;
        }
        return true;
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        int num2 = intent.getIntExtra("num2",0);

        int count = YourFunc(num2);
        int count2 = YourFunc(num2);
        int count3 = YourFunc(num2);

        Intent i = new Intent();
        i.setAction("AA");
        i.addCategory(Intent.CATEGORY_DEFAULT);
        i.putExtra("STR", "Количество простых чисел до "+ String.valueOf(num2) + " = "+ String.valueOf(count)+ "\n");
        sendBroadcast(i);


    }

}
