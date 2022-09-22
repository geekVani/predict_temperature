package com.example.cricketchirps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText et_number;
    Button btn_temp;
    TextView tv_result;
    DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_number = findViewById(R.id.et_number);
        btn_temp = findViewById(R.id.btn_temp);
        tv_result = findViewById(R.id.tv_result);

        tv_result.setVisibility(View.GONE);

        formatter = new DecimalFormat("#0.00");

        btn_temp.setOnClickListener(view -> {

            if(et_number.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this, "Enter no. of chirps...", Toast.LENGTH_SHORT).show();
            }
            else {
                int chirp = Integer.parseInt(et_number.getText().toString().trim());
                double celsius = (chirp / 3.0) + 4;
                String value = "The approximate temperature in your surrounding is: " + formatter.format(celsius) +" degree celsius.";
                tv_result.setText(value);
                tv_result.setVisibility(View.VISIBLE);

            }
        });
    }
}