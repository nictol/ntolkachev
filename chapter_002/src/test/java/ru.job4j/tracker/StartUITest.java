package ru.job4j.tracker;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"}, new long[]{451});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }


    @Test
    public void whenUserShowAllItem() {
        Tracker tracker = new Tracker();     // создаём Tracker

        Input input = new StubInput(new String[]{"1", "6"}, new long[]{});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name 2", "qaz", 451));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"2", "test name", "desc", item.getID(), "6"}, new long[]{412});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getID()).getName(), is("test name"));
    }


    @Test
    public void whenUserDeleteItems() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "qaz", 451));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"3", item.getID(), "6"}, new long[]{});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertEquals(tracker.findById(item.getID()), null);
    }

    @Test
    public void whenUserFindById() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "qaz", 451));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"4", item.getID(), "6"}, new long[]{});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getID()).getName(), is("test name"));
    }

    @Test
    public void whenUserFindByName() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "qaz", 451));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"5", item.getName(), "6"}, new long[]{});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findByName(item.getName())[0].getName(), is("test name"));
    }

}
