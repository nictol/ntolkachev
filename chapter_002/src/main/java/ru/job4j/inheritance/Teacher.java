package ru.job4j.inheritance;

public class Teacher extends Profession {

    public String subject;
    public String school;

    public Teacher() {

    }

    public String getMoney() {
        return this.getName() + " получила зарплату!";
    }

    public void rate(Student st, Mark m) {
        st.mark = m;
    }

    public void changeSchool(String newschool) {
        this.school = newschool;
    }
}
