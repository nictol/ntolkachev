package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */

public class StartUI {

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";


    /**
     * Константа меню показа всех заявок.
     */
    private static final String SHOW_ALL = "1";

    /**
     * Константа меню для изменения заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для нахождения заявки по ID.
     */
    private static final String FIND_ID = "4";

    /**
     * Константа меню для нахождении заявки по имени
     */
    private static final String FIND_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final ConsoleInput input;

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

    public StartUI(ConsoleInput input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {

        boolean exit = false;
        while (!exit) {

            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");

            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                this.showAll();
            } else if (EDIT.equals(answer)) {
                this.edit();
            } else if (DELETE.equals(answer)) {
                this.delete();
            } else if (FIND_ID.equals(answer)) {
                this.findID();
            } else if (FIND_NAME.equals(answer)) {
                this.findName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }

        }
    }

    /**
     * Метод реализует нахождение заявки по имени.
     */
    private void findName() {
        System.out.println("------------ Нахождении заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки которую хотите найти :");
        Item[] items = new Item[100];
        items = this.tracker.findByName(name);
        for (Item i : items) {
            System.out.println(i.getID() + " " + i.getName() + " " + i.getDescription() + " " + i.getCreated());
        }
        System.out.println("------------------------------------------------------");
    }


    /**
     * Метод реализует нахождение заявки по ID.
     */
    private void findID() {
        System.out.println("------------ Нахождении заявки по id --------------");
        String id = this.input.ask("Введите id заявки которую хотите найти :");
        Item item = null;
        item = this.tracker.findById(id);
        System.out.println(item.getID() + " " + item.getName() + " " + item.getDescription() + " " + item.getCreated());
        System.out.println("------------------------------------------------------");

    }

    /**
     * Метод реализует удаления заявки из хранилища.
     */
    private void delete() {
        System.out.println("------------ Удаление заявки из хранилища --------------");
        String id = this.input.ask("Введите id заявки которую хотите удалить :");
        this.tracker.delete(id);
        System.out.println("------------ Удаление заявки выполнено --------------");
    }


    /**
     * Метод реализует изменение заявки в хранилище.
     */
    private void edit() {

        System.out.println("------------ Изменения заявки в хранилище --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        String id = this.input.ask("Введите id заявки которую хотите поменять :");
        long date = this.input.ask_date("Введите дату создания заявки :");
        Item item = new Item(name, desc, date);
        this.tracker.replace(id, item);
        System.out.println("------------ Изменения заявки выполнено --------------");

    }

    /**
     * Метод вывводит все заявки.
     */
    private void showAll() {
        System.out.println("------------ Вывод всех заявок --------------");
        Item[] items = new Item[100];
        items = this.tracker.findAll();
        for (int i = 0; i < tracker.getPosition(); i++) {
            System.out.println(items[i].getID() + " " + items[i].getName() + " " + items[i].getDescription() + " " + items[i].getCreated());
        }
        System.out.println("---------------------------------------------");
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите имя заявки :");
        long date = this.input.ask_date("Введите дату создания заявки :");
        Item item = new Item(name, desc, date);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getID() + "-----------");
    }

    /**
     * Метод реализует показ меню в консоле.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
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