package com.avanade.basket;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        System.out.println("Calculating price for " + Arrays.toString(args));
        long price = new BasketCalc().calculatePrice(args);
        System.out.println("Price for " + Arrays.toString(args) + " is " + price + "p");
    }
}
