package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = (EditText) findViewById(R.id.urlText);
        Button btn = (Button) findViewById(R.id.buttonNavigate);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String url = editText.getText().toString();

//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.google.com"));

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                startActivity(intent);
            }
        });
    }
}