package ru.job4j.tracker;

public interface Input {

    public String ask(String message);
    public long askDate(String message);
    public int ask (String question, int[] range);

}
