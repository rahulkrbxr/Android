package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

//    boolean bartIsShowing = true;

    public void fade(View view) {

        Log.i("Info", "Imageview tapped");

        ImageView bartImageView = (ImageView) findViewById(R.id.bartImageView);

        ImageView homerImageView = (ImageView) findViewById(R.id.homerImageView);

        // 1000dp down in 2s
        bartImageView.animate().alpha(1).translationXBy(1000).rotation(1800).setDuration(1000);

//        if (bartIsShowing) {
//            bartIsShowing = false;
//
//            bartImageView.animate().alpha(0).setDuration(2000);
//
//            homerImageView.animate().alpha(1).setDuration(2000);
//        } else {
//            bartIsShowing = true;
//
//            bartImageView.animate().alpha(1).setDuration(2000);
//
//            homerImageView.animate().alpha(0).setDuration(2000);
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView bartImageView = (ImageView) findViewById(R.id.bartImageView);

        bartImageView.setX(-1000);

        bartImageView.animate().translationXBy(1000).rotation(3600).alpha(1).setDuration(2000);

    }
}