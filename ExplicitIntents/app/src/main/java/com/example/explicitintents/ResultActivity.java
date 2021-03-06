package com.example.explicitintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

//        TextView result = (TextView) findViewById(R.id.resultTextView);
//        Intent intent = getIntent();
//        String addition = (String) intent.getSerializableExtra("SUM");

        Bundle extras = getIntent().getExtras();
//        String key = "Sum";
        String ans = extras.getString("value");

        Intent intent = getIntent();
        String operation = intent.getStringExtra("operation");

        TextView text=(TextView)findViewById(R.id.resultTextView) ;
        text.setText(ans);
        
//        result.setText(addition);

        Toast.makeText(this, "Hi, " + operation + "\n" + "Result = " + ans, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Press back to add again!", Toast.LENGTH_SHORT).show();
    }

    public void goMainActivity(View view) {
//        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//        startActivity(intent);
        finish();
    }
}
