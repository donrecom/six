package com.dom;

import java.util.Scanner;
import java.util.Arrays;

public class SergeyRun { // 1.
    public static void main(String[] args) {
        Invitetion.invite();
        Choice.option();

        System.out.printf("%n  will you continue? (Y/N) %n");
        Scanner ScanOption = new Scanner(System.in); // input by keyboard
        String MyOption = ScanOption.nextLine();    // take a variable
        if (MyOption.matches("[^(n|N)]") == true) main(args); // check - is it continue?
    }
}
/*
        ContinueSR continSR= new ContinueSR();
        if (continSR.continueSR()==true) {main(args);} // recursion
    }
}
class  ContinueSR {
   public boolean continueSR(); {
    System.out.printf("%n  will you continue? (Y/N) %n") ;
    Scanner ScanOption = new Scanner(System.in); // input by keyboard
    String MyOption = ScanOption.nextLine();    // take a variable
       return MyOption.matches("[^(n|N)]");// check - is it continue?
        }
}
*/
class Invitetion { // 2.
    public static void invite() {
        String inv = "Enter the procedure number: %n 1.Sum of numbers, %n 2.Selection of the smallest, %n 3.Checking the word array for palindromicity, %n Other ==> exit. %n";
        System.out.printf("%n" + inv);
    }
}

class Choice { // 3.
    public static void option() {
        Scanner ScanOption = new Scanner(System.in); // input by keyboard
        Short MyOption = ScanOption.nextShort();    // take a variable
        switch (MyOption) {
            case 1:  //  Sum
                Summ Sum = new Summ();
                Sum.sum();
                break;
            case 2:
                Min min0 = new Min();
                System.out.println("Min: " + (String.valueOf(min0.min())));
                break; // наименьшее
            case 3:
                palindrom polin = new palindrom();
                polin.find();
                break; //  палиндромность
            default:
                System.exit(0);
                break;
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
        String masT[] = line.split(" ");   // String Massive select by space
        return (masT);
    }

    public double[] DoubleMassive(String txt) {
        String masT[] = TxtMass(txt);
        double masDouble[] = new double[masT.length];
        for (int i = 0; i < masDouble.length; i++) {
            if (isNumeric(masT[i]) == true) {
                masDouble[i] = Double.parseDouble(masT[i]);//  Str-->Double massive
            } else {
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
        double[] masDouble = inpMass.DoubleMassive(heading);
        double sum = 0;
        for (int i = 0; i < masDouble.length; i++) {
            sum = sum + masDouble[i];
        }
        System.out.println("Sum: " + String.valueOf(sum));
    }
}

class Min { //  7.
    public Double min() {
        InputMassive inpMass = new InputMassive();
        String heading = "Determine the smallest of the entered numbers";
        double[] masDouble = inpMass.DoubleMassive(heading);
        double min0 = masDouble[0]; // first value
        for (int i = 1; i < masDouble.length; i++) { // find minimum in cicle
            if (String.valueOf(masDouble[i]).length()>0 & min0 < masDouble[i]) min0 = masDouble[0];
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
        for (int Word = 0; Word < masT.length; Word++) {           // checking each Word of the Words array
            char[] Letters = masT[Word].toCharArray();
            for (int letter = 0; letter < Letters.length; letter++) { // checking each letter of the Word array
                if (Letters[letter] != Letters[Letters.length - letter - 1]) { // checking each letter of a word element when reading from the beginning and from the end, towards
                    lettersMatch = 0; // if the letters do not match - zeroing and exiting the word
                    break;
                } else {
                    lettersMatch = 1;
                }
                ;
            }
            if (lettersMatch == 1) {
                System.out.print(masT[Word] + " ");
                palyindromeFound = +1;
                lettersMatch = 0;
            }
        }
        System.out.println();
        if (palyindromeFound == 0) System.out.print("NOT FOUND"); //
    }

}