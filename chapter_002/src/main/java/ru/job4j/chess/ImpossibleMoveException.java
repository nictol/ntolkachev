package ru.job4j.chess;

public class ImpossibleMoveException extends RuntimeException {
  /**
   * ошибка: невозможно перенести фигуру.
   *
   * @param msg сообщение об ошибке.
   */
  public ImpossibleMoveException(String msg) {
    super(msg);
  }
}
