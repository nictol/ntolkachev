package ru.job4j.search;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when8ElementsThen8() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8),
                4
        );
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when5ElementsThen6() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5),
                6
        );
        int[][] expect = {{1}, {2}, {3}, {4}, {5}, {0}};
        assertThat(result, is(expect));
    }

    @Test
    public void when7Elements9RowsThen1x9MatrixWith2ZeroElement() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                9
        );
        int[][] expect = {{1}, {2}, {3}, {4}, {5}, {6}, {7}, {0}, {0}};
        assertThat(result, is(expect));
    }
}