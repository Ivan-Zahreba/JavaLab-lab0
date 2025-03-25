package test;

import controller.*;
import manager.JsonManager;
import model.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Клас для тестування запису та зчитування університету у форматі JSON
public class JsonManagerTest {

    @Test
    public void testWriteAndReadUniversity() throws IOException {
        // Створення об'єкта університету
        University oldUniversity = createUniversity();

        // Запис університету у файл
        JsonManager jsonManager = new JsonManager();
        String filePath = "university.json";
        jsonManager.writeUniversityToFile(oldUniversity, filePath);

        // Зчитування університету з файлу
        University newUniversity = jsonManager.readUniversityFromFile(filePath);

        // Порівняння університетів
        assertEquals(oldUniversity, newUniversity);
    }

    // Метод для створення університету з двома підрозділами на кожному рівні
    private University createUniversity() {
        StudentCreator studentCreator = new StudentCreator();
        GroupCreator groupCreator = new GroupCreator();
        DepartmentCreator departmentCreator = new DepartmentCreator();
        FacultyCreator facultyCreator = new FacultyCreator();
        UniversityCreator universityCreator = new UniversityCreator();

        // Створення студентів
        Student student1 = studentCreator.createStudent("John", "Doe", "Middle", Sex.MALE);
        Student student2 = studentCreator.createStudent("Jane", "Doe", "Middle", Sex.FEMALE);
        Student student3 = studentCreator.createStudent("Jim", "Beam", "Middle", Sex.MALE);
        Student student4 = studentCreator.createStudent("Jill", "Valentine", "Middle", Sex.FEMALE);

        // Створення груп
        List<Student> students1 = new ArrayList<>();
        students1.add(student1);
        students1.add(student2);
        Group group1 = groupCreator.createGroup("Group1", student1, students1);

        List<Student> students2 = new ArrayList<>();
        students2.add(student3);
        students2.add(student4);
        Group group2 = groupCreator.createGroup("Group2", student3, students2);

        // Створення кафедр
        List<Group> groups1 = new ArrayList<>();
        groups1.add(group1);
        groups1.add(group2);
        Department department1 = departmentCreator.createDepartment("Department1", student1, groups1);

        List<Group> groups2 = new ArrayList<>();
        groups2.add(group1);
        groups2.add(group2);
        Department department2 = departmentCreator.createDepartment("Department2", student3, groups2);

        // Створення факультетів
        List<Department> departments1 = new ArrayList<>();
        departments1.add(department1);
        departments1.add(department2);
        Faculty faculty1 = facultyCreator.createFaculty("Faculty1", student1, departments1);

        List<Department> departments2 = new ArrayList<>();
        departments2.add(department1);
        departments2.add(department2);
        Faculty faculty2 = facultyCreator.createFaculty("Faculty2", student3, departments2);

        // Створення університету
        List<Faculty> faculties = new ArrayList<>();
        faculties.add(faculty1);
        faculties.add(faculty2);
        return universityCreator.createUniversity("University1", student1, faculties);
    }
}