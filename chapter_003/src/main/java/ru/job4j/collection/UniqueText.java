/*
 *  Created by NTolkachev on 24.07.2020.
 */
package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> originalTextWordSet = new HashSet<>(Arrays.asList(origin));
        for (String word : text) {
            if (!originalTextWordSet.contains(word)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
