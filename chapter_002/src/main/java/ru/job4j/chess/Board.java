package ru.job4j.chess;

/**
 * @author Tolkachev Nikita (nictol76@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class Board {

    public Figure[] figures = new Figure[32];
    private int index;

    public Board() {
        this.index = 0;
    }

    public void add(Figure figure) {
        if (this.index != figures.length - 1) {
            figures[index] = figure;
            this.index++;
        } else {
            System.out.println("The board is full");
        }
    }

    public void move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        if (checkAll(source, dest)) {
            Figure figure = getFigure(source);
            this.add(figure.copy(dest));
        }
    }

    private boolean checkAll(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        return checkFigureFound(source) && !checkOccupiedWayException(source, dest);
    }

    private Figure getFigure(Cell source) {
        Figure figure = null;
        for (Figure theFigure : figures) {
            if (theFigure != null && theFigure.getPosition().equalsCell(source)) {
                figure = theFigure;
                break;
            }
        }
        return figure;
    }

    private boolean checkFigureFound(Cell source) throws FigureNotFoundException {
        boolean found = false;
        for (Figure theFigure : figures) {
            found = theFigure.getPosition().equalsCell(source);
            if (!found) {
                throw new FigureNotFoundException("Figure not found in board");
            } else {
                break;
            }
        }
        return found;
    }

    private boolean checkOccupiedWayException(Cell source, Cell dest) throws OccupiedWayException, ImpossibleMoveException {
        boolean occupied = false;
        Figure figure = getFigure(source);
        Cell[] cells = figure.way(source, dest);
        for (Figure theFigure : figures) {
            for (Cell cell : cells) {
                if (theFigure != null && cell != null) {
                    occupied = theFigure.getPosition().equalsCell(cell);
                }
                if (occupied) {
                    throw new OccupiedWayException("Occupied way");
                }
            }
        }
        return occupied;
    }

    private void deleteFigure(Figure figure) {
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] != null && figures[i].equalsFigure(figure)) {
                figures[i] = null;
            }
        }
    }
}
