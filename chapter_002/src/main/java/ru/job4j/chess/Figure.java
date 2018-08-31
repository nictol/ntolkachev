package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;

/**
 * @author Tolkachev Nikita (nictol76@yandex.ru)
 * @version $Id$
 * @since 0.1
 */


public abstract class Figure {
    final ru.job4j.chess.firuges.Cell position;


    Figure(ru.job4j.chess.firuges.Cell position) {
        this.position = position;
    }

    protected abstract ru.job4j.chess.firuges.Cell[] way(ru.job4j.chess.firuges.Cell source, ru.job4j.chess.firuges.Cell dest) throws ImpossibleMoveExсeption;

    protected abstract ru.job4j.chess.firuges.Figure copy(ru.job4j.chess.firuges.Cell dest);

    @Override
    public String toString() {

        return String.valueOf(this.position);
    }

    public Cell getPosition() {
        return this.position;
    }
}
