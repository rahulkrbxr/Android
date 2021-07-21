package com.example.androidcheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.widget.Toast;

public class AlertDialogExample extends AppCompatActivity {

    Button closeButton;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertdialog);

        closeButton = (Button)findViewById(R.id.button2);
        builder = new AlertDialog.Builder(this);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);

//                builder.setMessage("Do you want to close the application ? ");
//                        .setCancelable(false);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                Toast.makeText(getApplicationContext(), "You choose YES", Toast.LENGTH_SHORT).show();
                            }
                        })

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(), "You choose NO", Toast.LENGTH_SHORT).show();
                            }
                        });

                AlertDialog alertDialog = builder.create();
//                alertDialog.setTitle("Dialog box example");
                alertDialog.show();

            }
        });
    }
}