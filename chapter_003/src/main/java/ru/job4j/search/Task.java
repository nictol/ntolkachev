package ru.job4j.search;

/**
 * Класс для задач
 */
public class Task {
    private String desc;  //Описание задачи
    private int priority; //Приоритет задачи

    /**
     * @param desc     - описание задачи
     * @param priority - приоритет задачи
     */
    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    /**
     * Получить описание задачи
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Получить приоритет задачи
     */
    public int getPriority() {
        return priority;
    }
}