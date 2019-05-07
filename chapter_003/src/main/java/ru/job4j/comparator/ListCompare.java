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
        int result = 0;
        if (copyLeft.length() > copyRight.length()) {
            for (int i = 0; i < copyLeft.length() - copyRight.length(); i++) copyRight = copyRight.concat(" ");
        } else {
            for (int i = 0; i < copyRight.length() - copyLeft.length(); i++) copyLeft = copyLeft.concat(" ");
        }
        for (int i = 0; i < copyLeft.length(); i++) {
            Character l = copyLeft.charAt(i);
            Character r = copyRight.charAt(i);
            if (l.compareTo(r) != 0) {
                result = l.compareTo(r);
                break;
            }
        }
        return result;
    }
}