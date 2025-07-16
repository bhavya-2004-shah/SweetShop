package com.example;

import java.util.ArrayList;
import java.util.List;


public class SweetShop {
    private List<Sweet> sweets;

    public SweetShop() {
        this.sweets = new ArrayList<>();
    }

    public void addSweet(Sweet sweet) {
        sweets.add(sweet);
    }

    public List<Sweet> getAllSweets() {
        return sweets;
    }
    public void deleteSweet(int id) {
    sweets.removeIf(s -> s.getId() == id);
    }
}
