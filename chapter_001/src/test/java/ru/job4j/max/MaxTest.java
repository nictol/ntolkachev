package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenFirstMoreSecond() {
        Max maxim = new Max();
        int result = maxim.max(3, 1);
        assertThat(result, is(3));
    }

    @Test
    public void whenFirstEqualSecond() {
        Max maxim = new Max();
        int result = maxim.max(5, 5);
        assertThat(result, is(5));
    }

    @Test
    public void whetFistIsBiggest() {
        Max maxim = new Max();
        int result = maxim.max(5, 3, 1);
        assertThat(result, is(5));
    }

    @Test
    public void whetSecondIsBiggest() {
        Max maxim = new Max();
        int result = maxim.max(5, 13, 1);
        assertThat(result, is(13));
    }

    @Test
    public void whetThirdIsBiggest() {
        Max maxim = new Max();
        int result = maxim.max(5, 3, 16);
        assertThat(result, is(16));
    }
}
