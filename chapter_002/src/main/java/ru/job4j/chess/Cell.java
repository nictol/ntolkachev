package ru.job4j.chess;

/**
 * @author Tolkachev Nikita (nictol76@yandex.ru)
 * @version $Id$
 * @since 0.1
 */


public class Cell {

    private int x;
    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Boolean equalsCell(Cell cell) {
        return (this.getX() == cell.getX()) && (this.getY() == cell.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}