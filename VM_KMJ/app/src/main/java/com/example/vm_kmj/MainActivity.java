package com.example.vm_kmj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    EditText input_money_edt;
    TextView input_money_tv;
    Button input_money_btn, changes_return;
    TextView coke_qty_tv,soda_qty_tv,fanta_qty_tv,demisoda_qty_tv;
    Button coke_order_btn,soda_order_btn,fanta_order_btn,demisoda_order_btn;
    int money = 0;
    int coke_qty = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_money_edt = findViewById(R.id.input_money_edt);
        input_money_tv = findViewById(R.id.input_money_tv);
        input_money_btn = findViewById(R.id.input_money_btn);

        coke_qty_tv = findViewById(R.id.coke_qty_tv);
        soda_qty_tv = findViewById(R.id.soda_qty_tv);
        fanta_qty_tv = findViewById(R.id.fanta_qty_tv);
        demisoda_qty_tv = findViewById(R.id.demisoda_qty_tv);

        coke_order_btn = findViewById(R.id.coke_order_btn);
        soda_order_btn = findViewById(R.id.soda_order_btn);
        fanta_order_btn = findViewById(R.id.fanta_order_btn);
        demisoda_order_btn = findViewById(R.id.demisoda_order_btn);

        changes_return = findViewById(R.id.changes_return);

        // [1] 잔액 삽입 및 합산 처리
        input_money_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                money += Integer.parseInt(input_money_edt.getText().toString());
                input_money_tv.setText("잔액 : " + money+"원");
                input_money_edt.setText(null);
                input_money_edt.clearFocus();
            }
        });

        // [2] 콜라 주문 처리
        coke_order_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coke_qty -= 1;
                coke_qty_tv.setText(coke_qty + "개 남음");
            }
        });

        // [3] 잔돈 반환 처리
        changes_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                ArrayList<DrinkDTO> drink_list =  new ArrayList<DrinkDTO>();
                    drink_list.add(new DrinkDTO("콜라","10"));
                    drink_list.add(new DrinkDTO("사이다","10"));
                    drink_list.add(new DrinkDTO("환타","0"));
                    drink_list.add(new DrinkDTO("데미소다","10"));

                intent.putExtra("drink_list",drink_list);
                startActivity(intent);
            }
        });
    }//onCreate()

}