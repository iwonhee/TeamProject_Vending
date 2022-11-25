package com.example.selfcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    TextView balance, tv_buyCoke, tv_buySaida, tv_buyFanta, tv_buyDemisoda;
    TextView tv_buyCoke_txt, tv_buySaida_txt, tv_buyFanta_txt, tv_buyDemisoda_txt;
    TextView tv_buyCoke_txt2, tv_buySaida_txt2, tv_buyFanta_txt2, tv_buyDemisoda_txt2;
    Button btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        btn_back = findViewById(R.id.btn_back);
        balance = findViewById(R.id.balance);
        tv_buyCoke = findViewById(R.id.tv_buyCoke);
        tv_buySaida = findViewById(R.id.tv_buySaida);
        tv_buyFanta = findViewById(R.id.tv_buyFanta);
        tv_buyDemisoda = findViewById(R.id.tv_buyDemisoda);
        tv_buyCoke_txt = findViewById(R.id.tv_buyCoke_txt);
        tv_buySaida_txt = findViewById(R.id.tv_buySaida_txt);
        tv_buyFanta_txt = findViewById(R.id.tv_buyFanta_txt);
        tv_buyDemisoda_txt = findViewById(R.id.tv_buyDemisoda_txt);
        tv_buyCoke_txt2 = findViewById(R.id.tv_buyCoke_txt2);
        tv_buySaida_txt2 = findViewById(R.id.tv_buySaida_txt2);
        tv_buyFanta_txt2 = findViewById(R.id.tv_buyFanta_txt2);
        tv_buyDemisoda_txt2 = findViewById(R.id.tv_buyDemisoda_txt2);

        // Intent로 음료 몇 개 샀는지 받아오기
        Intent intent = getIntent();
        int ibal = intent.getIntExtra("balance", -1);
        int saidaCnt = intent.getIntExtra("buySaidaCnt", -1);
        int cokeCnt = intent.getIntExtra("buyCokeCnt", -1);
        int fantaCnt = intent.getIntExtra("buyfantaCnt", 0);
        int demisodaCnt = intent.getIntExtra("buydemisodaCnt", 0);
        Log.d("log", "sub : "+ibal);
        Log.d("log", "saidaCnt : " + saidaCnt);
        Log.d("log", "cokeCnt : " + cokeCnt);

//        int tv_buyCoke_int = Integer.parseInt(String.valueOf(tv_buyCoke));
//        int tv_buySaida_int = Integer.parseInt(String.valueOf(tv_buySaida));
//        int tv_buyDrk1_int = Integer.parseInt(String.valueOf(tv_buyDrk1));
//        int tv_buyDrk2_int = Integer.parseInt(String.valueOf(tv_buyDrk2));

        // 몇 개 샀는지 화면에 띄우기
        //콜라
        if(cokeCnt == 0){
            tv_buyCoke_txt.setVisibility(View.GONE);
            tv_buyCoke_txt2.setVisibility(View.GONE);
            tv_buyCoke.setVisibility(View.GONE);
        }else{
            tv_buyCoke_txt.setText("콜라 ");
            tv_buyCoke_txt2.setText("개");
            tv_buyCoke.setText(""+cokeCnt);
        }
        //사이다
        if(saidaCnt == 0){
            tv_buySaida_txt.setVisibility(View.GONE);
            tv_buySaida_txt2.setVisibility(View.GONE);
            tv_buySaida.setVisibility(View.GONE);
        }else{
            tv_buySaida_txt.setText("사이다");
            tv_buySaida_txt2.setText("개");
            tv_buySaida.setText(""+saidaCnt);
        }
        //환타
        if(fantaCnt == 0){
            tv_buyFanta_txt.setVisibility(View.GONE);
            tv_buyFanta_txt2.setVisibility(View.GONE);
            tv_buyFanta.setVisibility(View.GONE);
        }else{
            tv_buyFanta_txt.setText("사이다");
            tv_buyFanta_txt2.setText("개");
            tv_buyFanta.setText(""+saidaCnt);
        }
        //데미소다
        if(demisodaCnt == 0){
            tv_buyDemisoda_txt.setVisibility(View.GONE);
            tv_buyDemisoda_txt2.setVisibility(View.GONE);
            tv_buyDemisoda.setVisibility(View.GONE);
        }else{
            tv_buyDemisoda_txt.setText("사이다");
            tv_buyDemisoda_txt2.setText("개");
            tv_buyDemisoda.setText(""+saidaCnt);
        }
        balance.setText("잔액 : "+ibal);
//        tv_buyCoke.setText("콜라 "+cokeCnt);
//        tv_buySaida.setText("사이다 "+saidaCnt);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SubActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });

    }
}