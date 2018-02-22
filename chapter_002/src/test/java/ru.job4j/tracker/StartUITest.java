package ru.job4j.tracker;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"}, new long[]{451});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }


    @Test
    public void whenUserShowAllItem() {
        Tracker tracker = new Tracker();

        Input input = new StubInput(new String[]{"1", "6"}, new long[]{});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {

        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("test name 2", "qaz", 451));

        Input input = new StubInput(new String[]{"2", "test name", "desc", item.getID(), "6"}, new long[]{412});

        new StartUI(input, tracker).init();

        assertThat(tracker.findById(item.getID()).getName(), is("test name"));
    }


    @Test
    public void whenUserDeleteItems() {

        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("test name", "qaz", 451));

        Input input = new StubInput(new String[]{"3", item.getID(), "6"}, new long[]{});

        new StartUI(input, tracker).init();

        assertEquals(tracker.findById(item.getID()), null);
    }

    @Test
    public void whenUserFindById() {

        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("test name", "qaz", 451));

        Input input = new StubInput(new String[]{"4", item.getID(), "6"}, new long[]{});

        new StartUI(input, tracker).init();

        assertThat(tracker.findById(item.getID()).getName(), is("test name"));
    }

    @Test
    public void whenUserFindByName() {

        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("test name", "qaz", 451));

        Input input = new StubInput(new String[]{"5", item.getName(), "6"}, new long[]{});

        new StartUI(input, tracker).init();

        assertThat(tracker.findByName(item.getName())[0].getName(), is("test name"));
    }

}
