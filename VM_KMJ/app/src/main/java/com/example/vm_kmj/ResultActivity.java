package com.example.vm_kmj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        ArrayList<DrinkDTO> drink_list = (ArrayList<DrinkDTO>)intent.getSerializableExtra("drink_list");
        Log.d("로그", "값 : " + drink_list.size());
    }
}