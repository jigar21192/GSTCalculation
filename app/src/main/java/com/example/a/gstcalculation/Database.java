package com.example.a.gstcalculation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 04/13/2018.
 */

public class Database extends SQLiteOpenHelper {
    private static final int db_version = 1;
    private static final String db_name = "gst_db";
    private static final String Table_name = "GST_Detail";
    private static final String Id = "id";
    private static final String I_amount = "i_amount";
    private static final String GST_Rate = "gst_rate";
    private static final String CGSTper = "cgst";
    private static final String SGSTper = "sgst";
    private static final String CGSTrs = "cgstrs";
    private static final String SGSTrs = "sgstrs";
    private static final String NetAmount = "netamount";
    private static final String GST_Amount = "gstamount";
    private static final String Total_Amount = "totalamount";

    public Database(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String st = " CREATE TABLE " + Table_name + " ( " + Id + " INTEGER PRIMARY KEY, " + I_amount + " TEXT, "
                + NetAmount + " TEXT," + GST_Rate + " TEXT, " + CGSTper + " TEXT," + SGSTper + " TEXT," + CGSTrs + " TEXT," + SGSTrs + " TEXT,"
                + GST_Amount + " TEXT," +
                Total_Amount + " TEXT" + ")";
        db.execSQL(st);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_name);
        onCreate(db);
    }

    public int insertdata(Data_model dm) {
        SQLiteDatabase d = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(I_amount, dm.getInitamount());
        values.put(GST_Rate, dm.getGstamount());
        values.put(CGSTper, dm.getCGSTper());
        values.put(SGSTper, dm.getSGSTper());
        values.put(CGSTrs, dm.getCGSTrs());
        values.put(NetAmount, dm.getNetamount());
        values.put(SGSTrs, dm.getSGSTrs());
        values.put(GST_Amount, dm.getTotalgst());
        values.put(Total_Amount, dm.getTotalAmount());
        int i = (int) d.insert(Table_name, null, values);
        Log.e("Row", ">>>" + i);
        d.close();
        return i;
    }

    public List<Data_model> getAllDatabase() {
        List<Data_model> data_models = new ArrayList<Data_model>();
        String selectquiry = "SELECT * FROM " + Table_name;
        SQLiteDatabase d = this.getReadableDatabase();
        Cursor cursor = d.rawQuery(selectquiry, null);

        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    Data_model dm = new Data_model();
                    dm.setId(Integer.parseInt(cursor.getString(0)));
                    dm.setInitamount(cursor.getString(1));
                    dm.setNetamount(cursor.getString(2));
                    dm.setGstamount(cursor.getString(3));
                    dm.setCGSTper(cursor.getString(4));
                    dm.setSGSTper(cursor.getString(5));
                    dm.setCGSTrs(cursor.getString(6));

                    dm.setSGSTrs(cursor.getString(7));
                    dm.setTotalgst(cursor.getString(8));
                    dm.setTotalAmount(cursor.getString(9));

                    data_models.add(dm);
                } while (cursor.moveToNext());

            }
        }

        return data_models;
    }

    public void deletdata(int id) {

        SQLiteDatabase d=this.getWritableDatabase();

        d.delete(Table_name,Id+" = ?",new String[]{String.valueOf(id)});

        d.close();

    }
}
