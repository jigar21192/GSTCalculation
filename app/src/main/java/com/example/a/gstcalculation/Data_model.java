package com.example.a.gstcalculation;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by a on 04/13/2018.
 */

public class Data_model extends AppCompatActivity {
    int id;
    String Initamount;
    String Gstamount;
    String Totalgst;
    String TotalAmount;
    String Netamount;
    String CGSTper;
    String CGSTrs;
    String SGSTper;
    String SGSTrs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInitamount() {
        return Initamount;
    }

    public void setInitamount(String initamount) {
        Initamount = initamount;
    }

    public String getGstamount() {
        return Gstamount;
    }

    public void setGstamount(String gstamount) {
        Gstamount = gstamount;
    }

    public String getTotalgst() {
        return Totalgst;
    }

    public void setTotalgst(String totalgst) {
        Totalgst = totalgst;
    }

    public String getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        TotalAmount = totalAmount;
    }

    public String getNetamount() {
        return Netamount;
    }

    public void setNetamount(String netamount) {
        Netamount = netamount;
    }

    public String getCGSTper() {
        return CGSTper;
    }

    public void setCGSTper(String CGSTper) {
        this.CGSTper = CGSTper;
    }

    public String getCGSTrs() {
        return CGSTrs;
    }

    public void setCGSTrs(String CGSTrs) {
        this.CGSTrs = CGSTrs;
    }

    public String getSGSTper() {
        return SGSTper;
    }

    public void setSGSTper(String SGSTper) {
        this.SGSTper = SGSTper;
    }

    public String getSGSTrs() {
        return SGSTrs;
    }

    public void setSGSTrs(String SGSTrs) {
        this.SGSTrs = SGSTrs;
    }
}
