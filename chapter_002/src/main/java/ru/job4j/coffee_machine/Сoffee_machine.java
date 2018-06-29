package ru.job4j.coffee_machine;

public class Сoffee_machine {

    int[] change(int value, int price) {

        int change = value - price;

        int tens = change / 10;
        change = change % 10;

        int fives = change / 5;
        change = change % 5;

        int two = change / 2;
        change = change % 2;

        int one = change;

        int i = 0;
        int[] result = new int[10000];


        if (tens != 0) {
            for (int j = 0; j < tens; j++) {
                result[i] = 10;
                i++;
            }
        }

        if (fives != 0) {
            for (int j = 0; j < fives; j++) {
                result[i] = 5;
                i++;
            }
        }

        if (two != 0) {
            for (int j = 0; j < two; j++) {
                result[i] = 2;
                i++;
            }
        }

        if (one != 0) {
            for (int j = 0; j < one; j++) {
                result[i] = 1;
                i++;
            }
        }

        return result;

    }
}
