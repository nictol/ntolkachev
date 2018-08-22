package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {

        if (this.tasks.peekFirst() == null) {
            this.tasks.add(task);
        } else {
            int index = 0;
            Task currentTask = this.tasks.getFirst();
            while (currentTask.getPriority() < task.getPriority() && tasks.size()>index+1) {
                index++;
                currentTask = this.tasks.get(index);
            }

            this.tasks.add(index, task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
