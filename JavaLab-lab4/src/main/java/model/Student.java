package model;

// Клас, що представляє студента, успадкований від Human
public class Student extends Human {
    public Student(String firstName, String lastName, String middleName, Sex sex) {
        super(firstName, lastName, middleName, sex);
    }
}