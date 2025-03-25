package controller;

import model.Department;
import model.Group;
import model.Human;

import java.util.List;

// Клас для створення кафедр
public class DepartmentCreator {
    public Department createDepartment(String name, Human head, List<Group> groups) {
        return new Department(name, head, groups);
    }
}