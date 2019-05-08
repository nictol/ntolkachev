/*
 *  Created by NTolkachev on 07.12.2018.
 */
package ru.job4j.list;

import org.junit.Test;
import ru.job4j.search.ConvertList2Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ListTest {
    @Test
    public void firstTest() {
        ConvertList2Array listConverter = new ConvertList2Array();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        List<Integer> result = listConverter.convert(list);
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expect));
    }
}