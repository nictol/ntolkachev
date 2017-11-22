package ru.job4j.array;

public class BubbleSort {

    public int[] sort(int[] array) {
        int i = 0;
        while (i < array.length - 1) {
            if (array[i] > array[i + 1]) {
                int buf = array[i];
                array[i] = array[i + 1];
                array[i + 1] = buf;
                i = 0;
            } else {
                i++;
            }
        }
        return array;
    }
}
