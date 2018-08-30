package chess.main.java.ru.job4j.chess;

import chess.main.java.ru.job4j.chess.firuges.Cell;
import chess.main.java.ru.job4j.chess.firuges.Figure;

/**
 * @author Tolkachev Nikita (nictol76@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class Board {

    public Board() {
        this.index = 0;
    }

    public chess.main.java.ru.job4j.chess.firuges.Figure[] figures = new chess.main.java.ru.job4j.chess.firuges.Figure[32];

    private int index;


    public void add(chess.main.java.ru.job4j.chess.firuges.Figure figure) {

        if (this.index != figures.length - 1) {

            figures[index] = figure;
            this.index++;

        } else {
            System.out.println("The board is full");

        }

    }

    public void move(chess.main.java.ru.job4j.chess.firuges.Cell source, chess.main.java.ru.job4j.chess.firuges.Cell dest) throws ImpossibleMoveExсeption, OccupiedWayException, FigureNotFoundException {
        if (checkAll(source, dest)) {
            chess.main.java.ru.job4j.chess.firuges.Figure figure = getFigure(source);
            chess.main.java.ru.job4j.chess.firuges.Figure figureCopy = figure.copy(dest);
            deleteFigure(figure);
            add(figureCopy);
        }
    }


    private boolean checkAll(chess.main.java.ru.job4j.chess.firuges.Cell source, chess.main.java.ru.job4j.chess.firuges.Cell dest) throws ImpossibleMoveExсeption, OccupiedWayException, FigureNotFoundException {
        return checkFigureFound(source) && !checkOccupiedWayException(source, dest);
    }


    private boolean checkFigureFound(chess.main.java.ru.job4j.chess.firuges.Cell source) throws FigureNotFoundException {
        boolean found = false;
        for (chess.main.java.ru.job4j.chess.firuges.Figure theFigure : figures) {
            found = theFigure.toString().equals(source.toString());
            if (!found) throw new FigureNotFoundException("Figure not found in board");
        }
        return found;
    }


    private boolean checkOccupiedWayException(chess.main.java.ru.job4j.chess.firuges.Cell source, chess.main.java.ru.job4j.chess.firuges.Cell dest) throws OccupiedWayException, ImpossibleMoveExсeption {
        boolean occupied = false;
        chess.main.java.ru.job4j.chess.firuges.Figure figure = getFigure(source);
        chess.main.java.ru.job4j.chess.firuges.Cell[] cells = figure.way(source, dest);
        for (chess.main.java.ru.job4j.chess.firuges.Figure theFigure : figures) {
            for (chess.main.java.ru.job4j.chess.firuges.Cell cell : cells) {
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


    private chess.main.java.ru.job4j.chess.firuges.Figure getFigure(Cell source) {
        chess.main.java.ru.job4j.chess.firuges.Figure figure = null;
        for (chess.main.java.ru.job4j.chess.firuges.Figure theFigure : figures) {
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
