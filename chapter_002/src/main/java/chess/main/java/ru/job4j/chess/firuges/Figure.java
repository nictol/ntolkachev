package chess.main.java.ru.job4j.chess.firuges;

public interface Figure {
    chess.main.java.ru.job4j.chess.firuges.Cell position();

    chess.main.java.ru.job4j.chess.firuges.Cell[] way(chess.main.java.ru.job4j.chess.firuges.Cell source, chess.main.java.ru.job4j.chess.firuges.Cell dest);

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    Figure copy(Cell dest);

}
