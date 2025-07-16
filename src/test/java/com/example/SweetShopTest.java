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

// public void testDeleteSweet() {
//     SweetShop shop = new SweetShop();
//     Sweet sweet1 = new Sweet(1001, "Kaju Katli", "Nut-Based", 50.0, 20);
//     Sweet sweet2 = new Sweet(1002, "Gulab Jamun", "Milk-Based", 30.0, 10);

//     shop.addSweet(sweet1);
//     shop.addSweet(sweet2);

   
//     shop.deleteSweet(1001);

//     List<Sweet> sweets = shop.getAllSweets();

//     assertEquals(1, sweets.size());
//     assertEquals(1002, sweets.get(0).getId());
// }
    @Test
public void testDeleteSweet() {
    SweetShop shop = new SweetShop();
    Sweet sweet = new Sweet(1001, "Kaju Katli", "Nut-Based", 50.0, 20);
    shop.addSweet(sweet);
    
    shop.deleteSweet(1001);
    
    System.out.println("Remaining sweets: " + shop.getAllSweets().size());
    
    assertTrue(shop.getAllSweets().isEmpty());
}

}
