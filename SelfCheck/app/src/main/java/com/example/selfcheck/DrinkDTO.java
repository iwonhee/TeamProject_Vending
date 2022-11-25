package com.example.selfcheck;

import java.io.Serializable;

public class DrinkDTO implements Serializable {
    private int cnt, price;
    private String name;

    public DrinkDTO(int cnt, int price, String name) {
        this.cnt = cnt;
        this.price = price;
        this.name = name;
    }
    public DrinkDTO(){}
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCnt() {
        return cnt;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
//rlawnsgh