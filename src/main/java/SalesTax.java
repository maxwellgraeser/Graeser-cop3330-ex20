/*
 *  UCF COP3330 Fall 2021 Exercise 20 Solution
 *  Copyright 2021 Maxwell Graeser
 */

import java.util.Scanner;
public class SalesTax {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Whats the order amount? ");
        String order = scan.nextLine();
        System.out.print("What is the state? ");
        String state = scan.nextLine();

        double subtotal = Double.parseDouble(order);
        String output = String.format("The total is $%.2f", subtotal);
        if (!state.equals("Wisconsin") && !state.equals("Illinois"))
            subtotal = Math.round(subtotal * 100.0) / 100.0;
        double tax;

        if (state.equals("Wisconsin")) {
            tax = subtotal * .05;
            System.out.print("What is the county? ");
            String county = scan.nextLine();
            if (county.equals("Dunn")) {
                tax += subtotal * .004;
            }
            if (county.equals("Eau Claire")) {
                tax += subtotal * .005;
            }
            double total = subtotal + tax;
            subtotal = Math.round(subtotal * 100.0) / 100.0;
            tax = Math.round(tax * 100.0) / 100.0;
            total = Math.round(total * 100.0) / 100.0;
            output = String.format("The subtotal is $%.2f\nThe tax is $%.2f\nThe total is $%.2f", subtotal, tax, total);
        }
        if (state.equals("Illinois")) {
            tax = subtotal * .08;
            double total = subtotal + tax;
            subtotal = Math.round(subtotal * 100.0) / 100.0;
            tax = Math.round(tax * 100.0) / 100.0;
            total = Math.round(total * 100.0) / 100.0;
            output = String.format("The subtotal is $%.2f\nThe tax is $%.2f\nThe total is $%.2f", subtotal, tax, total);
        }

        System.out.println(output);
    }
}