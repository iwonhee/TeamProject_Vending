package com.example.team_phbasd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_c, btn_s,btn_f,btn_d, btn_charge, btn_rtn;
    TextView tv_money, coke_cnt, saida_cnt, fanta_cnt, demi_cnt;
    EditText inputMoney;

    int money = 0;
    int buyCokeCnt = 0;
    int buySaidaCnt = 0;
    ArrayList<DrinkDTO> list = new ArrayList<DrinkDTO>();
    DrinkDTO coke = new DrinkDTO(10, 800, "coke");
    DrinkDTO saida = new DrinkDTO(10, 700, "saida");
    DrinkDTO fanta = new DrinkDTO(10, 800, "fanta");
    DrinkDTO demi = new DrinkDTO(10, 700, "demi");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_c = findViewById(R.id.coke_order_btn);           //콜라 구매 버튼
        btn_s = findViewById(R.id.coke_order_btn2);           //사이다 구매 버튼
        btn_f = findViewById(R.id.coke_order_btn3);           //환타 구매 버튼
        btn_d = findViewById(R.id.coke_order_btn4);           //데미소다 구매 버튼
        btn_charge = findViewById(R.id.input_money_btn); //금액 충전 버튼
        btn_rtn = findViewById(R.id.btn_rtn);       //잔액 반환 버튼
        inputMoney = findViewById(R.id.input_money_edt); //입력한 금액
        tv_money = findViewById(R.id.input_money_tv);     //잔액 표시
        coke_cnt = findViewById(R.id.coke_cnt);     //콜라 남은수량
        saida_cnt = findViewById(R.id.coke_cnt2);   //사이다 남은수량
        fanta_cnt = findViewById(R.id.coke_cnt3);     //환타 남은수량
        demi_cnt = findViewById(R.id.coke_cnt4);   //데미소다 남은수량

        Intent intent = new Intent(MainActivity.this, DrinkDAO.class);
        intent.putExtra("coke", coke);
        intent.putExtra("saida", saida);

        //금액 입력
        btn_charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("log", "onClick: ");
                try{
                    int imoney = Integer.parseInt(String.valueOf(inputMoney.getText()));
                    money += imoney;
                    tv_money.setText(String.valueOf(money));
                    inputMoney.setText("");
                }catch (Exception e){
                    //숫자만 입력하라는 경고 메세지 -> Toast?
                    Toast.makeText(MainActivity.this, "숫자만 입력하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //콜라 주문시
        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int m = Integer.parseInt(String.valueOf(tv_money.getText())); //현재 잔액
                    int c = Integer.parseInt(String.valueOf(coke_cnt.getText())); //현재 콜라 재고
                    if( m < coke.getPrice() || c == 0){
                        Toast.makeText(MainActivity.this, "주문 오류!", Toast.LENGTH_SHORT).show();
                    }else{
                        int rm = m - coke.getPrice();
                        tv_money.setText(String.valueOf(rm));
                        int rc = c - 1;
                        coke_cnt.setText(String.valueOf(rc));
                        buyCokeCnt++;
                        Log.d("log", "onClick: "+buyCokeCnt);
//                        Intent intent1 = new Intent(MainActivity.this, SubActivity.class);
                        intent.putExtra("buyCokeCnt", buyCokeCnt);  // 몇 개 샀는지를 SubActivity 에 넘겨주기
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "오류발생", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //사이다 주문시
        btn_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int m = Integer.parseInt(String.valueOf(tv_money.getText())); //현재 잔액
                    int c = Integer.parseInt(String.valueOf(saida_cnt.getText())); //현재 콜라 재고
                    if( m < saida.getPrice() || c == 0){
                        Toast.makeText(MainActivity.this, "주문 오류!", Toast.LENGTH_SHORT).show();
                    }else{
                        int rm = m - saida.getPrice();
                        tv_money.setText(String.valueOf(rm));
                        int rc = c - 1;
                        saida_cnt.setText(String.valueOf(rc));
                        buySaidaCnt++;
                        Log.d("log", "onClick: "+buySaidaCnt);

                        // 몇 개 샀는지를 SubActivity 에 넘겨주기
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "오류발생", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //환타 주문시
        btn_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int m = Integer.parseInt(String.valueOf(tv_money.getText())); //현재 잔액
                    int c = Integer.parseInt(String.valueOf(fanta_cnt.getText())); //현재 콜라 재고
                    if( m < fanta.getPrice() || c == 0){
                        Toast.makeText(MainActivity.this, "주문 오류!", Toast.LENGTH_SHORT).show();
                    }else{
                        int rm = m - fanta.getPrice();
                        tv_money.setText(String.valueOf(rm));
                        int rc = c - 1;
                        fanta_cnt.setText(String.valueOf(rc));
                        buySaidaCnt++;
                        Log.d("log", "onClick: "+buySaidaCnt);

                        // 몇 개 샀는지를 SubActivity 에 넘겨주기
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "오류발생", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //데미소다 주문시
        btn_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int m = Integer.parseInt(String.valueOf(tv_money.getText())); //현재 잔액
                    int c = Integer.parseInt(String.valueOf(demi_cnt.getText())); //현재 콜라 재고
                    if( m < demi.getPrice() || c == 0){
                        Toast.makeText(MainActivity.this, "주문 오류!", Toast.LENGTH_SHORT).show();
                    }else{
                        int rm = m - demi.getPrice();
                        tv_money.setText(String.valueOf(rm));
                        int rc = c - 1;
                        demi_cnt.setText(String.valueOf(rc));
                        buySaidaCnt++;
                        Log.d("log", "onClick: "+buySaidaCnt);

                        // 몇 개 샀는지를 SubActivity 에 넘겨주기
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "오류발생", Toast.LENGTH_SHORT).show();
                }
            }
        });

        

        //잔액반환, SubActivity 로 이동
        btn_rtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int m = Integer.parseInt(String.valueOf(tv_money.getText()));
                Intent intent1 = new Intent(MainActivity.this, SubActivity.class);
                intent1.putExtra("balance", m);
                intent1.putExtra("buySaidaCnt", buySaidaCnt);
                intent1.putExtra("buyCokeCnt", buyCokeCnt);
                startActivity(intent1);
            }
        });


    }
}