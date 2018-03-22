package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {

    public int ask(String question, int[] range) {
        int value = -1;
        boolean invalid = true;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenOutExeption moe) {
                System.out.println("Please select key from menu");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate date again.");
            }

        } while (invalid);

        return value;
    }
}
