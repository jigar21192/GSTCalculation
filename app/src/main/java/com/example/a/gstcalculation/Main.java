package com.example.a.gstcalculation;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {
    private DrawerLayout mDraw;
    private Toolbar toolbar;
    private EditText edtIntAmt, edtGstAmt, edtNetAmt, edtGst, edtTotalAmt;
    private Button btnCalculate, btnSave;
    private TextView txtSgst, txtCgst, txtsgst, txtcgst;
    private RadioGroup rg;
    private ImageView image;
    Database db;
    private LinearLayout linearLayout;
    private RadioButton rbAdd, rbRemove;
    double a, b, c, d;
    int gst;
    private NavigationView navigationView;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDraw.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        edtIntAmt = (EditText) findViewById(R.id.edt_iAmt);
        edtGstAmt = (EditText) findViewById(R.id.edt_Rate);
        edtGst = (EditText) findViewById(R.id.edt_GstAmt);
        edtTotalAmt = (EditText) findViewById(R.id.edt_totalAmt);
        edtNetAmt = (EditText) findViewById(R.id.edt_NetAmt);
        btnSave = (Button) findViewById(R.id.btnSave);
        rg = (RadioGroup) findViewById(R.id.rgGst);
        rbAdd = (RadioButton) findViewById(R.id.rgAddGst);
        rbRemove = (RadioButton) findViewById(R.id.rgremoveGst);
        btnCalculate = (Button) findViewById(R.id.btn_CalculateGst);
        txtCgst = (TextView) findViewById(R.id.txt_cgst1);
        txtcgst = (TextView) findViewById(R.id.txt_cgst2);
        txtSgst = (TextView) findViewById(R.id.txt_sgst1);
        txtsgst = (TextView) findViewById(R.id.txt_sgst2);
        linearLayout = (LinearLayout) findViewById(R.id.linearlayout01);
        db = new Database(Main.this);
        initButton();
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_dehaze_black_24dp);

        mDraw = (DrawerLayout) findViewById(R.id.main);
        navigationView = (NavigationView) findViewById(R.id.navView);
        nav();
        ButtonSave();
    }

    public void nav() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.section:
                        Intent intent = new Intent(Main.this, Section.class);
                        startActivity(intent);
                        break;
                    case R.id.incomeTax:
                        Intent i = new Intent(Main.this, IncomeTax.class);
                        startActivity(i);
                        break;
                    case R.id.history:
                        Intent intent1 = new Intent(Main.this, History.class);
                        startActivity(intent1);
                        break;
                    case R.id.itemcode:
                        Intent intent2=new Intent(Main.this,ItemCode.class);
                        startActivity(intent2);
                }
                item.setChecked(true);
                mDraw.closeDrawers();
                return true;
            }
        });
    }

    private void ButtonSave() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Initamount = edtIntAmt.getText().toString().trim();
                String Gstamount = edtGstAmt.getText().toString().trim();
                String Totalgst = edtGst.getText().toString().trim();
                String TotalAmount = edtTotalAmt.getText().toString().trim();
                String Netamount = edtNetAmt.getText().toString().trim();
                String CGSTper = txtCgst.getText().toString().trim();
                String CGSTrs = txtcgst.getText().toString().trim();
                String SGSTper = txtSgst.getText().toString().trim();
                String SGSTrs = txtsgst.getText().toString().trim();

                Data_model dm = new Data_model();
                dm.setInitamount(Initamount);
                dm.setGstamount(Gstamount);
                dm.setTotalAmount(TotalAmount);
                dm.setTotalgst(Totalgst);
                dm.setNetamount(Netamount);
                dm.setCGSTper(CGSTper);
                dm.setCGSTrs(CGSTrs);
                dm.setSGSTper(SGSTper);
                dm.setSGSTrs(SGSTrs);

                db.insertdata(dm);
            }
        });
    }

    private void initButton() {

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isvalid()) {
                    a = Double.parseDouble(edtIntAmt.getText().toString());
                    b = Double.parseDouble(edtGstAmt.getText().toString());
                    gst = rg.getCheckedRadioButtonId();
                }
                if (gst == R.id.rgAddGst) {
                    c = (a * b) / 100;
                    d = c + a;
                    edtNetAmt.setText(Double.toString(a));
                    edtGst.setText(Double.toString(c));
                    edtTotalAmt.setText(Double.toString(d));
                    txtCgst.setText(Double.toString(b / 2));
                    txtcgst.setText(Double.toString(c / 2));
                    txtSgst.setText(Double.toString(b / 2));
                    txtsgst.setText(Double.toString(c / 2));
                } else {
                    c = a - (a * (100 / (100 + b)));
                    d = a - c;
                    edtNetAmt.setText(Double.toString(a));
                    edtGst.setText(Double.toString(c));
                    edtTotalAmt.setText(Double.toString(d));
                    txtCgst.setText(Double.toString(b / 2));
                    txtcgst.setText(Double.toString(c / 2));
                    txtSgst.setText(Double.toString(b / 2));
                    txtsgst.setText(Double.toString(c / 2));
                }
                /* a = Double.parseDouble(edtIntAmt.getText().toString());
                b = Double.parseDouble(edtGstAmt.getText().toString());
                c = (a * b) / 100;
                d = c + a;
                edtNetAmt.setText(Double.toString(a));
                edtGst.setText(Double.toString(c));
                edtTotalAmt.setText(Double.toString(d));*/
            }
        });
    }

    @SuppressLint("ResourceType")
    public boolean isvalid() {
        if (edtIntAmt.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(this, "please enter amount", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (edtGstAmt.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(this, "please enter amount", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (rg.getCheckedRadioButtonId() <=0) {
            Toast.makeText(this, "Please select option", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}