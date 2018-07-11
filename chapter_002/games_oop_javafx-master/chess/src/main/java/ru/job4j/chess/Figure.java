package ru.job4j.chess;

/**
 * @author Tolkachev Nikita (nictol76@yandex.ru)
 * @version $Id$
 * @since 0.1
 */


public abstract class Figure {
    final Cell position;


    Figure(Cell position) {
        this.position = position;
    }

    protected abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveExсeption;

    protected abstract Figure copy(Cell dest);

    @Override
    public String toString() {

        return String.valueOf(this.position);
    }

    public Cell getPosition() {
        return this.position;
    }
}
