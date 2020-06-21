/*
 *  Created by NTolkachev on 21.06.2020.
 */
package ru.job4j.collections;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public static HashSet<String> extractNumber(List<Task> tasks) {
        HashSet<String> numbers = new HashSet<>();
        for (Task task : tasks) {
            numbers.add(task.getNumber());
        }
        return numbers;
    }
}
