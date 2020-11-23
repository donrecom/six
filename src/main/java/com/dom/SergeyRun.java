package com.dom;

// import java.lang.reflect.Array;
 import java.util.Scanner;
 import java.util.Arrays;
// import java.util.Formatter;

public class SergeyRun {  // 1.    -------------------- ВЫБОР НУЖНОЙ ПРОЦЕДУРЫ ИЗ 3Х -----------------------
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Выберите номер процедуры: 1.Сумма чисел, 2.Выбор наименьшего, 3.Проверка массива слова на палиндромность, другое ==> выход.");
        Scanner Pr=new Scanner(System.in); // ввод с клавы
        Short pr = Pr.nextShort();              // берем переменную
        SergeyRun sr = new SergeyRun();
        switch (pr){
            case 1: System.out.println("Сумма: "+sr.add());  break; //Сумма
            case 2: sr.read_(); break; // наименьшее
            case 3: sr.polindrom1(); break; //  палиндромность
            default: System. exit(0); break;
        }
        main(args); // рекурсия
    }

    public  String [] enterMass(String t) { //  ----- 0 - ВВОД МАССИВА (СТРОКИ ДАННЫХ) ----------------
        System.out.println();
        System.out.println(t);
        System.out.println();
        System.out.println("Введите исходные данные через пробел (\" \") :");
        Scanner myVar = new Scanner(System.in); // ввод с клавы
        String s = myVar.nextLine();              // берем переменную
        String masT[] = s.split(" ");               // Str массив выделим по пробелу
        return masT;
    }

    public float add() { // ---- 1Я ПРОЦЕДУРА --------------
        String t="Определяем сумму введенных чисел";
        String masT[]=enterMass(t);
        float masF[] = new float[masT.length];                      // пустой Float массив по величине Str массива
        float sum_=0;
        for (int i = 0; i < masF.length; i++){
            {try {masF[i] = Float.parseFloat(masT[i]);} catch(NumberFormatException e) {er(masT[i]);}}
             sum_=sum_+masF[i];}// перевели Str-->Float, суммируем
        return sum_;
    }

    public void read_() { // ------------- 2Я ПРОЦЕДУРА --------------------------------------------------
        String t = "Определяем наименьшее из введенных чисел";
        int k=-1; // метка для ошибки ввода
        String masT[] = enterMass(t);
        float masF[] = new float[masT.length];                      // пустой Float массив по величине Str массива
        try {
        for (int i = 0; i < masF.length; i++)
        { k=i; masF[i] = Float.parseFloat(masT[i]);}// перевели Str-->Float
        Arrays.sort(masF);                                                 // сортировка
        String s = Float.toString(masF[0]);                               // первое- минимальное при сортировке, формат результата с "." или без
        if (masF[0] == Math.round(masF[0])) {s = Integer.toString((int) masF[0]);} else {s = Float.toString(masF[0]);};
        prnt("Минимальное число в массиве : ", s," ", "====="); // декоратор
        }catch(NumberFormatException e) {er(masT[k]);} // при шибке ввода
    }

    public void polindrom1() { // ------------- 3Я ПРОЦЕДУРА --------------------------------------------------
        String t = "Определяем палиндромы в строке";
        String masT[] = enterMass(t); // ввели массив слов в строку
        short k1 = 0; short k2 = 0; // метки - при найденом полиндроме =1
        prnt("Палиндромы в строке ", "","", ""); //         декоратор
        for (int i = 0; i < masT.length; i++) {  // проверка каждого элемента массива
            char[] p = masT[i].toCharArray();
            for (int i0 = 0; i0 < p.length; i0++) {
                if (p[i0] != p[p.length - i0 - 1]) { // проверка каждой буквы слова эемента при встречном чтении
                    k2 = 0; // при несовпадении букв - обнул и выход из слова
                    break;
                } else {
                    k2 = 1;
                };
            }
            if (k2 == 1) {
                System.out.println(masT[i]); k1 =+ 1; // вывели полиндром, метка - найден
                k2 = 0;
                }
        }
        if (k1 == 0) System.out.println("не обнаружены".toUpperCase()); // если таких нет в строке
    }

    public void er(String t) // --------- СООБЩЕНИЕ ОШИБКИ ВВОДА (ВВЕЛИ НЕ ЧИСЛО!) -----------------
    {System.out.println(t+" - ОШИБКА В СТРОКЕ. НЕЧИСЛОВОЕ ЗНАЧЕНИЕ.");}

    public void prnt (String a, String b,String d, String f ){  // ------- ДЕКОРАТОР ----------
        String c=d.repeat(a.length())+f;
        System.out.println(c);
        System.out.println(a.toUpperCase()+b);
        System.out.println(c);
    }
    }