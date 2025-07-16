package com.example;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

public class SweetShopTest {
//for add 
    @Test
    public void testAddSweet() {
        SweetShop shop = new SweetShop();
        Sweet sweet = new Sweet(1, "Kaju Katli", "Nut-Based", 50.0, 20);

        shop.addSweet(sweet);

        List<Sweet> sweets = shop.getAllSweets();

        assertEquals(1, sweets.size());
        assertEquals("Kaju Katli", sweets.get(0).getName());
    }

// for delete
    @Test
public void testDeleteSweet() {
    SweetShop shop = new SweetShop();
    Sweet sweet = new Sweet(1001, "Kaju Katli", "Nut-Based", 50.0, 20);
    shop.addSweet(sweet);
    
    shop.deleteSweet(1001);
    
    System.out.println("Remaining sweets: " + shop.getAllSweets().size());
    
    assertTrue(shop.getAllSweets().isEmpty());
}

/// for search 
@Test
public void testSearchByName_Found() {
    SweetShop shop = new SweetShop();

    Sweet sweet1 = new Sweet(1, "Kaju Katli", "Nut-Based", 50.0, 20);
    Sweet sweet2 = new Sweet(2, "Gulab Jamun", "Milk-Based", 10.0, 50);
    shop.addSweet(sweet1);
    shop.addSweet(sweet2);

    List<Sweet> result = shop.searchByName("Kaju Katli");
    assertEquals(1, result.size());
    assertEquals("Kaju Katli", result.get(0).getName());
}

@Test
public void testSearchByName_NotFound() {
    SweetShop shop = new SweetShop();
    shop.addSweet(new Sweet(1, "Kaju Katli", "Nut-Based", 50.0, 20));

    List<Sweet> result = shop.searchByName("Rasgulla");
    assertEquals(0, result.size());
}


}
