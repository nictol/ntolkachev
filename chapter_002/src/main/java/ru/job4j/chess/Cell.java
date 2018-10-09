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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {

        return this.x + "  " + this.y;
    }

    public boolean equalsCell(Cell cell) {
        return ((cell.x == this.x) & (cell.y == this.y)) ? true : false;
    }
}