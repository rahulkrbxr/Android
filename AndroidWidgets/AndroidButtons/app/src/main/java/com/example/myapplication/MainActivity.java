package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText1, editText2;
    private Button buttonSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();

    }

    public void addListenerOnButton() {
        editText1 = (EditText)findViewById(R.id.editTextNumber1);
        editText2 = (EditText)findViewById(R.id.editTextNumber2);
        buttonSum = (Button)findViewById(R.id.button);

        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1 = editText1.getText().toString();
                String value2 = editText2.getText().toString();

                int a = Integer.parseInt(value1);
                int b = Integer.parseInt(value2);

                Toast.makeText(MainActivity.this, "Sum = " + (a+b), Toast.LENGTH_SHORT).show();
            }
        });
    }
}