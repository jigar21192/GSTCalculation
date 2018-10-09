package com.example.a.gstcalculation;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class SacCode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sac_code);
        Toolbar toolbar=(Toolbar)findViewById(R.id.sacToolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setSubtitle("Item Code");
            ab.setTitle("sac code");
        }
        JSONArray jsonArray=getData("sac.json");
        ArrayList<JSONObject> listitem=getArrayData(jsonArray);
        ListView listv=(ListView)findViewById(R.id.listSac);
        ListSacAdapter adapter=new ListSacAdapter(this,R.layout.listsac,listitem);
        listv.setAdapter(adapter);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    private JSONArray getData(String filename) {
        JSONArray jsonArray=null;
        try {
            InputStream is=getResources().getAssets().open(filename);
            int size=is.available();
            byte[] data=new byte[size];
            is.read(data);
            is.close();
            String json=new String(data ,"UTF-8");
            jsonArray =new JSONArray(json);
        }catch (IOException e){
            e.printStackTrace();
        }catch (JSONException je){
            je.printStackTrace();
        }
        return jsonArray;
    }
    private ArrayList<JSONObject> getArrayData(JSONArray jsonArray) {
        ArrayList<JSONObject> arrayList=new ArrayList<JSONObject>();
        try {
            if(jsonArray !=null){
                for (int i = 0; i < jsonArray.length(); i++) {
                    arrayList.add(jsonArray.getJSONObject(i));
                }
            }
        }catch (JSONException je){
            je.printStackTrace();
        }
        return arrayList;
    }
}
