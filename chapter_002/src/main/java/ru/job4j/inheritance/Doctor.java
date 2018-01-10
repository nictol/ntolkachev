package ru.job4j.inheritance;

public class Doctor extends Profession {
    public String specialization;
    public String departament;
    public String clothingSize;
    public Patient patient;

    public void Doctor() {
    }

    public void SetDiagnosis(Patient pt, String diagnosis) {
        pt.diagnosis = diagnosis;
    }

    public String Treat(Patient pt) {
        return this.getName() + " лечит пациента" + pt;
    }


}
