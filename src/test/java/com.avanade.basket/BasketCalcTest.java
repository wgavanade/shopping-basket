package com.avanade.basket;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class BasketCalcTest {

    private final String[] items;
    private final long expectedPrice;
    private BasketCalc basketCalc;

    public BasketCalcTest(String[] items, long expectedPrice) {
        this.items = items;
        this.expectedPrice = expectedPrice;
    }

    @Before
    public void setUp() {
        basketCalc = new BasketCalc();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                {new String[]{}, 0L},

                {new String[]{"Apple", "Apple", "Banana"}, 90L},

                {new String[]{"Apple"}, 35L},
                {new String[]{"Apple", "Apple"}, 70L},
                {new String[]{"Apple", "Apple", "Apple"}, 105L},

                {new String[]{"Banana"}, 20L},
                {new String[]{"Banana", "Banana"}, 40L},
                {new String[]{"Banana", "Banana", "Banana"}, 60L},

                {new String[]{"Melon"}, 50L},
                {new String[]{"Melon", "Melon"}, 50L},
                {new String[]{"Melon", "Melon", "Melon", "Melon"}, 100L},
                {new String[]{"Melon", "Melon", "Melon", "Melon", "Melon"}, 150L},

                {new String[]{"Lime"}, 15L},
                {new String[]{"Lime", "Lime"}, 30L},
                {new String[]{"Lime", "Lime", "Lime"}, 30L},
                {new String[]{"Lime", "Lime", "Lime", "Lime"}, 45L},
                {new String[]{"Lime", "Lime", "Lime", "Lime", "Lime"}, 60L},
                {new String[]{"Lime", "Lime", "Lime", "Lime", "Lime", "Lime"}, 60L},
                {new String[]{"Lime", "Lime", "Lime", "Lime", "Lime", "Lime", "Lime"}, 75L},

                {new String[]{"Apple", "Banana", "Melon", "Lime"}, 120L},
                {new String[]{"Apple", "Apple", "Banana", "Melon", "Lime"}, 155L},
                {new String[]{"Apple", "Banana", "Banana", "Melon", "Lime"}, 140L},
                {new String[]{"Apple", "Banana", "Melon", "Lime", "Lime", "Lime", "Lime"}, 150L},
                {new String[]{"Apple", "Banana", "Melon", "Melon", "Melon", "Melon", "Melon", "Lime", "Lime", "Lime", "Lime"}, 250L},
                {new String[]{"Apple", "Banana", "Banana", "Banana", "Melon", "Melon", "Melon", "Melon", "Melon", "Lime", "Lime", "Lime", "Lime"}, 290L},
                {new String[]{"Apple", "Apple", "Apple", "Banana", "Banana", "Banana", "Melon", "Melon", "Melon", "Melon", "Melon", "Lime", "Lime", "Lime", "Lime"}, 360L},
        };
        return Arrays.asList(data);
    }

    @Test
    public void calculatePrice() {
        // Given

        // When
        long computedPrice = basketCalc.calculatePrice(items);

        // Then
        assertThat(computedPrice).isEqualTo(expectedPrice);
    }
}