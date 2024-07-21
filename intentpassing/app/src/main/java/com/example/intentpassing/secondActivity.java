package com.example.intentpassing;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.jar.Attributes;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        Intent fromAct = getIntent();
        String title = fromAct.getStringExtra("title");
        String studentName = fromAct.getStringExtra("studentNAME");
        int rollNo = fromAct.getIntExtra("roll_no",0);
        TextView txtStudentInfo;

        txtStudentInfo = findViewById(R.id.txtStudentInfo);

        txtStudentInfo.setText("Name: " + studentName + ", Roll No: " + rollNo);
        getSupportActionBar().setTitle(title);

        }
    }
