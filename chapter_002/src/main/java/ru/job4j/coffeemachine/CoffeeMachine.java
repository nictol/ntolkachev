package ru.job4j.coffeemachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {

    List<Integer> change(int value, int price) {

        int[] coins = {10, 5, 2, 1};
        int change = value - price;

        List result = new ArrayList<Integer>();

        for (int theCoin : coins) {

            int amountOfThisCoint = change / theCoin;
            change = change % theCoin;
            for (int i = 0; i < amountOfThisCoint; i++) {
                result.add(theCoin);
            }

        }
        return result;
    }
}