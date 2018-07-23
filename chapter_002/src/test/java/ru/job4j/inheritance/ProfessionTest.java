package ru.job4j.inheritance;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfessionTest {

    @Test
    public void testTeacher() {

        Teacher teacher = new Teacher();
        teacher.school = "Гимназия №2";
        teacher.fio = "Семенова Жанна Борисовна";

        String result = teacher.getName();
        String expexted = "Семенова Жанна Борисовна";

        assertThat(result, is(expexted));
    }

    @Test
    public void testDoctor() {

        Doctor doctor = new Doctor();
        Patient patient = new Patient();
        doctor.setDiagnosis(patient, "Туберкулез");

        String result = patient.diagnosis;
        String expexted = "Туберкулез";

        assertThat(result, is(expexted));
    }
}



