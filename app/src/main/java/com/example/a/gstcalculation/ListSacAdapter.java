package com.example.a.gstcalculation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 04/19/2018.
 */

public class ListSacAdapter extends ArrayAdapter<JSONObject> {
    int vg;
    ArrayList<JSONObject> list;
    Context context;
    public ListSacAdapter( Context context, int vg, ArrayList<JSONObject> list) {
        super(context,vg,list);
        this.context=context;
        this.vg=vg;
        this.list=list;
    }
    public View getView(int position,View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(vg, parent, false);
        TextView textSac=(TextView)itemView.findViewById(R.id.txtsac);
        TextView textService=(TextView)itemView.findViewById(R.id.txtservice);
        try {
            textSac.setText(list.get(position).getString("SAC"));
            textService.setText(list.get(position).getString("Services"));
        }catch (JSONException e){
            e.printStackTrace();
        }
        return itemView;
    }
}
