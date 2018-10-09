package com.example.a.gstcalculation;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.List;

public class History extends AppCompatActivity {
    ListView lv;
    Database d;
    private DrawerLayout mDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar toolbar = (Toolbar) findViewById(R.id.hToolbar);
        setSupportActionBar(toolbar);
        lv = (ListView) findViewById(R.id.lv);
        d = new Database(History.this);
        List<Data_model> data_models = d.getAllDatabase();
        Base_Adapter base_adapter = new Base_Adapter(History.this, data_models);
        lv.setAdapter(base_adapter);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


}
