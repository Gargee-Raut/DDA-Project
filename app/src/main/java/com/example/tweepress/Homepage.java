package com.example.tweepress;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Homepage extends AppCompatActivity implements View.OnClickListener{

    public CardView card1,card2,card3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        card1= findViewById(R.id.c1);
        card2= findViewById(R.id.c2);
        card3= findViewById(R.id.c3);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.c1:
                i = new Intent(this, Analyse.class);
                startActivity(i);
                break;
            case R.id.c2:
                i = new Intent(this, Feelings.class);
                startActivity(i);
                break;
            case R.id.c3:
                i = new Intent(this, DepressionInfo.class);
                startActivity(i);
                break;
        }

    }
}