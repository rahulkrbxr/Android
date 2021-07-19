package com.example.intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend = (Button)findViewById(R.id.emailButton);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent si = new Intent(Intent.ACTION_SEND);
                si.setType("message/rfc822");
                si.putExtra(Intent.EXTRA_EMAIL, new String[] {"support@dgrc.com", "contactme@rahul.com"});
                si.putExtra(Intent.EXTRA_SUBJECT, "Welcome to DGRC");
                si.putExtra(Intent.EXTRA_TEXT, "Hi Rahul,\nWelcome to DGRC.\nHope your training is going well.");
                startActivity(Intent.createChooser(si, "Choose Mail App"));
            }
        });
    }
}