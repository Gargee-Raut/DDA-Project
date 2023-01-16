package com.example.tweepress;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class Analyse extends AppCompatActivity {
    public String shareValue;
    public int a;
    LottieAnimationView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyse);
        l = findViewById(R.id.analysel);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText num1 = findViewById(R.id.num1);

                String value1 = num1.getText().toString();

                OkHttpClient okHttpClient = new OkHttpClient();
                RequestBody formBody = new FormBody.Builder().add("num1",value1).build();
                Request request= new Request.Builder().url("http://192.168.31.156:5000/abc").post(formBody).build();
                Log.d("Maza TAG", "onClick: inside loger");
                okHttpClient.newCall(request).enqueue(new Callback() {

                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Log.d("Maza Tag","Insided req err");
                                Toast.makeText(Analyse.this, "Network not found", Toast.LENGTH_LONG).show();
                            }
                        });
                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        TextView textView = findViewById(R.id.textView);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Log.d("Maza Tag","Insided req res");
                                    String result = response.body().string();
                                    shareValue = result;
                                    textView.setText(result);
                                    SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                                    SharedPreferences.Editor myEdit = sharedPreferences.edit();
                                    myEdit.putString("myVal", shareValue);
                                    myEdit.commit();
                                    Intent in = new Intent(Analyse.this, Pie.class);
                                    startActivity(in);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                });
            }
        });
    }
}