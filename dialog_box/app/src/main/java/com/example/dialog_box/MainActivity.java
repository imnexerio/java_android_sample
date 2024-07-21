package com.example.dialog_box;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
//        alertDialog.setTitle("terms and conditions");
//        alertDialog.setIcon(R.drawable.baseline_info_24);
//        alertDialog.setMessage("This is a dialog box");
//
//        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Agree", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this, "You clicked on agree", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        alertDialog.show();
//
//        AlertDialog.Builder delDialog = new AlertDialog.Builder(MainActivity.this);
//        delDialog.setTitle("Delete");
//        delDialog.setIcon(R.drawable.baseline_delete_24);
//        delDialog.setMessage("Are you sure you want to delete this?");
//        delDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this, "You clicked on yes", Toast.LENGTH_SHORT).show();
//            }
//        });
//        delDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this, "You clicked on no", Toast.LENGTH_SHORT).show();
//            }
//        });
//        delDialog.show();



    }

//    public void onBackPressed(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Exit");
//        builder.setIcon(R.drawable.baseline_delete_24);
//        builder.setMessage("Are you sure you want to exit?");
//        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                MainActivity.super.onBackPressed();
//            }
//        });
//        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this, "You clicked on no", Toast.LENGTH_SHORT).show();
//                MainActivity.super.onBackPressed();
//            }
//        });
//        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this, "You clicked on cancel", Toast.LENGTH_SHORT).show();
//            }
//        });
//        builder.show();
//    }


    @Override
    public void onBackPressed() {


        AlertDialog.Builder exitDialog = new AlertDialog.Builder(this);

        exitDialog.setTitle("exit");
        exitDialog.setMessage("are you sure ? ");
        exitDialog.setIcon(R.drawable.baseline_exit_to_app_24);

        exitDialog.setPositiveButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"positive", Toast.LENGTH_SHORT).show();
            }
        });
        exitDialog.setNegativeButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.super.onBackPressed();
//                Toast.makeText(MainActivity.this,"positive",Toast.LENGTH_SHORT).show();
            }
        });
        exitDialog.setNeutralButton("neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "neutral",Toast.LENGTH_SHORT).show();
            }
        });

        exitDialog.show();

    }
}