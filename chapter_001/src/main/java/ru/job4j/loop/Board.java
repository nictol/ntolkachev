package ru.job4j.loop;

public class Board {
    public String paint(int width, int height) {
        StringBuilder board = new StringBuilder();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j <width ; j++) {
                if ((j+i)%2==0) board.append('x'); else board.append(' ');
            }
            board.append(System.getProperty("line.separator"));
        }
        return board.toString();
    }
}
