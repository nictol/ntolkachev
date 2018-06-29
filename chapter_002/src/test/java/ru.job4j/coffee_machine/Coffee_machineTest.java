package ru.job4j.coffee_machine;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Coffee_machineTest {

    @Test
    public void testOne() {

        Сoffee_machine machne01 = new Сoffee_machine();
        int[] result = machne01.change(50, 35);
        int[] expexted = new int[10000];
        expexted[0] = 10;
        expexted[1] = 5;

        assertThat(result, is(expexted));
    }

    @Test
    public void testTwo() {

        Сoffee_machine machne01 = new Сoffee_machine();
        int[] result = machne01.change(100, 99);
        int[] expexted = new int[10000];
        expexted[0] = 1;


        assertThat(result, is(expexted));
    }

    @Test
    public void testThree() {

        Сoffee_machine machne01 = new Сoffee_machine();
        int[] result = machne01.change(100, 100);
        int[] expexted = new int[10000];


        assertThat(result, is(expexted));
    }

    @Test
    public void testFour() {

        Сoffee_machine machne01 = new Сoffee_machine();
        int[] result = machne01.change(50, 10);
        int[] expexted = new int[10000];

        for (int i = 0; i < 4; i++) {
            expexted[i] = 10;
        }


        assertThat(result, is(expexted));
    }

    @Test
    public void testFive() {

        Сoffee_machine machne01 = new Сoffee_machine();
        int[] result = machne01.change(50, 0);
        int[] expexted = new int[10000];

        for (int i = 0; i < 5; i++) {
            expexted[i] = 10;
        }

        assertThat(result, is(expexted));
    }
}
