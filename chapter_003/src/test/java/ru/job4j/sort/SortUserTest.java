/*
 *  Created by NTolkachev on 15.03.2019.
 */
package ru.job4j.sort;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

public class SortUserTest {

    @Test
    public void Test1() {
        List<User> listUsers = new ArrayList<>();
        listUsers.add(new User(18, "Юрий"));
        listUsers.add(new User(18, "Олег"));
        listUsers.add(new User(19, "Валентин"));
        listUsers.add(new User(25, "Антон"));
        listUsers.add(new User(48, "Никита"));
        SortUser sortUser = new SortUser();
        Set<User> resultSet = sortUser.sort(listUsers);
        TreeSet<User> expectedSet = new TreeSet<>();
        expectedSet.add(new User(19, "Валентин"));
        expectedSet.add(new User(25, "Антон"));
        expectedSet.add(new User(48, "Никита"));
        expectedSet.add(new User(18, "Юрий"));
        expectedSet.add(new User(18, "Олег"));
        assertThat(UserUtils.equals(expectedSet, resultSet), is(true));

    }

    @Test
    public void Test2() {
        List<User> listUsers = new ArrayList<>();
        listUsers.add(new User(18, "Юрий"));
        listUsers.add(new User(18, "Олег"));
        listUsers.add(new User(19, "Валентин"));
        listUsers.add(new User(25, "Антон"));
        listUsers.add(new User(48, "Никита"));
        SortUser sortUser = new SortUser();
        List<User> sortedUserList = new ArrayList<>();
        sortedUserList = sortUser.sortNameLength(listUsers);
        int prevLength = -1, currentLength;
        boolean isSorted = true;
        for (Iterator<User> userIterator = sortedUserList.iterator(); userIterator.hasNext(); ) {
            currentLength = userIterator.next().getName().length();
            if (prevLength > currentLength) isSorted = false;
            prevLength = currentLength;
        }
        assertTrue(isSorted);
    }


    @Test
    public void Test3() {
        List<User> listUsers = new ArrayList<>();
        listUsers.add(new User(18, "Юрий"));
        listUsers.add(new User(18, "Олег"));
        listUsers.add(new User(85, "Олег"));
        listUsers.add(new User(19, "Валентин"));
        listUsers.add(new User(25, "Антон"));
        listUsers.add(new User(48, "Никита"));
        listUsers.add(new User(25, "Никита"));
        SortUser sortUser = new SortUser();
        List<User> sortedUserList = new ArrayList<>();
        sortedUserList = sortUser.sortByAllFields(listUsers);
        User prevUser = null, currentUser;
        boolean isSorted = true;
        for (Iterator<User> userIterator = sortedUserList.iterator(); userIterator.hasNext(); ) {
            currentUser = userIterator.next();
            if (prevUser != null) {
                if (prevUser.getName().compareTo(currentUser.getName()) == 1) isSorted = false;
                else if (prevUser.getName().compareTo(currentUser.getName()) == 0) {
                    if (prevUser.getAge() > currentUser.getAge()) isSorted = false;
                }
            }
            prevUser = currentUser;
        }
        assertTrue(isSorted);
    }
}
