package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.putInList(new Task("low", 5));
        queue.putInList(new Task("urgent", 1));
        queue.putInList(new Task("middle", 3));
        Task result = queue.takePriorityTask();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenHigherPrioritySecond() {
        PriorityQueue queue = new PriorityQueue();
        queue.putInList(new Task("urgent_1", 1));
        queue.putInList(new Task("low", 5));
        queue.putInList(new Task("urgent_2", 1));
        queue.putInList(new Task("middle", 3));
        queue.putInList(new Task("urgent_3", 1));
        assertThat(queue.takePriorityTask().getDesc(), is("urgent_1"));
        assertThat(queue.takePriorityTask().getDesc(), is("urgent_2"));
        assertThat(queue.takePriorityTask().getDesc(), is("urgent_3"));
        assertThat(queue.takePriorityTask().getDesc(), is("middle"));
        assertThat(queue.takePriorityTask().getDesc(), is("low"));
    }

    @Test
    public void whenLowPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.putInList(new Task("low", 5));
        Task result = queue.takePriorityTask();
        assertThat(result.getDesc(), is("low"));
    }

    @Test
    public void whenMiddlePriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.putInList(new Task("low", 5));
        queue.putInList(new Task("very-low", 6));
        queue.putInList(new Task("middle", 3));
        Task result = queue.takePriorityTask();
        assertThat(result.getDesc(), is("middle"));
    }

    @Test
    public void whenTwoEqualPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.putInList(new Task("low", 5));
        queue.putInList(new Task("low1", 5));
        queue.putInList(new Task("low2", 5));
        queue.putInList(new Task("middle", 3));
        Task result = queue.takePriorityTask();
        assertThat(result.getDesc(), is("middle"));
    }
}
