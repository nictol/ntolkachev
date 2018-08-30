package chess.test.java.ru.job4j.chess;

import org.junit.Test;
import chess.main.java.ru.job4j.chess.firuges.black.BishopBlack;

import java.util.Arrays;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Tolkachev Nikita (nictol76@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class ChessTest {

    @Test(expected = ImpossibleMoveExсeption.class)
    public void whenFigureWayWrong() throws ImpossibleMoveExсeption {
        Cell c = new Cell(1, 4);
        Cell c2 = new Cell(3, 4);
        BishopBlack bishop = new BishopBlack(c);
        bishop.way(c, c2);
    }


    @Test
    public void whenFigureWayCorrect() throws ImpossibleMoveExсeption {
        Cell c = new Cell(2, 2);
        Cell c1 = new Cell(3, 3);
        Cell c2 = new Cell(4, 4);
        BishopBlack bishop = new BishopBlack(c);
        Cell[] cell = {c1, c2};
        assertThat(Arrays.toString(bishop.way(c, c2)).equals(Arrays.toString(cell)), is(true));
    }


    @Test
    public void whenAddFigure() {
        Board board = new Board();
        BishopBlack bishop = new BishopBlack(new Cell(0, 0));
        board.add(bishop);
        assertThat(board.figures[0], is(bishop));
    }

    @Test(expected = FigureNotFoundException.class)

    public void whenFigureNotFound() throws OccupiedWayException, ImpossibleMoveExсeption, FigureNotFoundException {
        Board board = new Board();
        BishopBlack bishop = new BishopBlack(new Cell(0, 0));
        board.add(bishop);
        Cell c = new Cell(1, 1);
        board.move(c, c);
    }


    @Test(expected = OccupiedWayException.class)
    public void whenWayIsOccupied() throws OccupiedWayException, ImpossibleMoveExсeption, FigureNotFoundException {
        Board board = new Board();
        BishopBlack bishop = new BishopBlack(new Cell(0, 0));
        BishopBlack bishop1 = new BishopBlack(new Cell(1, 1));
        board.add(bishop);
        board.add(bishop1);
        Cell c = new Cell(2, 2);
        board.move(bishop.getPosition(), c);
    }


    @Test(expected = ImpossibleMoveExсeption.class)
    public void whenMoveIsWrong() throws OccupiedWayException, ImpossibleMoveExсeption, FigureNotFoundException {
        Board board = new Board();
        BishopBlack bishop = new BishopBlack(new Cell(0, 0));
        board.add(bishop);
        Cell c = new Cell(4, 2);
        board.move(bishop.getPosition(), c);
    }


    @Test
    public void whenMoveFigure() throws OccupiedWayException, ImpossibleMoveExсeption, FigureNotFoundException {
        Board board = new Board();
        BishopBlack bishop = new BishopBlack(new Cell(0, 0));
        board.add(bishop);
        Cell c = new Cell(2, 2);
        board.move(bishop.getPosition(), c);
        assertThat(board.figures[0].toString(), is(c.toString()));
    }
}