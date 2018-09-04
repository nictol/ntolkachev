package ru.job4j.chess;

public class ImpossibleMoveExсeption extends RuntimeException {
  /**
   * ошибка: невозможно перенести фигуру.
   *
   * @param msg сообщение об ошибке.
   */
  public ImpossibleMoveExсeption(String msg) {
    super(msg);
  }
}
