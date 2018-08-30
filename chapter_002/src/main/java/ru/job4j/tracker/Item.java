package ru.job4j.tracker;

public class Item {
    private String ID;
    private String name;
    private String description;
    private long created;
    private String[] comments;
    public Item(String name, String desk, long created) {
        this.name = name;
        this.description = desk;
        this.created = created;
    }
    /**
     * Метод реализующий установки уникального id
     *
     * @param id уникальный индентификатор
     */
    public void setId(String id) {
        this.ID = id;
    }
    /**
     * Метод реализующий возврат уникального id
     */
    public String getID() {
        return this.ID;
    }
    /**
     * Установить имя элемента
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Метод реализующий возврат имени элемента
     */
    public String getName() {
        return name;
    }
    /**
     * Метод реализующий установку описания
     *
     * @param description описание элемента
     */
    public void setDesciption(String description) {
        this.description = description;
    }
    /**
     * Метод реализующий возврат описания элемента
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * Метод реализующий установки уникальной даты
     *
     * @param created дата создания
     */
    public void setCreated(long created) {
        this.created = created;
    }
    /**
     * Метод реализующий возврат даты создания элемента
     */
    public long getCreated() {
        return this.created;
    }
    /**
     * Метод реализующий установки комментариев
     *
     * @param comments комментарии
     */
    public void setComments(String[] comments) {
        this.comments = comments;
    }
    /**
     * Метод реализующий возврат комментариев
     */
    public String[] getComments() {
        return comments;
    }
}
