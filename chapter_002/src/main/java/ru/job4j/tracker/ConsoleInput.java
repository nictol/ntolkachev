package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private Scanner in = new Scanner(System.in);

    public String ask(String s) {

        System.out.println(s);
        String c = in.nextLine();
        return c;
    }

    public long ask_date(String s) {
        System.out.println(s);
        long c = in.nextLong();
        return c;
    }

}
