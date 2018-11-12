package ru.job4j.search;

import java.util.List;

/**
 * Класс для конвертации List в двумерный массив
 */
public class ConvertList2Array {
    /**
     * @param list - List для конвертации
     * @param rows - Шаг разбиения List
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[cells][rows];
        for (int i = 0; i < cells; i++) {
            for (int j = 0; j < rows; j++) {
                if (cells * i + j < list.size()) {
                    array[i][j] = list.get(rows * i + j);
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }
}
