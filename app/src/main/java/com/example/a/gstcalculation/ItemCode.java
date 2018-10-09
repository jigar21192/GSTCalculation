package com.example.a.gstcalculation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ItemCode extends AppCompatActivity {
    private TextView txtgood,txtservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_code);
        Toolbar toolbar = (Toolbar) findViewById(R.id.itemToolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        txtgood=(TextView)findViewById(R.id.hsnGood);
        txtgood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ItemCode.this,HsnCodeGood.class);
                startActivity(i);
            }
        });
        txtservice=(TextView)findViewById(R.id.hsnService);
        txtservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ItemCode.this,SacCode.class);
                startActivity(i);
            }
        });
    }
}
