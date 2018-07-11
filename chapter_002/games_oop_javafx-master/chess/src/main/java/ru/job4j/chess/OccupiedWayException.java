package ru.job4j.chess;

public class OccupiedWayException extends RuntimeException {
    /**
     * ошибка: полученный путь занят.
     *
     * @param msg сообщение об ошибке.
     */

    public OccupiedWayException(String msg) {
        super(msg);
    }
}