package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FactorialTest {
  @Test
  public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
    Factorial factorial = new Factorial();
    int result = factorial.calc(5);
    int expected = 120;
    assertThat(result, is(expected));
  }

  @Test
  public void whenCalculateFactorialForZeroThenOne() {
    Factorial factorial = new Factorial();
    int result = factorial.calc(0);
    int expected = 1;
    assertThat(result, is(expected));
  }
}