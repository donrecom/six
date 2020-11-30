package com.dom;

public class Palindrom {
        public static void find() {
            String heading = "Defining palindromes in a string";
            String[] masT = ArrayInput.TxtMass(heading);
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
