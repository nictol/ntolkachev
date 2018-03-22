package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private Scanner in = new Scanner(System.in);

    public String ask(String message) {

        System.out.println(message);
        String inputLine = in.nextLine();
        return inputLine;
    }

    public long askDate(String message) {
        System.out.println(message);
        long inputNumber = in.nextLong();
        return inputNumber;
    }

    public int ask(String question, int[] range) throws MenOutExeption {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenOutExeption("Out of menu range");
        }
    }
}
