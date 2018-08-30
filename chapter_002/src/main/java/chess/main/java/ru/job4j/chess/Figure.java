package chess.main.java.ru.job4j.chess;

import chess.main.java.ru.job4j.chess.firuges.Cell;

/**
 * @author Tolkachev Nikita (nictol76@yandex.ru)
 * @version $Id$
 * @since 0.1
 */


public abstract class Figure {
    final chess.main.java.ru.job4j.chess.firuges.Cell position;


    Figure(chess.main.java.ru.job4j.chess.firuges.Cell position) {
        this.position = position;
    }

    protected abstract chess.main.java.ru.job4j.chess.firuges.Cell[] way(chess.main.java.ru.job4j.chess.firuges.Cell source, chess.main.java.ru.job4j.chess.firuges.Cell dest) throws ImpossibleMoveExсeption;

    protected abstract chess.main.java.ru.job4j.chess.firuges.Figure copy(chess.main.java.ru.job4j.chess.firuges.Cell dest);

    @Override
    public String toString() {

        return String.valueOf(this.position);
    }

    public Cell getPosition() {
        return this.position;
    }
}
