package ru.job4j.tracker;

class EditItem extends BaseAction {

    protected EditItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        String id = input.ask("Введите id заявки которую хотите поменять :");
        long date = input.askDate("Введите дату создания заявки :");
        Item item = new Item(name, desc, date);
        tracker.replace(id, item);
    }
}

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];
    private int position = 0;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[position++] = new AddItem(0, "Add the new item");
        this.actions[position++] = new ShowItem(1, "Show all items");
        this.actions[position++] = new EditItem(2, "Edit item");
        this.actions[position++] = new DeleteItem(3, "Delete item");
        this.actions[position++] = new FindItemById(4, "Find item by Id");
        this.actions[position++] = new FindItemByName(5, "Find item by Name");
    }

    public void addAction(UserAction action) {
        this.actions[position++] = action;
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

    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите имя заявки :");
            long date = input.askDate("Введите дату создания заявки :");
            Item item = new Item(name, desc, date);
            tracker.add(item);
        }

    }

    private static class ShowItem extends BaseAction {

        protected ShowItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] items = new Item[100];
            items = tracker.findAll();
            for (int i = 0; i < tracker.getPosition(); i++) {
                System.out.println(String.format(items[i].getName(), " ", items[i].getID()));
            }
        }

    }

    private class DeleteItem extends BaseAction {

        protected DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки которую хотите удалить :");
            tracker.delete(id);
        }

    }


    private class FindItemById extends BaseAction {

        protected FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки которую хотите найти :");
            Item item = null;
            item = tracker.findById(id);
            System.out.println(String.format(item.getID(), " ", item.getName(), " ", item.getDescription(), " ", item.getCreated()));
        }

    }

    private class FindItemByName extends BaseAction {

        protected FindItemByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки которую хотите найти :");
            Item[] items = new Item[100];
            items = tracker.findByName(name);
            for (int i = 0; i < tracker.getPosition(); i++) {
                System.out.println(String.format(items[i].getID(), " ", items[i].getName(), " ", items[i].getDescription(), " ", items[i].getCreated()));
            }
        }

    }


}
