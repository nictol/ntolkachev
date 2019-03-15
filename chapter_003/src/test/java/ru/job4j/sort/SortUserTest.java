/*
 *  Created by NTolkachev on 15.03.2019.
 */
package ru.job4j.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    @Test
    public void Test1() {

        TreeSet<User> testSortedUserSet = new TreeSet<>();
        testSortedUserSet.add(new User(19, "Валентин"));
        testSortedUserSet.add(new User(25, "Антон"));
        testSortedUserSet.add(new User(48, "Никита"));
        testSortedUserSet.add(new User(18, "Юрий"));
        //Set<User> expectedSet = new


    }
}
