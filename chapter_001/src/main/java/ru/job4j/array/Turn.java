package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        int i = 0;
        int j = array.length - 1;
        while (i <= j) {
            int buf = array[i];
            array[i] = array[j];
            array[j] = buf;
            i++;
            j--;
        }
        return array;

    }
}
