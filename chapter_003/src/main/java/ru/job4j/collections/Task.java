/*
 *  Created by NTolkachev on 21.06.2020.
 */
package ru.job4j.collections;

public class Task {
    private String number;
    private String description;

    public Task(String number, String description) {
        this.number = number;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }
}
