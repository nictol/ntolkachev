package ru.job4j.loop;

public class Paint {
    public String piramid(int h) {
        StringBuilder piramid = new StringBuilder();
        int amountOfPiramids = 2 * h - 1; //Length of last piramid level
        for (int i = 1; i <= h; i++) {
            int amountOfParts = 2 * (h - i);  //Amount of parts (" ") in this level
            for (int j = 1; j <= amountOfPiramids; j++) {
                if (j <= (amountOfParts / 2) | (j > (amountOfPiramids - amountOfParts / 2))) piramid.append(' ');
                else piramid.append('^');
            }
            piramid.append(System.getProperty("line.separator"));
        }
        return piramid.toString();
    }
}
