package com.example.a.gstcalculation;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        new Handler().postDelayed(new Runnable() {
            //using handler with postdelayed called runnable run method
            @Override
            public void run() {
                Intent i=new Intent(Loading.this,Main.class);
                //start the activity
                startActivity(i);
                //close the activity
                finish();
            }
        },1000);

    }
}
