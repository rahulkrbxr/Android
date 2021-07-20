package com.example.androidtogglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton1, toggleButton2;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButtonClick();

    }

    public  void addListenerOnButtonClick() {
        //Getting the ToggleButton and Button instance from the layout xml file

        toggleButton1 = (ToggleButton)findViewById(R.id.toggleButton1);
        toggleButton2 = (ToggleButton)findViewById(R.id.toggleButton2);

        buttonSubmit = (Button)findViewById(R.id.button);

        // Performing action on button click
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result = new StringBuilder();
                result.append("ToggleButtom1: ").append(toggleButton1.getText());
                result.append("\nToggleButton2: ").append(toggleButton2.getText());

                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();

//                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}