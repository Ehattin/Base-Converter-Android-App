package com.example.baseconverteractivity;

import java.util.ArrayList;

public class BaseConverter {
    /*
    This program receives a number and base and returns a string representing the given number
    @param int num - user inputs a number he wants to convert
    @param int base - user inputs a base that he wishes to convert num to
    @returns a String of the calculated number in given base
    */
    public static String convertFrom10(int num, int base) {
        if(base>10)
            return (Integer.toString(num, base));
        ArrayList<Integer> remainder = new ArrayList<>();
        int count = 0;
        String result = "";
        while (num != 0) {
            remainder.add(count, num % base != 0 ? num % base : 0);
            //System.out.println(remainder.toString());
            num /= base;
            try {
                result += remainder.get(count);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return new StringBuffer(result).reverse().toString();
    }
}