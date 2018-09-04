package ru.job4j.coffee_machine;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeeMachineTest {

    @Test
    public void testOne() {

        CoffeeMachine machne01 = new CoffeeMachine();
        List result = machne01.change(50, 35);
        List expexted = new ArrayList<Integer>();
        expexted.add(10);
        expexted.add(5);
        assertThat(result, is(expexted));
    }

    @Test
    public void testTwo() {

        CoffeeMachine machne01 = new CoffeeMachine();
        List result = machne01.change(100, 99);
        List expexted = new ArrayList<Integer>();
        expexted.add(1);


        assertThat(result, is(expexted));
    }

    @Test
    public void testThree() {

        CoffeeMachine machne01 = new CoffeeMachine();
        List result = machne01.change(100, 100);
        List expexted = new ArrayList<Integer>();


        assertThat(result, is(expexted));
    }

    @Test
    public void testFour() {

        CoffeeMachine machne01 = new CoffeeMachine();
        List result = machne01.change(50, 10);
        List expexted = new ArrayList<Integer>();

        for (int i = 0; i < 4; i++) {
            expexted.add(10);
        }


        assertThat(result, is(expexted));
    }

    @Test
    public void testFive() {

        CoffeeMachine machne01 = new CoffeeMachine();
        List result = machne01.change(50, 0);
        List expexted = new ArrayList<Integer>();

        for (int i = 0; i < 5; i++) {
            expexted.add(10);
        }

        assertThat(result, is(expexted));
    }
}