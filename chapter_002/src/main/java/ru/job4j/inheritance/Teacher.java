package ru.job4j.inheritance;

public class Teacher extends Profession {

    public String subject;
    public String school;

    public Teacher() {

    }

    public String GetMoney() {
        return this.getName() + " получила зарплату!";
    }

    public void Rate(Student st, Mark m) {
        st.mark = m;
    }

    public void ChangeSchool(String newschool) {
        this.school = newschool;
    }
}
