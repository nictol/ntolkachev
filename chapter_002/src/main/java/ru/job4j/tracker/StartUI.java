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

    private int[] range = new int[]{0, 1, 2, 3, 4, 5};


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
            mune.select(input.ask("Select:", range));
        } while (!"y".equals(this.input.ask("Exit?")));
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}