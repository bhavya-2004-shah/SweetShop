package com.example;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

public class SweetShopTest {

    @Test
    public void testAddSweet() {
        SweetShop shop = new SweetShop();
        Sweet sweet = new Sweet(1, "Kaju Katli", "Nut-Based", 50.0, 20);

        shop.addSweet(sweet);

        List<Sweet> sweets = shop.getAllSweets();

        assertEquals(1, sweets.size());
        assertEquals("Kaju Katli", sweets.get(0).getName());
    }
}
