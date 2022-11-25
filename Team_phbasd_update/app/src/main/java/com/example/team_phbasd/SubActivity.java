package com.example.team_phbasd;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    TextView balance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        balance = findViewById(R.id.balance);

        Intent intent = getIntent();
        int ibal = intent.getIntExtra("balance", -1);
        int saidaCnt = intent.getIntExtra("buySaidaCnt", -1);
        int cokeCnt = intent.getIntExtra("buyCokeCnt", -1);
        Log.d("log", "sub : "+ibal);
        Log.d("log", "saidaCnt : " + saidaCnt);
        Log.d("log", "cokeCnt : " + cokeCnt);
        balance.setText("잔액 : "+ibal);


    }
}