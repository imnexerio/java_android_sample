package com.example.implicit_call;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
Button btnDial, btnMsg, btnEmail, btnShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnDial = findViewById(R.id.btnDial);
        btnMsg = findViewById(R.id.btnMsg);
        btnEmail = findViewById(R.id.btnEmail);
        btnShare = findViewById(R.id.btnShare);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel:+919876543222"));
                startActivity(iDial);
            }
        });
        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMsg = new Intent(Intent.ACTION_SENDTO);
                iMsg.setData(Uri.parse("smsto:+919876543222"));
                iMsg.putExtra("sms_body", "Hello, How are you?");
                startActivity(iMsg);
            }
        });
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEmail = new Intent(Intent.ACTION_SENDTO);
                iEmail.setData(Uri.parse("mailto:fghj@gmail.com"));
                iEmail.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                iEmail.putExtra(Intent.EXTRA_TEXT, "Hello, How are you?");
                startActivity(iEmail);
            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                iShare.putExtra(Intent.EXTRA_TEXT, "Hello, How are you?");
                startActivity(Intent.createChooser(iShare, "Share via"));
            }
        });

    }
}