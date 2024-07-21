package com.example.bmicalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtWeight, edtHeightft, edtHeightIn;
        Button btnCalcualte;
        TextView txtresult;
        LinearLayout llmain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightft = findViewById(R.id.edtheightfeet);
        edtHeightIn = findViewById(R.id.edtweightinch);
        btnCalcualte=findViewById(R.id.btncalculate);
        txtresult = findViewById(R.id.txtResult);
        llmain = findViewById(R.id.llmain);


        btnCalcualte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt=Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightft.getText().toString());
                int in = Integer.parseInt((edtHeightIn.getText().toString()));

                int totalIn = ft*12 + in;

                double totalCm= totalIn*2.53;

                double totalM = totalCm/100;

                double bmi= wt/(totalM*totalM);
                if(bmi>25){
                    txtresult.setText("You are overweight");
                    llmain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                } else if (bmi<18) {
                    txtresult.setText("Yor are Underweight");
                    llmain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                }
                else {
                    txtresult.setText("you are Healthy");
                    llmain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }
            }
        });

    }
}