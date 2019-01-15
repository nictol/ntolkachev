package ru.job4j.search;

import java.util.ArrayList;
import java.util.Iterator;
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
        int[][] array = new int[rows][cells];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if (cells * i + j < list.size()) {
                    array[i][j] = list.get(cells * i + j);
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }

    /**
     *
     * @param list - лист одномерных массивов
     * @return лист, содержащий все элементы входных массивов
     */
    public List<Integer> convert (List<int[]> list) {
       List<Integer> resultList =  new ArrayList<>();
        for (Iterator<int[]> iter = list.iterator(); iter.hasNext(); ) {
            int[] array = iter.next();
            for (int i = 0; i < array.length; i++) {
                resultList.add(array[i]);
            }

        }
        return resultList;
    }
}
