package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> inventory = new ArrayList<>();
        ArrayList<Product> cart = new ArrayList<>();

        boolean programRunning = true;
        while (programRunning) {
            System.out.println("""
                Welcome to some Store
                select an option:
                1.) Display Products
                2.) Display Cart
                3.) Exit """);

            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1 -> {
                    Boolean AjithsStatement = true;
//                    displayAllItems();
                    printAllProducts(inventory);
                }
                case 2 -> {
//                    displayCartItems();
                }
                case 3 -> {
                    System.out.println("Bye");
                }
                default -> System.out.println("Invalid Number");
            }
        }
    }

    private static void printAllProducts(ArrayList<Product> inventory) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("products.csv"));
        bufferedReader.readLine();
        String line;
        while ((line = bufferedReader.readLine()) !=null) {
            Product products = parseProduct(line);
            if (products != null) {
                inventory.add(products);
            }
        }
        for (Product product : inventory) {
            System.out.println(product);
        }
    }

    private static Product parseProduct(String line) {
        String[] parts = line.split("\\|");
        if (parts.length == 4) {
            String sku = parts[0];
            String productName = parts[1];
            double price = Double.parseDouble(parts[2]);
            String department = parts[3];

            return  new Product(sku, productName, (int) price, department);
        } else {
            System.out.println("Invalid");
        }
        return null;
    }
}