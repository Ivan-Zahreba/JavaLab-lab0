package model;

    import java.util.List;

    // Клас, що представляє університет
    public class University {
        private String name; // Назва університету
        private Human head; // Голова університету
        private List<Faculty> faculties; // Список факультетів

        public University(String name, Human head, List<Faculty> faculties) {
            this.name = name;
            this.head = head;
            this.faculties = faculties;
        }

        // Геттери
        public String getName() {
            return name;
        }

        public Human getHead() {
            return head;
        }

        public List<Faculty> getFaculties() {
            return faculties;
        }
    }