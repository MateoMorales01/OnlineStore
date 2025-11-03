package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Welcome to some Store
                select an option:
                1.) Display Products
                2.) Display Cart
                3.) Exit """);

        int userChoice = scanner.nextInt();
        scanner.nextLine();

        boolean mainRunning = true;
        while (mainRunning) {
            switch (userChoice) {
                case 1 -> {
//                    displayAllItems();
                    BufferedReader bufferedReader = new BufferedReader(new FileReader("product.csv"));
                }
                case 2 -> {
//                    displayCartItems();
                }
                case 3 -> {
                    mainRunning = false;
                }
                default -> System.out.println("Invalid Answer");
            }
        }
    }
}