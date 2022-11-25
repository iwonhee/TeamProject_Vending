package com.example.vm_kmj;

import java.io.Serializable;

public class DrinkDTO implements Serializable {
    private String drink_name, drink_qty;

    public DrinkDTO(String drink_name, String drink_qty) {
        this.drink_name = drink_name;
        this.drink_qty = drink_qty;
    }

    public String getDrink_name() {
        return drink_name;
    }

    public String getDrink_qty() {
        return drink_qty;
    }

    public void setDrink_name(String drink_name) {
        this.drink_name = drink_name;
    }

    public void setDrink_qty(String drink_qty) {
        this.drink_qty = drink_qty;
    }
}
