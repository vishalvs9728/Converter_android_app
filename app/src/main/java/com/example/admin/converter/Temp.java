package com.example.admin.converter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Temp extends AppCompatActivity implements View.OnClickListener {
    ArrayAdapter<String> mAdap1, mAdap;
    Spinner spn01, spn02;
    EditText edt1;
    Button btn1;
    TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        edt1 = (EditText) findViewById(R.id.et1);
        btn1 = (Button) findViewById(R.id.b2);
        tv1 = (TextView) findViewById(R.id.txt1);
        spn01 = (Spinner) findViewById(R.id.spinner1);
        String[] spin01 = {"Select Temperature", "Celsius", "Fahrenheit", "Kelvin"};
        mAdap = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spin01);
        mAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn01.setAdapter(mAdap);
        spn02 = (Spinner) findViewById(R.id.spinner02);
        String[] spin02 = {"Select Temperature", "Celsius", "Fahrenheit", "Kelvin"};
        mAdap1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spin02);
        mAdap1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn02.setAdapter(mAdap1);
        btn1.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_temp, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.ex) {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.b2:
                //Toast.makeText(Temp.this, "Working", Toast.LENGTH_SHORT).show();
                String a = spn01.getSelectedItem().toString();
                String b = spn02.getSelectedItem().toString();
                if (edt1.getText().toString().length() == 0) {
                    Toast.makeText(Temp.this, "Enter a value", Toast.LENGTH_SHORT).show();
                } else {
                    double value = Double.valueOf(edt1.getText().toString());


                    if (a == "Celsius" && b == "Fahrenheit") {
                        // value = (9*value)/5+32;
                        value = ((9 * value) / 5) + 32;
                        //  vo=String.valueOf(value);
                        tv1.setText(String.format("%.2f", value)+ " Degree F");

                        Toast.makeText(Temp.this, "Converted", Toast.LENGTH_SHORT).show();
                    } else if (a == "Fahrenheit" && b == "Celsius") {
                        value = ((value - 32) * 5) / 9;
                        // vo=String.valueOf(value);
                        tv1.setText(String.format("%.2f", value) + " Degree C");

                        Toast.makeText(Temp.this, "Converted", Toast.LENGTH_SHORT).show();

                    } else if (a == "Kelvin" && b == "Celsius") {
                        value = value - 273;
                        // vo=String.valueOf(value);
                        tv1.setText(String.format("%.2f", value) + " Degree C");

                        Toast.makeText(Temp.this, "Converted", Toast.LENGTH_SHORT).show();

                    } else if (a == "Fahrenheit" && b == "Kelvin") {
                        value = (((value - 32) * 5) / 9) + 273;
                        // vo=String.valueOf(value);
                        tv1.setText(String.format("%.2f", value) + " K");

                        Toast.makeText(Temp.this, "Converted", Toast.LENGTH_SHORT).show();

                    } else if (a == "Celsius" && b == "Kelvin") {
                        // value = (9*value)/5+32;
                        value += 273;
                        //  vo=String.valueOf(value);
                        tv1.setText(String.format("%.2f", value)+ " K");
                        Toast.makeText(Temp.this, "Converted", Toast.LENGTH_SHORT).show();
                    } else if (a == "Kelvin" && b == "Fahrenheit") {
                        // value = (9*value)/5+32;
                        value = (9 * (value - 273) / 5) + 32;
                        //  vo=String.valueOf(value);
                        tv1.setText(String.format("%.2f", value)+ " Degree F");
                        Toast.makeText(Temp.this, "Converted", Toast.LENGTH_SHORT).show();
                    }
                    else if (a==b && (a!="Select Temperature"|| b!="Select Temperature"))
                    {
                        Toast.makeText(Temp.this, "Both Units are same", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(Temp.this, "Select Temperature", Toast.LENGTH_LONG).show();
                    }
                }

        }

    }
}

