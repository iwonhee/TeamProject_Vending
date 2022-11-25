package com.example.selfcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_c, btn_s, btn_charge, btn_rtn;
    TextView tv_money, coke_cnt, saida_cnt;
    EditText inputMoney;

    int money = 0;
    int buyCokeCnt = 0;
    int buySaidaCnt = 0;

    DrinkDTO coke = new DrinkDTO(10, 800, "coke");
    DrinkDTO saida = new DrinkDTO(10, 700, "saida");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_c = findViewById(R.id.btn_c);           //콜라 구매 버튼
        btn_s = findViewById(R.id.btn_s);           //사이다 구매 버튼
        btn_charge = findViewById(R.id.btn_charge); //금액 충전 버튼
        btn_rtn = findViewById(R.id.btn_rtn);       //잔액 반환 버튼
        inputMoney = findViewById(R.id.inputMoney); //입력한 금액
        tv_money = findViewById(R.id.tv_money);     //잔액 표시
        coke_cnt = findViewById(R.id.coke_cnt);     //콜라 남은수량
        saida_cnt = findViewById(R.id.saida_cnt);   //사이다 남은수량

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