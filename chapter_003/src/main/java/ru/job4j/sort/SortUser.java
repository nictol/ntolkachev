/*
 *  Created by NTolkachev on 05.03.2019.
 */
package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortUser {
    public Set<User> sort(List<User> users) {
        SortedSet<User> userSortedSet = new TreeSet<>();
        for (User currentUser : users) {
            userSortedSet.add(currentUser);
        }
        return userSortedSet;
    }
}
