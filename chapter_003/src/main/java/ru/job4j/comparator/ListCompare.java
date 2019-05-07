/*
 *  Created by NTolkachev on 07.05.2019.
 */
package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String copyLeft = left;
        String copyRight = right;
        int minLength = (copyLeft.length() < copyRight.length()) ? copyLeft.length() : copyRight.length();
        int result = 0;
        for (int i = 0; i < minLength; i++) {
            Character l = copyLeft.charAt(i);
            Character r = copyRight.charAt(i);
            if (l.compareTo(r) != 0) {
                result = l.compareTo(r);
                break;
            }
        }
        if (result == 0 && copyLeft.length() != copyRight.length()) {
            result = (copyLeft.length() > copyRight.length()) ? 1 : -1;
        }
        return result;
    }
}