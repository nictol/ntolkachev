package ru.job4j.chess.firuges;

public interface Figure {
    ru.job4j.chess.firuges.Cell position();

    ru.job4j.chess.firuges.Cell[] way(ru.job4j.chess.firuges.Cell source, ru.job4j.chess.firuges.Cell dest);

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    Figure copy(Cell dest);

}
