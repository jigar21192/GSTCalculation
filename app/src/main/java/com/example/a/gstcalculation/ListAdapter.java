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

/**
 * Created by a on 04/18/2018.
 */

public class ListAdapter extends ArrayAdapter<JSONObject>{
    int vg;
    ArrayList<JSONObject> list;
    Context context;
    public ListAdapter(Context context,int vg,ArrayList<JSONObject> list) {
        super(context,vg,list);
        this.context=context;
        this.vg=vg;
        this.list=list;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(vg, parent, false);
        TextView txtHsnCode=(TextView)itemView.findViewById(R.id.txthcno);
        TextView txtHsnfCode=(TextView)itemView.findViewById(R.id.txthcfourno);
        TextView txtDescription=(TextView)itemView.findViewById(R.id.txtDesc);
        try {
            txtHsnCode.setText(list.get(position).getString("HSN Code No."));
            txtHsnfCode.setText(list.get(position).getString("HSN Code 4 Digit"));
            txtDescription.setText(list.get(position).getString("Name of Commodity"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return itemView;
    }
}
