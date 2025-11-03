package com.pluralsight;

public class Product {
    private String sku;
    private String productName;
    private double price;
    private String department;

    public Product(String sku, String productName, double price, String department) {
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("""
                Product Name: %s
                SKU: %s
                Price: %.2f
                Department: %s
                """,productName, sku, price, department);
    }
}
