package com.avanade.basket;

public enum Items {
    Apple(35, 1, 0),
    Banana(20, 1, 0),
    Melon(50, 1, 1),
    Lime(15, 2, 1);

    private final int price;
    private final int base;
    private final int offer;

    Items(int price, int base, int offer) {
        this.price = price;
        this.base = base;
        this.offer = offer;
    }

    public int getPrice() {
        return price;
    }

    public int getBase() {
        return base;
    }

    public int getOffer() {
        return offer;
    }

    public int getRequiredForSingleDiscount() {
        return base + offer;
    }
}
