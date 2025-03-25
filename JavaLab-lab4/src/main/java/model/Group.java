package model;

import java.util.List;

// Клас, що представляє групу
public class Group {
    private String name; // Назва групи
    private Human head; // Голова групи
    private List<Student> students; // Список студентів

    public Group(String name, Human head, List<Student> students) {
        this.name = name;
        this.head = head;
        this.students = students;
    }

    // Геттери
    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public List<Student> getStudents() {
        return students;
    }
}