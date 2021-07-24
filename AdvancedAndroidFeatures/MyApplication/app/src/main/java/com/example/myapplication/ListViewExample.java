package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ListViewExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_example);

        ListView listView = findViewById(R.id.myListView);

//        ArrayList<String> friends = new ArrayList<String>();
//
//        friends.add("Monica");
//        friends.add("Simran");
//        friends.add("Saikiran");
//        friends.add("Bittu");

        ArrayList<String> friends = new ArrayList<String>(Arrays.asList("Monica", "Sam", "Tomathy", "Susy"));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, friends);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), friends.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}