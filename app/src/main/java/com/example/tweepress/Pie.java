package com.example.tweepress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class Pie extends AppCompatActivity {


    TextView tvPython, tvCPP;
    PieChart pieChart;
    public String a;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        a = sh.getString("myVal", "0");

        tvPython = findViewById(R.id.tvPython);
        tvCPP = findViewById(R.id.tvCPP);
        pieChart = findViewById(R.id.piechart);

        setData();
    }

    private void setData()
    {


        float i = Float.parseFloat(a),j;
        j = 100-i;

        tvPython.setText(Float.toString(j));
        tvCPP.setText(Float.toString(i));

        pieChart.addPieSlice(
                new PieModel(
                        "Non-depressed",
                        Float.parseFloat(tvPython.getText().toString()),
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "Depressed",
                        Float.parseFloat(tvCPP.getText().toString()),
                        Color.parseColor("#EF5350")));

        pieChart.startAnimation();
    }
}