package com.avanade.basket;

import io.vavr.Tuple2;
import io.vavr.collection.Array;


import static io.vavr.API.Array;

public class BasketCalc {


    public long calculatePrice(String[] args) {
        return Array(args)
                .map(Items::valueOf)
                .groupBy(item -> item)
                .mapValues(Array::length)
                .map(this::priceForItem)
                .sum().longValue();
    }

    private long priceForItem(Tuple2<Items, Integer> tuple) {
        Items item = tuple._1;

        long quantityBase = item.getBase() * (tuple._2 / item.getRequiredForSingleDiscount());
        long quantityRest = tuple._2 % item.getRequiredForSingleDiscount();

        long quantityToPrice = quantityBase + quantityRest;
        return quantityToPrice * item.getPrice();
    }
}
