package ru.job4j.encapsulation;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        Item itemReplace = new Item("test2", "testDescription", 123L);
        itemReplace.setId(item.getID());
        tracker.replace(item.getID(), itemReplace);
        assertThat(tracker.findAll()[0].getName(), is(itemReplace.getName()));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 123L);
        Item item3 = new Item("test3", "testDescription", 123L);
        Item item4 = new Item("test4", "testDescription", 123L);
        Item item5 = new Item("test5", "testDescription", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        tracker.delete(item3.getID());

        assertThat(tracker.findAll()[0].getName(), is(item1.getName()));
        assertThat(tracker.findAll()[1].getName(), is(item2.getName()));
        assertThat(tracker.findAll()[2].getName(), is(item4.getName()));
        assertThat(tracker.findAll()[3].getName(), is(item5.getName()));
    }

    @Test
    public void whenFindAllElements() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 123L);
        Item item3 = new Item("test3", "testDescription", 123L);
        Item item4 = new Item("test4", "testDescription", 123L);
        Item item5 = new Item("test5", "testDescription", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        assertThat(tracker.findAll()[0].getName(), is(item1.getName()));
        assertThat(tracker.findAll()[1].getName(), is(item2.getName()));
        assertThat(tracker.findAll()[2].getName(), is(item3.getName()));
        assertThat(tracker.findAll()[3].getName(), is(item4.getName()));
        assertThat(tracker.findAll()[4].getName(), is(item5.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getID());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getID(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getID()).getName(), is("test2"));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        tracker.add(item1);
        Item result = tracker.findById(item1.getID());
        assertThat(result.getID(), is(item1.getID()));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        tracker.add(item1);
        Item[] result = tracker.findByName("test1");
        assertThat(result[0].getName(), is("test1"));
    }
}
