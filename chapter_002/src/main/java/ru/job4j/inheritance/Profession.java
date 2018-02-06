package ru.job4j.inheritance;

public class Profession {

    public String fio;
    public String position;
    public Experience experience;
    public String education;

    public Profession() {

    }

    public Profession(String fio, String pos, Experience exp, String edu) {
        this.fio = fio;
        this.position = pos;
        this.experience = exp;
        this.education = edu;
    }

    public String getName() {
        return this.fio;
    }

}
