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


}
