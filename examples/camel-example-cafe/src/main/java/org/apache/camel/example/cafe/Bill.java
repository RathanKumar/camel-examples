package org.apache.camel.example.cafe;

import java.util.List;

public class Bill {
    final double TAX = 18; // percent

    private double price = 0;
    private double taxPrice = 0;
    private double total = 0;

    public Bill(List<Drink> drinks) {
        price = drinks.stream().map(drink -> drink.price).reduce(price, (a, b) -> a + b);
        taxPrice = (TAX /100) * price;
        total = price + taxPrice;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Price: "+ this.price + "\n");
        buffer.append("Tax: "+ this.taxPrice + "\n");
        buffer.append("Total: "+ this.total + "\n");
        return buffer.toString();
    }

}
