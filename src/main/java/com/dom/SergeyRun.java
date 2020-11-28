package com.dom;

import java.util.Scanner;

public class SergeyRun { // 1.
    public static void main(String[] args) {
        Invitetion.invite();
        Choice.option();
        ContinueSR continSR = new ContinueSR();
        if (continSR.continueSR()) main(args); // recursion
    }
}

class ContinueSR {
    public boolean continueSR() {
        System.out.printf("%n  will you continue? (Y/N) %n");
        Scanner ScanOption = new Scanner(System.in); // input by keyboard
        String MyOption = ScanOption.nextLine();    // take a variable
        return MyOption.matches("[^(n|N)]");// check - is it continue?
    }
}

class Invitetion { // 2.
    public static void invite() {
        String inv = "Enter the procedure number: %n 1.Sum of numbers, %n 2.Selection of the smallest, %n 3.Checking the word array for palindromicity, %n Other ==> exit. %n";
        System.out.printf("%n" + inv);
    }
}

class Choice { // 3.
    public static void option() {
        Scanner ScanOption = new Scanner(System.in); // input by keyboard
        String MyOption = ScanOption.next();    // take a variable
        switch (MyOption) {
//  Sum
            case "1" -> {
                Summ Sum = new Summ();
                Sum.sum();
            }
// min
            case "2" -> {
                Min min0 = new Min();
                System.out.println("Min: " + (min0.min()));
            }
//  palindroms
            case "3" -> {
                palindrom polin = new palindrom();
                polin.find();
            }
            default -> System.exit(0);
        }
    }
}

class InputMassive {   //  4.

    public String[] TxtMass(String heading) {
        String txtForEnter = "Enter the initial data separated by a space (\" \") : %n";
        System.out.printf("%n" + heading + "%n" + txtForEnter);
        Scanner myVar = new Scanner(System.in); // input by keyboard
        String line = myVar.nextLine();           // take a variable
        while (line.indexOf("  ") > 0) line = line.replace("  ", " ");
        return (line.split(" "));// String Massive select by space
    }

    public double[][] DoubleMassive(String txt) {
        String[] masT = TxtMass(txt);
        double[][] masDouble = new double[masT.length][2];
        for (int i = 0; i < masDouble.length; i++) {
            if (isNumeric(masT[i])) {
                masDouble[i][0] = 1;
                masDouble[i][1] = Double.parseDouble(masT[i]);//  Str-->Double massive
            } else {
                masDouble[i][0] = 0;
                NomberFormatError(masT[i]); // INPUT ERROR MESSAGE (ENTER NUMBER!)
            }
        }
        return (masDouble);
    }

    public boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?"); // check - is it a nomber?
    }

    public void NomberFormatError(String txt) {        // INPUT ERROR MESSAGE (ENTER NUMBER!)
        System.out.println(txt + " - ERROR IN LINE. NON-NUMERICAL VALUE.");
    }
}

class Summ {        // 6.
    public void sum() {
        InputMassive inpMass = new InputMassive();
        String heading = "Determine the sum of the entered numbers";
        double[][] masDouble = inpMass.DoubleMassive(heading);
        double sum = 0;
        for (double[] doubles : masDouble)  sum = sum + doubles[1]; // like: for (int i = 0; i < masDouble.length; i++)
        System.out.println("Sum: " + sum); // like: println("Sum: " + String.valueOf(sum));
    }
}

class Min { //  7.
    public Double min() {
        InputMassive inpMass = new InputMassive();
        String heading = "Determine the smallest of the entered numbers";
        double[][] masDouble = inpMass.DoubleMassive(heading);
        double min0 = 10e100;
        for (double[] doubles : masDouble) { // find minimum in cicle // like: for (int i = 0; i < masDouble.length; i++)
            if (doubles[0] > 0) {
                if (min0 == 10e100) min0 = doubles[1];
                if (min0 > doubles[1]) min0 = doubles[1];
            }
        }
        return min0;
    }
}

class palindrom {
    public void find() {
        InputMassive inpMass = new InputMassive();
        String heading = "Defining palindromes in a string";
        String[] masT = inpMass.TxtMass(heading);
        short lettersMatch = 0;
        short palyindromeFound = 0;
        System.out.printf("%n" + "Palindromes in a line :" + "%n");
        for (String Word : masT) {  // checking each Word of the Words array // like:  for (int Word = 0; Word < masT.length; Word++)
            char[] Letters = Word.toCharArray();
            for (int letter = 0; letter < Letters.length; letter++) { // checking each letter of the Word array
                if (Letters[letter] != Letters[Letters.length - letter - 1]) { // checking each letter of a word element when reading from the beginning and from the end, towards
                    lettersMatch = 0; // if the letters do not match - zeroing and exiting the word
                    break;
                } else {
                    lettersMatch = 1;
                }
            }
            if (lettersMatch == 1) {
                System.out.print(Word + " ");
                palyindromeFound = +1;
                lettersMatch = 0;
            }
        }
        System.out.println();
        if (palyindromeFound == 0) System.out.print("NOT FOUND"); //
    }

}