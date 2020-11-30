package com.dom;

public class Min {

        public static Double min() {
            String heading = "Determine the smallest of the entered numbers";
            double[][] masDouble = ArrayInput.DoubleMassive(heading);
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


