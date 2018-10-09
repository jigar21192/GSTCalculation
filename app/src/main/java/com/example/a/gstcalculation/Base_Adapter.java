package com.example.a.gstcalculation;

import android.content.Context;
import android.content.Intent;
import android.support.v4.media.session.IMediaControllerCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by a on 04/13/2018.
 */

public class Base_Adapter extends BaseAdapter {
    List<Data_model> data_models;
    Context context;

    public Base_Adapter(Context context, List<Data_model> data_models) {
        this.data_models = data_models;
        this.context = context;
        inflater=LayoutInflater.from(context);
        d=new Database(context);

    }
    LayoutInflater inflater;
    Database d;

    @Override
    public int getCount() {
        return data_models.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        view=inflater.inflate(R.layout.data_item,null);
        TextView t1=(TextView)view.findViewById(R.id.getinitiateamount);
        TextView t2=(TextView)view.findViewById(R.id.getgstrate);
        TextView t3=(TextView)view.findViewById(R.id.getnetprice);
        TextView t4=(TextView)view.findViewById(R.id.getgsttotal);
        TextView t5=(TextView)view.findViewById(R.id.getamounttotal);
        ImageView iv=(ImageView)view.findViewById(R.id.ivDel);

        Data_model dm=data_models.get(position);
        t1.setText(dm.getInitamount());
        t2.setText(dm.getGstamount());
        t3.setText(dm.getNetamount());
        t4.setText(dm.getTotalgst());
        t5.setText(dm.getTotalAmount());

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.deletdata(data_models.get(position).getId());

                Intent in=new Intent(context,History.class);

                context.startActivity(in);

                Toast.makeText(context,"Data Deleted",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
