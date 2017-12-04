package ru.job4j.string;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SubStringTest {

    @Test
    public void whenOriginalStringHaveSub() {
        String original = new String("Пельмени");
        String sub = new String("ме");
        SubString subString = new SubString();
        boolean result = subString.contains(original, sub);
        boolean expexted = true;
        assertThat(result, is(expexted));
    }

    @Test
    public void whenOriginalStringDoNotHaveSub() {
        String original = new String("Пельмени");
        String sub = new String("йцц");
        SubString subString = new SubString();
        boolean result = subString.contains(original, sub);
        boolean expexted = false;
        assertThat(result, is(expexted));
    }

    @Test
    public void whenOriginalStringMoreThanSub() {
        String original = new String("Пельмени");
        String sub = new String("йццййцуйцйцууцуцу");
        SubString subString = new SubString();
        boolean result = subString.contains(original, sub);
        boolean expexted = false;
        assertThat(result, is(expexted));
    }
}
