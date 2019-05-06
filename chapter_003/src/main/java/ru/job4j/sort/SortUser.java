/*
 *  Created by NTolkachev on 05.03.2019.
 */
package ru.job4j.sort;

import java.util.*;

public class SortUser {
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    public List<User> sortByAllFields(List<User> users) {
        List<User> userList = new ArrayList<>(users);
        userList.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int result;
                        if (o1.getName().compareTo(o2.getName()) != 0) {
                            result = o1.getName().compareTo(o2.getName());
                        } else {
                            if (o1.getAge() == o2.getAge()) result = 0;
                            else result = o1.getAge() > o2.getAge() ? 1 : -1;
                        }
                        return result;
                    }
                }
        );
        return userList;
    }

    public List<User> sortNameLength(List<User> users) {
        List<User> userList = new ArrayList<>(users);
        userList.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int result;
                        if (o1.getName().length() == o2.getName().length()) result = 0;
                        else result = o1.getName().length() > o2.getName().length() ? 1 : -1;
                        return result;
                    }
                }
        );
        return userList;
    }
}
