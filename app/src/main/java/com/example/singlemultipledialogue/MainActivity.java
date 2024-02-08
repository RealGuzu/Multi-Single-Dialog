package com.example.singlemultipledialogue;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnSingle;
    Button btnMulti;
    TextView txt;

    CharSequence[] items = {"Pizza", "Burger", "Sushi", "Tacos", "Pasta"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.displayTXT);
        btnSingle = findViewById(R.id.singleChoiceButton);


        // Moved the setting of text after initializing txt
        txt.setText(items[0]);

        btnSingle.setOnClickListener(v -> {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder.setTitle("Select Food");
            alertDialogBuilder.setCancelable(true);
            alertDialogBuilder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    txt.setText(items[which]);
                    dialog.dismiss();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.setCanceledOnTouchOutside(true);
            alertDialog.show();
        });


    }
}
