package com.dom;

import java.util.Scanner;

public class SergeyRun { // 1.
    public static void main(String[] args) {
        invite();
        option();
        if (continueSR()) main(args); // recursion
    }

    public static void invite() {
        String inv = "Enter the procedure number: %n 1.Sum of numbers, %n 2.Selection of the smallest, %n 3.Checking the word array for palindromicity, %n Other ==> exit. %n";
        System.out.printf("%n" + inv);
    }

    public static void option() {
        Scanner ScanOption = new Scanner(System.in); // input by keyboard
        String MyOption = ScanOption.next();    // take a variable
        switch (MyOption) {
            case "1" -> Sum.sum();
            case "2" -> System.out.println("Min: " + (Min.min()));
            case "3" -> Palindrom.find();
            default -> System.exit(0);
        }
    }

    public static boolean continueSR() {
        System.out.printf("%n  will you continue? (Y/N) %n");
        Scanner ScanOption = new Scanner(System.in); // input by keyboard
        String MyOption = ScanOption.nextLine();    // take a variable
        return MyOption.matches("[^(n|N)]");// check - is it continue?
    }
}

