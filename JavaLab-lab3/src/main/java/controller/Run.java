package controller;

        import model.*;

        import java.util.ArrayList;
        import java.util.List;

        // Клас для запуску програми
        public class Run {
            public static void main(String[] args) {
                Run run = new Run();
                University university = run.createTypicalUniversity();
                run.printUniversity(university);
            }

            // Метод для створення типового університету
            public University createTypicalUniversity() {
                StudentCreator studentCreator = new StudentCreator();
                GroupCreator groupCreator = new GroupCreator();
                DepartmentCreator departmentCreator = new DepartmentCreator();
                FacultyCreator facultyCreator = new FacultyCreator();
                UniversityCreator universityCreator = new UniversityCreator();

                // Створення студентів
                Student student1 = studentCreator.createStudent("Jack", "London", "Middle", Sex.MALE);
                Student student2 = studentCreator.createStudent("Mary", "Jane", "Middle", Sex.FEMALE);

                // Створення груп
                List<Student> students = new ArrayList<>();
                students.add(student1);
                students.add(student2);
                Group group = groupCreator.createGroup("122-21-4", student1, students);

                // Створення кафедр
                List<Group> groups = new ArrayList<>();
                groups.add(group);
                Department department = departmentCreator.createDepartment("Department", student1, groups);

                // Створення факультетів
                List<Department> departments = new ArrayList<>();
                departments.add(department);
                Faculty faculty = facultyCreator.createFaculty("FIT", student1, departments);

                // Створення університету
                List<Faculty> faculties = new ArrayList<>();
                faculties.add(faculty);
                return universityCreator.createUniversity("NTU DP", student1, faculties);
            }

            // Метод для виведення інформації про університет
            public void printUniversity(University university) {
                System.out.println("Університет: " + university.getName());
                System.out.println("Голова університету: " + university.getHead().getFirstName() + " " + university.getHead().getLastName());
                for (Faculty faculty : university.getFaculties()) {
                    System.out.println("  Факультет: " + faculty.getName());
                    System.out.println("  Голова факультету: " + faculty.getHead().getFirstName() + " " + faculty.getHead().getLastName());
                    for (Department department : faculty.getDepartments()) {
                        System.out.println("    Кафедра: " + department.getName());
                        System.out.println("    Голова кафедри: " + department.getHead().getFirstName() + " " + department.getHead().getLastName());
                        for (Group group : department.getGroups()) {
                            System.out.println("      Група: " + group.getName());
                            System.out.println("      Голова групи: " + group.getHead().getFirstName() + " " + group.getHead().getLastName());
                            for (Student student : group.getStudents()) {
                                System.out.println("        Студент: " + student.getFirstName() + " " + student.getLastName());
                            }
                        }
                    }
                }
            }
        }