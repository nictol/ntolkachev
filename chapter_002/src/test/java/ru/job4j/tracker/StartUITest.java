package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class StartUITest {

    private final PrintStream stdout = System.out;

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"}, new long[]{451});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name 2", "qaz", 451));
        Input input = new StubInput(new String[]{"2", "test name", "desc", item.getID(), "y"}, new long[]{412});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName("test name").get(0).getName(), is("test name"));
    }


    @Test
    public void whenUserDeleteItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "qaz", 451));
        Input input = new StubInput(new String[]{"3", item.getID(), "y"}, new long[]{});
        new StartUI(input, tracker).init();
        assertEquals(tracker.findById(item.getID()), null);
    }

    @Test
    public void whenUserFindById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "qaz", 451));
        Input input = new StubInput(new String[]{"4", item.getID(), "y"}, new long[]{});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getID()).getName(), is("test name"));
    }

    @Test
    public void whenUserFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "qaz", 451));
        Input input = new StubInput(new String[]{"5", item.getName(), "y"}, new long[]{});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName()).get(0).getName(), is("test name"));
    }


    @Test
    public void whenShowAllItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "qaz", 451));
        Input input = new StubInput(new String[]{"1", "y"}, new long[]{});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("0 : Add the new item\r\n")
                                .append("1 : Show all items\r\n")
                                .append("2 : Edit item\r\n")
                                .append("3 : Delete item\r\n")
                                .append("4 : Find item by Id\r\n")
                                .append("5 : Find item by Name\r\n")
                                .append("test name\r\n")
                                .toString()
                )
        );
    }
}
