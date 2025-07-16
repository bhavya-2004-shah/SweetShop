package com.example;

import java.util.List;
import java.util.Scanner;

public class SweetShopApp {
    public static void main(String[] args) {
        SweetShop shop = new SweetShop();
             Scanner scanner = new Scanner(System.in); 

        Sweet sweet1 = new Sweet(1, "Kaju Katli", "Nut-Based", 50.0, 20);
        Sweet sweet2 = new Sweet(2, "Gulab Jamun", "Milk-Based", 30.0, 10);

        shop.addSweet(sweet1);
        shop.addSweet(sweet2);

  // table format display logic
        System.out.println("All sweets in shop:");
System.out.printf("%-5s %-20s %-20s %-10s %-10s%n", "ID", "Name", "Category", "Price", "Quantity");
for (Sweet sweet : shop.getAllSweets()) {
    System.out.printf(
        "%-5d %-20s %-20s %-10.2f %-10d%n",
        sweet.getId(), sweet.getName(), sweet.getCategory(), sweet.getPrice(), sweet.getQuantity()
    );
}

        shop.deleteSweet(1);

     // table format print logic 
        System.out.println("All sweets in shop:");
System.out.printf("%-5s %-20s %-20s %-10s %-10s%n", "ID", "Name", "Category", "Price", "Quantity");
for (Sweet sweet : shop.getAllSweets()) {
    System.out.printf(
        "%-5d %-20s %-20s %-10.2f %-10d%n",
        sweet.getId(), sweet.getName(), sweet.getCategory(), sweet.getPrice(), sweet.getQuantity()
    );
}


// search logic 
System.out.println("\nEnter sweet name to search:");
String nameToSearch = scanner.nextLine();
List<Sweet> foundSweets = shop.searchByName(nameToSearch);

if (foundSweets.isEmpty()) {
    System.out.println("No sweets found with the name: " + nameToSearch);
} else {
    System.out.println("Sweet(s) found:");
    System.out.println("------------------------------------------------------------");
    System.out.printf("%-10s %-20s %-15s %-10s %-10s\n",
            "ID", "Name", "Category", "Price", "Quantity");
    System.out.println("------------------------------------------------------------");
    for (Sweet s : foundSweets) {
        System.out.printf("%-10d %-20s %-15s %-10.2f %-10d\n",
                s.getId(), s.getName(), s.getCategory(), s.getPrice(), s.getQuantity());
    }
}


    }
}
