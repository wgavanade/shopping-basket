package com.avanade.basket;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.Function.*;
import static java.util.stream.Collectors.*;

public class BasketCalc {

    public long calculatePrice(String[] args) {
        return Stream.of(args)
                .map(Items::valueOf) // <- this will cover most basic validation without too much overhead
                .collect(groupingBy(identity(), counting()))
                .entrySet()
                .stream()
                .mapToLong(this::priceForItem)
                .sum();
    }

    private long priceForItem(Map.Entry<Items, Long> tuple) {
        Items item = tuple.getKey();
        long quantityTotal = tuple.getValue();

        long quantityBase = item.getBase() * (quantityTotal / item.getRequiredForSingleDiscount());
        long quantityRest = quantityTotal % item.getRequiredForSingleDiscount();

        long quantityToPrice = quantityBase + quantityRest;
        return quantityToPrice * item.getPrice();
    }

}
