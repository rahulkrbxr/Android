package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<>();

        // Words.add("one");
        words.add(new Word("one", "lutti"));
        words.add(new Word("two", "atiko"));
        words.add(new Word("three", "tolookosu"));
        words.add(new Word("four", "oyyisa"));
        words.add(new Word("five", "massokka"));
        words.add(new Word("six", "temmokka"));
        words.add(new Word("seven", "kenekaku"));
        words.add(new Word("eight", "kawinta"));
        words.add(new Word("nine", "wo'e"));
        words.add(new Word("ten", "na'aacha"));

        /**
         * Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
         * adapter known how to create layouts for each item in the list, using the
         * list_item.xml custom layout resource defined in the Resource directory.
         * The list item layout contains a double {@link TextView}, which the adapter will display
         */

        WordAdapter adapter = new WordAdapter(this, words);

        /**
         * Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
         * There should be a {@link ListView} with the view ID called list, which is declared in
         * activity_numbers.xml layout file.
         */
        ListView listView = findViewById(R.id.list);

        /**
         * Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
         * {@link ListView} will display list items for each word object in the list of words.
         * Do this by calling the setAdapter method on the {@link ListView} object and pass in
         * as parameter.
         */
        listView.setAdapter(adapter);
    }
}