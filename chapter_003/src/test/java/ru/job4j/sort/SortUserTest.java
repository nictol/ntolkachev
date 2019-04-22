/*
 *  Created by NTolkachev on 15.03.2019.
 */
package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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
}
