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
        ArrayList<Product> inventory = loadAllProducts();
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
                    boolean displayMenuRunning = true;
                    while (displayMenuRunning) {
                        System.out.println("""
                                Select an Option:
                                1. Search for a product
                                2. Add a product to cart
                                3. Go back to Store Menu
                                """);
                        int userDisplayChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (userDisplayChoice) {
                            case 1 -> {
                                //printSearchProduct();
                                System.out.println("Enter search keyword");
                                String searchKeyWord = scanner.nextLine().trim().toLowerCase();

                                ArrayList<Product> results = new ArrayList<>();
                                for (Product product : inventory) {
                                    if (product.getProductName().trim().toLowerCase().contains(searchKeyWord)) {
                                        results.add(product);
                                    }
                                }
                                printProducts(results);
                            }
                            case 2 -> {
                                //addToCart();
                            }
                            case 3 -> {
                                displayMenuRunning = false;
                            }
                        }
                    }
                }
                case 2 -> {
//                    displayCartItems();
                }
                case 3 -> {
                    System.out.println("Bye");
                    programRunning = false;
                }
                default -> System.out.println("Invalid Number");
            }
        }
    }

    private static ArrayList<Product> loadAllProducts() throws IOException {
        ArrayList<Product> products = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("products.csv"));
        bufferedReader.readLine();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            Product product = parseProduct(line);
            if (product != null) {
                products.add(product);
            }
        }
        return products;
    }

    private static void printProducts(ArrayList<Product> products) throws IOException {
        if (products.isEmpty()) {
            System.out.println("No Products found");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    private static Product parseProduct(String line) {
        String[] parts = line.split("\\|");
        if (parts.length == 4) {
            String sku = parts[0];
            String productName = parts[1];
            double price = Double.parseDouble(parts[2]);
            String department = parts[3];

            return new Product(sku, productName, (int) price, department);
        } else {
            System.out.println("Invalid");
        }
        return null;
    }
}