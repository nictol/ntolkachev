package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private Scanner in = new Scanner(System.in);


    public String ask(String message) {

        System.out.println(message);
        String inputLine = in.nextLine();
        return inputLine;
    }

    public long ask_date(String message) {
        System.out.println(message);
        long inputNumber = in.nextLong();
        return inputNumber;
    }

}
