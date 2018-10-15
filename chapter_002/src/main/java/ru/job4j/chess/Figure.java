package ru.job4j.chess;

/**
 * @author Tolkachev Nikita (nictol76@yandex.ru)
 * @version $Id$
 * @since 0.1
 */


public abstract class Figure {
    final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }

    public abstract boolean equalsFigure(Figure figure);

    public Cell getPosition() {
        return this.position;
    }

    protected abstract Figure copy(Cell dest);

    protected abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;
}
