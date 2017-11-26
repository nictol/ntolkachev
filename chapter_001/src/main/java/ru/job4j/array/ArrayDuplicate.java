package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    String[] remove(String[] array) {
        int first = 0;
        int last = array.length - 1;
        int i = 0, j = 0;

        while (i < last) {
            j = i + 1;
            while (j <= last) {
                if (array[i] == array[j]) {
                    String buf = array[j];
                    array[j] = array[last];
                    array[last] = buf;
                    last--;
                } else {
                    j++;
                }
            }
            i++;
        }

        return  Arrays.copyOf(array, last + 1);

    }
}
