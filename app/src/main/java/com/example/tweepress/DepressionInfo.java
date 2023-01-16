package com.example.tweepress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class DepressionInfo extends AppCompatActivity {
    ImageButton depres;
    ImageButton caus;
    ImageButton share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depression_info);
        depres =(ImageButton)findViewById(R.id.depres);
        caus=(ImageButton)findViewById(R.id.caus);
        share=(ImageButton)findViewById(R.id.share);
        depres.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent = new Intent(getApplicationContext(), depression.class);
                                          startActivity(intent);
                                      }

                                  }
        );
        caus.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(getApplicationContext(),Causes.class);
                                        startActivity(intent);
                                    }

                                }
        );
        share.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         Intent intent = new Intent(getApplicationContext(), share.class);
                                         startActivity(intent);
                                     }

                                 }
        );
    }
}