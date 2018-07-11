package ru.job4j.chess;


/**
 * @author Tolkachev Nikita (nictol76@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class Board {

    public Figure[] figures = new Figure[32];


    public void add(Figure figure) {
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] == null) {
                figures[i] = figure;
                break;
            } else if (i == figures.length - 1) {
                System.out.println("The board is full");
                break;
            }
        }
    }

    public void move(ru.job4j.chess.Cell source, ru.job4j.chess.Cell dest) throws ImpossibleMoveExсeption, OccupiedWayException, FigureNotFoundException {
        if (checkAll(source, dest)) {
            Figure figure = getFigure(source);
            Figure figureCopy = figure.copy(dest);
            deleteFigure(figure);
            add(figureCopy);
        }
    }


    private boolean checkAll(ru.job4j.chess.Cell source, ru.job4j.chess.Cell dest) throws ImpossibleMoveExсeption, OccupiedWayException, FigureNotFoundException {
        return checkFigureFound(source) && !checkOccupiedWayException(source, dest);
    }


    private boolean checkFigureFound(ru.job4j.chess.Cell source) throws FigureNotFoundException {
        boolean found = false;
        for (Figure theFigure : figures) {
            found = theFigure.toString().equals(source.toString());
            if (found) {
                break;
            } else {
                throw new FigureNotFoundException("Figure not found in board");
            }
        }
        return found;
    }


    private boolean checkOccupiedWayException(ru.job4j.chess.Cell source, ru.job4j.chess.Cell dest) throws OccupiedWayException, ImpossibleMoveExсeption {
        boolean occupied = false;
        Figure figure = getFigure(source);
        ru.job4j.chess.Cell[] cells = figure.way(source, dest);
        for (Figure theFigure : figures) {
            for (ru.job4j.chess.Cell cell : cells) {
                if (theFigure != null && cell != null) {
                    occupied = theFigure.toString().equals(cell.toString());
                }
                if (occupied) {
                    throw new OccupiedWayException("Occupied way");
                }
            }
        }
        return occupied;
    }


    private Figure getFigure(ru.job4j.chess.Cell source) {
        Figure figure = null;
        for (Figure theFigure : figures) {
            if (theFigure != null && theFigure.toString().equals(source.toString())) {
                figure = theFigure;
            }
        }
        return figure;
    }


    private void deleteFigure(Figure figure) {
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] != null && figures[i].toString().equals(figure.toString())) {
                figures[i] = null;
            }
        }
    }
}
