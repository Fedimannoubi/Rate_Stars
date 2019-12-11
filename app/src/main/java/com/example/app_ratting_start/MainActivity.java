package com.example.app_ratting_start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    String Rate = "00";
    SharedPreferences sp;
    Float curentRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RatingBar mRatingBar = findViewById(R.id.ratingBar2);


        curentRate=getRating();
        mRatingBar.setRating(curentRate);

        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                setRating(v);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, second.class);
                startActivity(i);

            }
        });
    }

    private void setRating(float v) {

        SharedPreferences sp = getSharedPreferences(Rate, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putFloat(Rate, v);

        editor.apply();

    }

    private float getRating(){
        SharedPreferences sp = getSharedPreferences(Rate, MODE_PRIVATE);
        float name = sp.getFloat(Rate, 0);


    return name;
    }
}
