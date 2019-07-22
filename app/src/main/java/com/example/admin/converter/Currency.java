package com.example.admin.converter;

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
import android.view.View.OnClickListener;
import android.widget.Toast;


public class Currency extends AppCompatActivity implements OnClickListener {
    ArrayAdapter<String> mAdap;
    Spinner spn1, spn2;
    EditText edt;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        edt = (EditText) findViewById(R.id.et);
        btn = (Button) findViewById(R.id.b1);
        tv = (TextView) findViewById(R.id.txt);
        spn1 = (Spinner) findViewById(R.id.spinner);
        String[] spin1 = {"Select Currency", "Dollar", "Indian Rupees"};
        mAdap = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spin1);
        mAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn1.setAdapter(mAdap);
        spn2 = (Spinner) findViewById(R.id.spinner2);

        String[] spin2 = {"Select Currency", "Dollar", "Indian Rupees"};
        mAdap = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spin2);
        mAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn2.setAdapter(mAdap);
        btn.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_currency, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:

                String s = spn1.getSelectedItem().toString();
                String t = spn2.getSelectedItem().toString();
                if (edt.getText().toString().length() == 0) {
                    Toast.makeText(Currency.this, "Enter a value", Toast.LENGTH_SHORT).show();
                } else {

                    double value = Double.valueOf(edt.getText().toString());

                    if (s == "Dollar" && t == "Indian Rupees") {
                        value = value * (69.52);
                        //  vo=String.valueOf(value);
                        tv.setText(String.format("Rs " + "%.2f", value));
                        Toast.makeText(Currency.this, "Converted", Toast.LENGTH_SHORT).show();
                    } else if (s == "Indian Rupees" && t == "Dollar") {
                        value = value / 69.52;
                        // vo=String.valueOf(value);
                        tv.setText(String.format("%.2f", value) + " $");

                        Toast.makeText(Currency.this, "Converted", Toast.LENGTH_SHORT).show();

                    }
                    else if (s==t&&(s!="Select Currency"|| t!="Select Currency"))
                    {
                        Toast.makeText(Currency.this, "Both currency are same", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(Currency.this, "Select Currency", Toast.LENGTH_SHORT).show();
                    }
                }


        }

    }

}