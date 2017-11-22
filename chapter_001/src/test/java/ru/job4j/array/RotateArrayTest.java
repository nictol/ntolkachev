package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RotateArrayTest {
    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        //напишите здесь тест, проверяющий поворот массива размером 2 на 2.
        RotateArray rotateArray = new RotateArray();
        int[][] array = {
                {2, 5},
                {3, 6}
        };
        int[][] result = rotateArray.rotate(array);
        int[][] expected = {
                {3, 2},
                {6, 5}
        };
        assertThat(result, is(expected));
    }

    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        RotateArray rotateArray = new RotateArray();
        int[][] array = {
                {2, 5, 8},
                {3, 6, 7},
                {0, 6, 3}
        };
        int[][] result = rotateArray.rotate(array);
        int[][] expected = {
                {0, 3, 2},
                {6, 6, 5},
                {3, 7, 8}
        };
        assertThat(result, is(expected));
    }
}
