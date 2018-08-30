package chess.main.java.ru.job4j.chess.firuges.black;

import chess.main.java.ru.job4j.chess.ImpossibleMoveExсeption;
import chess.main.java.ru.job4j.chess.firuges.Cell;
import chess.main.java.ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.Cell;
import ru.job4j.chess.Figure;
import ru.job4j.chess.ImpossibleMoveExсeption;

/**
 * @author Tolkachev Nikita (nictol76@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class BishopBlack extends chess.main.java.ru.job4j.chess.firuges.Figure {

    public BishopBlack(chess.main.java.ru.job4j.chess.firuges.Cell position) {
        super(position);
    }

    @Override
    public chess.main.java.ru.job4j.chess.firuges.Cell[] way(chess.main.java.ru.job4j.chess.firuges.Cell source, chess.main.java.ru.job4j.chess.firuges.Cell destination) throws ImpossibleMoveExсeption {
        chess.main.java.ru.job4j.chess.firuges.Cell[] cell;
        if (destination.getX() - source.getX() == destination.getY() - source.getY()) {
            cell = findWay(source, destination);
        } else {
            throw new ImpossibleMoveExсeption("Impossible move the figure Bishop");
        }
        return cell;
    }

    private chess.main.java.ru.job4j.chess.firuges.Cell[] findWay(chess.main.java.ru.job4j.chess.firuges.Cell source, chess.main.java.ru.job4j.chess.firuges.Cell destination) {
        chess.main.java.ru.job4j.chess.firuges.Cell[] cells = new chess.main.java.ru.job4j.chess.firuges.Cell[Math.abs(destination.getX() - source.getX())];
        int x = source.getX();
        int y = source.getY();
        for (int i = 0; i != cells.length; i++) {

            if (destination.getX() > x) x++;
            else x--;

            if (destination.getY() > y) y++;
            else y--;

            cells[i] = new chess.main.java.ru.job4j.chess.firuges.Cell(x, y);
        }
        return cells;
    }

    Figure copy(Cell destination) {
        return new BishopBlack(destination);
    }

}
