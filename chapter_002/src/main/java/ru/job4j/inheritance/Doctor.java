package ru.job4j.inheritance;

public class Doctor extends Profession {
    public String specialization;
    public String departament;
    public String clothingSize;
    public Patient patient;

    public void setDiagnosis(Patient pt, String diagnosis) {
        pt.diagnosis = diagnosis;
    }

    public String treat(Patient pt) {
        return this.getName() + " лечит пациента" + pt;
    }


}
