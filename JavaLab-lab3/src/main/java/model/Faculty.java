package model;

import java.util.List;

// Клас, що представляє факультет
public class Faculty {
    private String name; // Назва факультету
    private Human head; // Голова факультету
    private List<Department> departments; // Список кафедр

    public Faculty(String name, Human head, List<Department> departments) {
        this.name = name;
        this.head = head;
        this.departments = departments;
    }

    // Геттери
    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public List<Department> getDepartments() {
        return departments;
    }
}