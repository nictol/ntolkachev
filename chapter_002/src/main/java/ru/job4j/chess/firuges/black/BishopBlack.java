package ru.job4j.chess.firuges.black;

import ru.job4j.chess.Cell;
import ru.job4j.chess.Figure;
import ru.job4j.chess.ImpossibleMoveException;

/**
 * @author Tolkachev Nikita (nictol76@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class BishopBlack extends Figure {

  public BishopBlack(Cell position) {
    super(position);
  }

  @Override
  public Cell[] way(Cell source, Cell destination) throws ImpossibleMoveException {
    Cell[] cell;
    if (destination.getX() - source.getX() == destination.getY() - source.getY()) {
      cell = findWay(source, destination);
    } else {
      throw new ImpossibleMoveException("Impossible move the figure Bishop");
    }
    return cell;
  }


  private Cell[] findWay(Cell source, Cell destination) {
    Cell[] cells = new Cell[Math.abs(destination.getX() - source.getX())];
    int x = source.getX();
    int y = source.getY();
    for (int i = 0; i != cells.length; i++) {

      if (destination.getX() > x) {
        x++;
      } else {
        x--;
      }

      if (destination.getY() > y) {
        y++;
      } else {
        y--;
      }

      cells[i] = new Cell(x, y);
    }
    return cells;
  }

  protected Figure copy(Cell destination) {
    return new BishopBlack(destination);
  }

}