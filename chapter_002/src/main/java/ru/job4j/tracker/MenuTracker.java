package ru.job4j.tracker;

class EditItem implements UserAction {

    public int key() {
        return 2;
    }

    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        String id = input.ask("Введите id заявки которую хотите поменять :");
        long date = input.askDate("Введите дату создания заявки :");
        Item item = new Item(name, desc, date);
        tracker.replace(id, item);
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Edit item");
    }

}


public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowItem();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindItemById();
        this.actions[5] = new FindItemByName();

    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {

        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите имя заявки :");
            long date = input.askDate("Введите дату создания заявки :");
            Item item = new Item(name, desc, date);
            tracker.add(item);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item");
        }

    }

    private static class ShowItem implements UserAction {

        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            Item[] items = new Item[100];
            items = tracker.findAll();
            for (int i = 0; i < tracker.getPosition(); i++) {
                System.out.println(String.format(items[i].getName(), " ", items[i].getID()));
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }

    }


    private class DeleteItem implements UserAction {

        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки которую хотите удалить :");
            tracker.delete(id);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }

    }


    private class FindItemById implements UserAction {

        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки которую хотите найти :");
            Item item = null;
            item = tracker.findById(id);
            System.out.println(String.format(item.getID(), " ", item.getName(), " ", item.getDescription(), " ", item.getCreated()));
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id");
        }

    }


    private class FindItemByName implements UserAction {

        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки которую хотите найти :");
            Item[] items = new Item[100];
            items = tracker.findByName(name);
            for (int i = 0; i < tracker.getPosition(); i++) {
                System.out.println(String.format(items[i].getID(), " ", items[i].getName(), " ", items[i].getDescription(), " ", items[i].getCreated()));
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Name");
        }

    }


}
