package com.example.tweepress;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class Feelings extends AppCompatActivity implements View.OnClickListener  {
    TextView textView;
    LottieAnimationView l1, l2, l3, l4;
    public CardView ca1, ca2, ca3, ca4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feelings);

        textView = findViewById(R.id.title);
        l1 = findViewById(R.id.happy);
        l2 = findViewById(R.id.neutral);
        l3 = findViewById(R.id.sad);
        l4 = findViewById(R.id.angry);

        ca1 = findViewById(R.id.ch);
        ca2 = findViewById(R.id.cn);
        ca3 = findViewById(R.id.cs);
        ca4 = findViewById(R.id.ca);

        ca1.setOnClickListener(this);
        ca2.setOnClickListener(this);
        ca3.setOnClickListener(this);
        ca4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent i;
        switch (v.getId()) {
            case R.id.ch:
                i = new Intent(this, happy.class);
                startActivity(i);
                break;
            case R.id.cn:
                i = new Intent(this, Neutral.class);
                startActivity(i);
                break;
            case R.id.cs:
                i = new Intent(this, sad.class);
                startActivity(i);
                break;
            case R.id.ca:
                i = new Intent(this, angry.class);
                startActivity(i);
                break;

        }
    }
}