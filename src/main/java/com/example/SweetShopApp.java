package com.example;

public class SweetShopApp {
    public static void main(String[] args) {
        SweetShop shop = new SweetShop();

        Sweet sweet1 = new Sweet(1, "Kaju Katli", "Nut-Based", 50.0, 20);
        Sweet sweet2 = new Sweet(2, "Gulab Jamun", "Milk-Based", 30.0, 10);

        shop.addSweet(sweet1);
        shop.addSweet(sweet2);

        // System.out.println("All sweets in shop:");       
        // System.out.println(shop.getAllSweets());
        System.out.println("All sweets in shop:");
System.out.printf("%-5s %-20s %-20s %-10s %-10s%n", "ID", "Name", "Category", "Price", "Quantity");
for (Sweet sweet : shop.getAllSweets()) {
    System.out.printf(
        "%-5d %-20s %-20s %-10.2f %-10d%n",
        sweet.getId(), sweet.getName(), sweet.getCategory(), sweet.getPrice(), sweet.getQuantity()
    );
}

        shop.deleteSweet(1);

        // System.out.println("After deleting sweet with ID 1:");
        // System.out.println(shop.getAllSweets());
        System.out.println("All sweets in shop:");
System.out.printf("%-5s %-20s %-20s %-10s %-10s%n", "ID", "Name", "Category", "Price", "Quantity");
for (Sweet sweet : shop.getAllSweets()) {
    System.out.printf(
        "%-5d %-20s %-20s %-10.2f %-10d%n",
        sweet.getId(), sweet.getName(), sweet.getCategory(), sweet.getPrice(), sweet.getQuantity()
    );
}

    }
}
