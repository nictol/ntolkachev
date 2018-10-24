package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>(); //Список задач

    /**
     * Метод вставляет задачу в нужную позицию в списке.
     * Позиция определяется по полю приоритет.
     *
     * @param task задача
     */
    public void putInList(Task task) {
        if (this.tasks.peekFirst() == null) {
            this.tasks.add(task);
        } else {
            int index = 0;
            Task currentTask = this.tasks.getFirst();
            while (currentTask.getPriority() < task.getPriority() && tasks.size() > index + 1) {
                index++;
                currentTask = this.tasks.get(index);
            }
            this.tasks.add(index, task);
        }
    }

    /**
     * Получить заявку с наивысшим приоритетом
     */
    public Task takePriorityTast() {
        return this.tasks.poll();
    }
}
