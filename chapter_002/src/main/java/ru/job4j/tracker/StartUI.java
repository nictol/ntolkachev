package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */

public class StartUI {

    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {

        MenuTracker mune = new MenuTracker(input, tracker);
        mune.fillActions();
        do {
            mune.show();
            int key = Integer.valueOf(input.ask("Select:"));
            mune.select(key);
        } while (!"y".equals(this.input.ask("Exit?")));
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}