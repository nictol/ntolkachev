package ru.job4j.strategy;

public class Paint {

  public static void main(String[] args) {

    Triangle t = new Triangle();
    new Paint().draw(t);

    Square s = new Square();
    new Paint().draw(s);

  }

  public void draw(Shape shape) {
    System.out.println(shape.draw());
  }
}
