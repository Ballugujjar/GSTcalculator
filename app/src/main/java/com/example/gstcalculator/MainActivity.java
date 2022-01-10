package com.example.gstcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    TextView GSTvalue,totalprice;
    Button button2;
    Button button;
    EditText editTextNumberDecimal;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculation(View view) {
        EditText editTextNumberDecimal = (EditText) findViewById(R.id.editTextNumberDecimal);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        TextView GSTvalue = (TextView) findViewById(R.id.GSTvalue);
        TextView totalprice = (TextView) findViewById(R.id.totalprice);
        String gst = String.valueOf(spinner.getSelectedItem());
        float price = Float.parseFloat(editTextNumberDecimal.getText().toString());
        int percentage;
        switch (gst) {
            case "5%":
                percentage = 5;
                break;
            case "12%":
                percentage = 12;
                break;
            case "18%":
                percentage = 18;
                break;
            case "28%":
                percentage = 28;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + gst);
        }
        float gsst = price*percentage/100;
        GSTvalue.setText("GST amount = "+ gsst);
        float total = gsst + price;
        totalprice.setText("Total price is "+ total);
    }

    public void Switch(View view) {
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
}