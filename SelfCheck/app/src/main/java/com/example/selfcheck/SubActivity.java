package com.example.selfcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    TextView balance;
    TextView order_cnt;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        balance = findViewById(R.id.balance);
        order_cnt = findViewById(R.id.order_cnt);
        
        Intent intent = getIntent();
        int ibal = intent.getIntExtra("balance", -1);
        int cokeCnt = intent.getIntExtra("buyCokeCnt", -1);
        int saidaCnt = intent.getIntExtra("buySaidaCnt", -1);
        int fantaCnt = intent.getIntExtra("buyFantaCnt", -1);
        int demisodaCnt = intent.getIntExtra("buyDemisodaCnt", -1);

        Log.d("log", "sub : "+ibal);
        Log.d("log", "cokeCnt : " + cokeCnt);
        Log.d("log", "saidaCnt : " + saidaCnt);
        Log.d("log", "fantaCnt : " + fantaCnt);
        Log.d("log", "demisodaCnt : " + demisodaCnt);
        balance.setText("잔액 : "+ibal);
<<<<<<< HEAD
        
        if(cokeCnt > 0){
            order_cnt.append("콜라"+cokeCnt+"개\t" );
        }
        if(saidaCnt > 0){
            order_cnt.append("사이다"+saidaCnt+"개\t");
        }
        if(fantaCnt > 0){
            order_cnt.append("환타"+fantaCnt+"개\t");
        }
        if(demisodaCnt > 0){
            order_cnt.append("데미소다"+demisodaCnt+"개\t");
        }
=======
//        tv_buyCoke.setText("콜라 "+cokeCnt);
//        tv_buySaida.setText("사이다 "+saidaCnt);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SubActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });
        // sefsef
>>>>>>> wonhee

    }
}