package controller;

import model.Department;
import model.Faculty;
import model.Human;

import java.util.List;

// Клас для створення факультетів
public class FacultyCreator {
    public Faculty createFaculty(String name, Human head, List<Department> departments) {
        return new Faculty(name, head, departments);
    }
}