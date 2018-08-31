package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveExсeption;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Tolkachev Nikita (nictol76@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class BishopBlack extends ru.job4j.chess.firuges.Figure {

    public BishopBlack(ru.job4j.chess.firuges.Cell position) {
        super(position);
    }

    @Override
    public ru.job4j.chess.firuges.Cell[] way(ru.job4j.chess.firuges.Cell source, ru.job4j.chess.firuges.Cell destination) throws ImpossibleMoveExсeption {
        ru.job4j.chess.firuges.Cell[] cell;
        if (destination.getX() - source.getX() == destination.getY() - source.getY()) {
            cell = findWay(source, destination);
        } else {
            throw new ImpossibleMoveExсeption("Impossible move the figure Bishop");
        }
        return cell;
    }

    private ru.job4j.chess.firuges.Cell[] findWay(ru.job4j.chess.firuges.Cell source, ru.job4j.chess.firuges.Cell destination) {
        ru.job4j.chess.firuges.Cell[] cells = new ru.job4j.chess.firuges.Cell[Math.abs(destination.getX() - source.getX())];
        int x = source.getX();
        int y = source.getY();
        for (int i = 0; i != cells.length; i++) {

            if (destination.getX() > x) x++;
            else x--;

            if (destination.getY() > y) y++;
            else y--;

            cells[i] = new ru.job4j.chess.firuges.Cell(x, y);
        }
        return cells;
    }

    Figure copy(Cell destination) {
        return new BishopBlack(destination);
    }

}
