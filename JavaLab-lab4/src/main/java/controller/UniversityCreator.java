package controller;

import model.Faculty;
import model.Human;
import model.University;

import java.util.List;

// Клас для створення університетів
public class UniversityCreator {
    public University createUniversity(String name, Human head, List<Faculty> faculties) {
        return new University(name, head, faculties);
    }
}