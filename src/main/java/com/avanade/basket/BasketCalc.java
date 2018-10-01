package com.avanade.basket;

import io.vavr.Tuple2;

import static io.vavr.API.Array;
import static io.vavr.API.Tuple;

public class BasketCalc {


    public long calculatePrice(String[] args) {
        return Array(args)
                .map(Items::valueOf)
                .groupBy(item -> item)
                .map(t -> Tuple(t._1, t._2.length()))
                .map(this::priceForItem2)
                .sum().longValue();
    }

    private long priceForItem2(Tuple2<Items, Integer> tuple) {
        Items item = tuple._1;

        long quantityBase = item.getBase() * (tuple._2 / item.getRequiredForSingleDiscount());
        long quantityRest = tuple._2 % item.getRequiredForSingleDiscount();

        long quantityToPrice = quantityBase + quantityRest;
        return quantityToPrice * item.getPrice();
    }
}
