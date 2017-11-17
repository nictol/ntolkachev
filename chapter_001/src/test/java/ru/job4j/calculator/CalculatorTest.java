package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenAddOneSubOneThenTwo() {
        Calculator calc = new Calculator();
        calc.subtract(8D, 4D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenAddOneMulOneThenTwo() {
        Calculator calc = new Calculator();
        calc.multiple(2D, 5D);
        double result = calc.getResult();
        double expected = 10D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenAddDivPlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.div(10D, 5D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
}