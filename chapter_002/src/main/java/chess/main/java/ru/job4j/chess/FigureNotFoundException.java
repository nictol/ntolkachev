package chess.main.java.ru.job4j.chess;

public class FigureNotFoundException extends RuntimeException {
    /**
     * ошибка: в данной ячейке отсутствует фигура.
     *
     * @param msg сообщение об ошибке.
     */
    public FigureNotFoundException(String msg) { super(msg); }
}