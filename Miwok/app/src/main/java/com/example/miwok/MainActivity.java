package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view  that shows the numbers category
        TextView numbers = findViewById(R.id.numbers);

        // Find the view that shows the Family category
        TextView family = findViewById(R.id.family);

        // Find the view that shows the colors category
        TextView colors = findViewById(R.id.colors);

        // Find the view that shows the phrases category
        TextView phrases = findViewById(R.id.phrases);

        // Set a click listener on that view
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
                // Start the new activity
                startActivity(numbersIntent);
            }
        });

        // Set a click listener on family category
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link FamilyActivity}
                Intent familyIntent = new Intent(MainActivity.this, FamilyActivity.class);
                // Start the new activity
                startActivity(familyIntent);
            }
        });

        // Set a click listener on colors category
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link ColorsActivity}
                Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);
                // Start the new activity
                startActivity(colorsIntent);
            }
        });

        // Set a click listener on phrases category
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link PhrasesActivity}
                Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                // Start the new activity
                startActivity(phrasesIntent);
            }
        });
    }
}