package ru.job4j.loop;

public class Factorial {

    public int calc(int n) {
        int res = 1;
        if (n == 0) return res;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}
