package controller;

import model.Sex;
import model.Student;

// Клас для створення студентів
public class StudentCreator {
    public Student createStudent(String firstName, String lastName, String middleName, Sex sex) {
        return new Student(firstName, lastName, middleName, sex);
    }
}