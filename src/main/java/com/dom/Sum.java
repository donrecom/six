package com.dom;

public class Sum {
    public static void sum() {
        String heading = "Determine the sum of the entered numbers";
        double[][] masDouble = ArrayInput.DoubleMassive(heading);
        double sum = 0;
        for (double[] doubles : masDouble) sum = sum + doubles[1]; // like: for (int i = 0; i < masDouble.length; i++)
        System.out.println("Sum: " + sum); // like: println("Sum: " + String.valueOf(sum));
    }
}

