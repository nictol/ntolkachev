/*
 *  Created by NTolkachev on 26.03.2019.
 */
package ru.job4j.sort;

import java.util.Iterator;
import java.util.Set;

public class UserUtils {

    public static boolean equals(Set<User> set1, Set<User> set2) {
        if (set1 == null || set2 == null) return false;
        if (set1.size() != set2.size()) return false;
        Iterator<User> iter1 = set1.iterator();
        Iterator<User> iter2 = set2.iterator();
        while (iter1.hasNext()) {
            User user1 = iter1.next();
            User user2 = iter2.next();
            if (!user1.equals(user2)) return false;
        }
        return true;
    }
}
