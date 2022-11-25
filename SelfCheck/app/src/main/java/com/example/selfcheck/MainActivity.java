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
    Button btn_c, btn_s, btn_f, btn_d, btn_charge, btn_rtn; //구매버튼, 금액입력, 잔돈반환
    TextView tv_money, coke_cnt, saida_cnt, fanta_cnt, demisoda_cnt; //잔액, 재고
    TextView coke_price, saida_price, fanta_price, demisoda_price; //가격
    TextView coke_name, saida_name, fanta_name, demisoda_name;
    EditText inputMoney;

    int money = 0;
    int buyCokeCnt = 0;
    int buySaidaCnt = 0;
    int buyFantaCnt = 0;
    int buyDemisodaCnt = 0;

    DrinkDTO coke = new DrinkDTO(10, 800, "콜라");
    DrinkDTO saida = new DrinkDTO(11, 800, "사이다");
    DrinkDTO fanta = new DrinkDTO(12, 700, "환타");
    DrinkDTO demisoda = new DrinkDTO(13, 700, "데미소다");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_c = findViewById(R.id.btn_c);           //콜라 구매 버튼
        btn_s = findViewById(R.id.btn_s);           //사이다 구매 버튼
        btn_f = findViewById(R.id.btn_f);           //환타 구매 버튼
        btn_d = findViewById(R.id.btn_d);           //데미소다 구매 버튼

        btn_charge = findViewById(R.id.btn_charge); //금액 충전 버튼
        btn_rtn = findViewById(R.id.btn_rtn);       //잔액 반환 버튼
        inputMoney = findViewById(R.id.inputMoney); //입력한 금액
        tv_money = findViewById(R.id.tv_money);     //잔액 표시

        coke_cnt = findViewById(R.id.coke_cnt);     //콜라 남은수량
        saida_cnt = findViewById(R.id.saida_cnt);   //사이다 남은수량
        fanta_cnt = findViewById(R.id.fanta_cnt);   //환타 남은수량
        demisoda_cnt = findViewById(R.id.demisoda_cnt);   //데미소다 남은수량

        //상품가격 id 찾기
        coke_price = findViewById(R.id.coke_price);
        saida_price = findViewById(R.id.saida_price);
        fanta_price = findViewById(R.id.fanta_price);
        demisoda_price = findViewById(R.id.demisoda_price);

        //상품이름 id 찾기
        coke_name = findViewById(R.id.coke_name);
        saida_name = findViewById(R.id.saida_name);
        fanta_name = findViewById(R.id.fanta_name);
        demisoda_name = findViewById(R.id.demisoda_name);

//        Intent intent = new Intent(MainActivity.this, DrinkDAO.class);
//        intent.putExtra("coke", coke);
//        intent.putExtra("saida", saida);

        //상품 금액 view에 넣어주기
        coke_price.setText(coke.getPrice()+"원");
        saida_price.setText(saida.getPrice()+"원");
        fanta_price.setText(fanta.getPrice()+"원");
        demisoda_price.setText(demisoda.getPrice()+"원");
        //상품 수량 view에 넣어주기
        coke_cnt.setText(coke.getCnt()+"");
        saida_cnt.setText(saida.getCnt()+"");
        fanta_cnt.setText(fanta.getCnt()+"");
        demisoda_cnt.setText(demisoda.getCnt()+"");
        //상품이름 view에 넣어주기
        coke_name.setText(coke.getName());
        saida_name.setText(saida.getName());
        fanta_name.setText(fanta.getName());
        demisoda_name.setText(demisoda.getName());

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
                    Log.d("잔액확인", money+"");
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
                    int c = Integer.parseInt(String.valueOf(coke_cnt.getText())); //현재 콜라 재고//현재 콜라 재고

                    if( m < coke.getPrice() || c == 0){
                        Toast.makeText(MainActivity.this, "오류 (잔액, 재고 확인)", Toast.LENGTH_SHORT).show();
                    }else{
                        int rm = m - coke.getPrice();
                        tv_money.setText(String.valueOf(rm));
                        int rc = c - 1;
                        coke_cnt.setText(String.valueOf(rc));


                        buyCokeCnt++;
                        money = money - coke.getPrice();

                        Log.d("log", "onClick: "+buyCokeCnt);
//                        Intent intent1 = new Intent(MainActivity.this, SubActivity.class);
                        //intent.putExtra("buyCokeCnt", buyCokeCnt);  // 몇 개 샀는지를 SubActivity 에 넘겨주기
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "잔액이 부족합니다", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(MainActivity.this, "오류 (잔액, 재고 확인)", Toast.LENGTH_SHORT).show();
                    }else{
                        int rm = m - saida.getPrice();
                        tv_money.setText(String.valueOf(rm));
                        int rc = c - 1;
                        saida_cnt.setText(String.valueOf(rc));
                        buySaidaCnt++;
                        money = money - saida.getPrice();
                        Log.d("log", "onClick: "+buySaidaCnt);

                        // 몇 개 샀는지를 SubActivity 에 넘겨주기

                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "잔액이 부족합니다", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(MainActivity.this, "오류 (잔액, 재고 확인)", Toast.LENGTH_SHORT).show();
                    }else{
                        int rm = m - fanta.getPrice();
                        tv_money.setText(String.valueOf(rm));
                        int rc = c - 1;
                        fanta_cnt.setText(String.valueOf(rc));
                        buyFantaCnt++;
                        money = money - fanta.getPrice();
                        Log.d("log", "onClick: "+buyFantaCnt);

                        // 몇 개 샀는지를 SubActivity 에 넘겨주기

                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "잔액이 부족합니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //데미소다 주문시
        btn_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int m = Integer.parseInt(String.valueOf(tv_money.getText())); //현재 잔액
                    int c = Integer.parseInt(String.valueOf(demisoda_cnt.getText())); //현재 콜라 재고
                    if( m < demisoda.getPrice() || c == 0){
                        Toast.makeText(MainActivity.this, "주문 오류!", Toast.LENGTH_SHORT).show();
                    }else{
                        int rm = m - demisoda.getPrice();
                        tv_money.setText(String.valueOf(rm));
                        int rc = c - 1;
                        demisoda_cnt.setText(String.valueOf(rc));
                        buyDemisodaCnt++;
                        money = money - demisoda.getPrice();
                        Log.d("log", "onClick: "+buyDemisodaCnt);

                        // 몇 개 샀는지를 SubActivity 에 넘겨주기

                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "잔액이 부족합니다", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //잔액반환, SubActivity 로 이동
        btn_rtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int m = Integer.parseInt(String.valueOf(tv_money.getText()));
                Intent intent = new Intent(MainActivity.this, SubActivity.class);

                intent.putExtra("balance", m);
                intent.putExtra("buyCokeCnt", buyCokeCnt);
                intent.putExtra("buySaidaCnt", buySaidaCnt);
                intent.putExtra("buyFantaCnt", buyFantaCnt);
                intent.putExtra("buyDemisodaCnt", buyDemisodaCnt);

                startActivity(intent);
            }
        });


    }
}