package com.dom;

import java.util.Scanner;

public class ArrayInput {
    public static String[] TxtMass(String heading) {
        String txtForEnter = "Enter the initial data separated by a space (\" \") : %n";
        System.out.printf("%n" + heading + "%n" + txtForEnter);
        Scanner myVar = new Scanner(System.in); // input by keyboard
        String line = myVar.nextLine();           // take a variable
        while (line.indexOf("  ") > 0) line = line.replace("  ", " ");
        return (line.split(" "));// String Massive select by space
    }

    public static double[][] DoubleMassive(String txt) {
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

    public static boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?"); // check - is it a nomber?
    }

    public static void NomberFormatError(String txt) {        // INPUT ERROR MESSAGE (ENTER NUMBER!)
        System.out.println(txt + " - ERROR IN LINE. NON-NUMERICAL VALUE.");
    }
}
}
