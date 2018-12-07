/*
 *  Created by NTolkachev on 07.12.2018.
 */
package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] arrayRow : array) {
            for (int arrayCell : arrayRow) {
                list.add(arrayCell);
            }
        }
        return list;
    }
}
