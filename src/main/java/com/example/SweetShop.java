package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


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
    public List<Sweet> searchByName(String name) {
    return sweets.stream()
            .filter(s -> s.getName().equalsIgnoreCase(name))
            .collect(Collectors.toList());
}
public List<Sweet> sortSweets(String criteria, boolean ascending) {
    List<Sweet> sortedList = new ArrayList<>(sweets);

    Comparator<Sweet> comparator;

    switch (criteria.toLowerCase()) {
        case "name":
            comparator = Comparator.comparing(Sweet::getName);
            break;
        case "category":
            comparator = Comparator.comparing(Sweet::getCategory);
            break;
        case "price":
            comparator = Comparator.comparingDouble(Sweet::getPrice);
            break;
        case "quantity":
            comparator = Comparator.comparingInt(Sweet::getQuantity);
            break;
        default:
            System.out.println("Invalid sorting criteria.");
            return sortedList;
    }

    if (!ascending) {
        comparator = comparator.reversed();
    }

    sortedList.sort(comparator);
    return sortedList;
}

public boolean updateSweet(int id, Sweet updatedSweet) {
    for (Sweet sweet : sweets) {
        if (sweet.getId() == id) {
            sweet.setName(updatedSweet.getName());
            sweet.setCategory(updatedSweet.getCategory());
            sweet.setPrice(updatedSweet.getPrice());
            sweet.setQuantity(updatedSweet.getQuantity());
            return true;
        }
    }
    return false; 
}
public boolean purchaseSweet(int id, int quantity) {
    for (Sweet sweet : sweets) {
        if (sweet.getId() == id) {
            if (sweet.getQuantity() >= quantity) {
                sweet.setQuantity(sweet.getQuantity() - quantity);
                return true;
            } else {
                System.out.println("Not enough stock available. Current stock: " + sweet.getQuantity());
                return false;
            }
        }
    }
    System.out.println("Sweet with ID " + id + " not found.");
    return false;
}
public boolean restockSweet(int id, int quantityToAdd) {
    for (Sweet sweet : sweets) {
        if (sweet.getId() == id) {
            sweet.setQuantity(sweet.getQuantity() + quantityToAdd);
            return true;
        }
    }
    System.out.println("Sweet with ID " + id + " not found.");
    return false;
}



}