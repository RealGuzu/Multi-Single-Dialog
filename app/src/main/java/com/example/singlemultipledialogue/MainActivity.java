package com.example.singlemultipledialogue;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnSingle;
    Button btnMulti;
    TextView txt;

    CharSequence[] items = {"Pizza", "Burger", "Sushi", "Tacos", "Pasta"};
    boolean[] selectedItems = {false, false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.displayTXT);
        btnSingle = findViewById(R.id.singleChoiceButton);
        btnMulti = findViewById(R.id.multiChoiceButton);

        // Moved the setting of text after initializing txt
        txt.setText(items[0]);

        btnSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSingleChoiceDialog();
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMultiChoiceDialog();
            }
        });
    }

    private void showSingleChoiceDialog() {
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
    }

    private void showMultiChoiceDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Select Food");
        alertDialogBuilder.setCancelable(true);
        alertDialogBuilder.setMultiChoiceItems(items, selectedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                selectedItems[which] = isChecked;
            }
        });
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displaySelectedItems();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.show();
    }

    private void displaySelectedItems() {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < selectedItems.length; i++) {
            if (selectedItems[i]) {
                text.append(items[i]).append(" ");
            }
        }
        txt.setText(text.toString().trim());
    }
}
