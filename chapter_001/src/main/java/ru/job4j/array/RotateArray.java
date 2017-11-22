package ru.job4j.array;

public class RotateArray {
    public int[][] rotate(int[][] array) {
        int x;
        int n = array.length;
        int p = n / 2;
        for (int i = 0; i < p; i++) {
            for (int j = i; j < n - i - 1; j++) {
                x = array[i][j];
                array[i][j] = array[n - j - 1][i];
                array[n - j - 1][i] = array[n - i - 1][n - j - 1];
                array[n - i - 1][n - j - 1] = array[j][n - i - 1];
                array[j][n - i - 1] = x;
            }
        }
        return array;
    }
}
