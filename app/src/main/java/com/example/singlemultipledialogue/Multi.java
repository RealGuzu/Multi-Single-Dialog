//package com.example.singlemultipledialogue;
//
//import android.content.DialogInterface;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AppCompatActivity;
//
//public class Multi extends AppCompatActivity {
//
//    Button btn;
//    TextView display;
//
//    CharSequence[] items = {"Pizza", "Burger", "Sushi", "Tacos", "Pasta"};
//
//    boolean[] selectedItems = {false, false, false, false, false};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        btn = findViewById(R.id.multiChoiceButton);
//        display = findViewById(R.id.displayTXT);
//
//        btn.setOnClickListener(v -> {
//            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Multi.this);
//            alertDialogBuilder.setTitle("Select Food");
//            alertDialogBuilder.setCancelable(true);
//            alertDialogBuilder.setMultiChoiceItems(items, selectedItems, new DialogInterface.OnMultiChoiceClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//                    selectedItems[which] = isChecked;
//                }
//            });
//            alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    display.setText(itemsToString());
//                }
//            });
//            AlertDialog alertDialog = alertDialogBuilder.create();
//            alertDialog.setCanceledOnTouchOutside(true);
//            alertDialog.show();
//        });
//    }
//
//    private String itemsToString() {
//        StringBuilder text = new StringBuilder();
//        for (int i = 0; i < selectedItems.length; i++) {
//            if (selectedItems[i]) {
//                text.append(items[i]).append(" ");
//            }
//        }
//        return text.toString().trim();
//    }
//}
