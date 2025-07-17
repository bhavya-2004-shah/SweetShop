package com.example;

import java.util.List;
import java.util.Scanner;

public class SweetShopApp {
    public static void main(String[] args) {
        SweetShop shop = new SweetShop();
        Scanner scanner = new Scanner(System.in);

        // Preloaded sweets
        Sweet sweet1 = new Sweet(1, "Kaju Katli", "Nut-Based", 50.0, 20);
        Sweet sweet2 = new Sweet(2, "Gulab Jamun", "Milk-Based", 30.0, 10);
        shop.addSweet(sweet1);
        shop.addSweet(sweet2);

        while (true) {
            System.out.println("\n===== SWEET SHOP MENU =====");
            System.out.println("1. View all sweets");
            System.out.println("2. Add new sweet");
            System.out.println("3. Delete sweet by ID");
            System.out.println("4. Search sweet by name");
            System.out.println("5. Sort sweets");
            System.out.println("6. Update sweet by ID");
System.out.println("7. Purchase sweet");  


            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    printSweets(shop.getAllSweets());
                    break;

                case 2:
                    System.out.print("Enter sweet ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter sweet name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter sweet category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter sweet price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter sweet quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());

                    Sweet newSweet = new Sweet(id, name, category, price, quantity);
                    shop.addSweet(newSweet);
                    System.out.println("Sweet added successfully!");
                    break;

                case 3:
                    System.out.print("Enter sweet ID to delete: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    shop.deleteSweet(deleteId);
                    System.out.println("Sweet deleted successfully!");
                    break;

                case 4:
                    System.out.print("Enter sweet name to search: ");
                    String nameToSearch = scanner.nextLine();
                    List<Sweet> foundSweets = shop.searchByName(nameToSearch);

                    if (foundSweets.isEmpty()) {
                        System.out.println("No sweets found with the name: " + nameToSearch);
                    } else {
                        System.out.println("Sweet(s) found:");
                        printSweets(foundSweets);
                    }
                    break;

                case 5:
                    System.out.print("Enter sorting criteria (name, category, price, quantity): ");
                    String criteria = scanner.nextLine();
                    System.out.print("Sort ascending? (yes/no): ");
                    boolean ascending = scanner.nextLine().equalsIgnoreCase("yes");

                    List<Sweet> sortedSweets = shop.sortSweets(criteria, ascending);
                    System.out.println("Sweets sorted by " + criteria + ":");
                    printSweets(sortedSweets);
                    break;

                    case 6:
    System.out.print("Enter sweet ID to update: ");
    int updateId = Integer.parseInt(scanner.nextLine());

    System.out.print("Enter new name: ");
    String newName = scanner.nextLine();
    System.out.print("Enter new category: ");
    String newCategory = scanner.nextLine();
    System.out.print("Enter new price: ");
    double newPrice = Double.parseDouble(scanner.nextLine());
    System.out.print("Enter new quantity: ");
    int newQuantity = Integer.parseInt(scanner.nextLine());

    Sweet updatedSweet = new Sweet(updateId, newName, newCategory, newPrice, newQuantity);
    boolean updated = shop.updateSweet(updateId, updatedSweet);

    if (updated) {
        System.out.println("Sweet updated successfully!");
    } else {
        System.out.println("Sweet with ID " + updateId + " not found.");
    }
    break;
    
    case 7:
    System.out.print("Enter sweet ID to purchase: ");
    int purchaseId = Integer.parseInt(scanner.nextLine());

    System.out.print("Enter quantity to purchase: ");
    int purchaseQty = Integer.parseInt(scanner.nextLine());

    boolean purchased = shop.purchaseSweet(purchaseId, purchaseQty);

    if (purchased) {
        System.out.println("Purchase successful!");
    } else {
        System.out.println("Purchase failed.");
    }
    break;



                case 0:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void printSweets(List<Sweet> sweets) {
        if (sweets.isEmpty()) {
            System.out.println("No sweets available.");
            return;
        }

        System.out.println("------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-15s %-10s %-10s\n",
                "ID", "Name", "Category", "Price", "Quantity");
        System.out.println("------------------------------------------------------------");
        for (Sweet s : sweets) {
            System.out.printf("%-10d %-20s %-15s %-10.2f %-10d\n",
                    s.getId(), s.getName(), s.getCategory(), s.getPrice(), s.getQuantity());
        }
    }
}