package model;

    import java.util.List;

    // Клас, що представляє кафедру
    public class Department {
        private String name; // Назва кафедри
        private Human head; // Голова кафедри
        private List<Group> groups; // Список груп

        public Department(String name, Human head, List<Group> groups) {
            this.name = name;
            this.head = head;
            this.groups = groups;
        }

        // Геттери
        public String getName() {
            return name;
        }

        public Human getHead() {
            return head;
        }

        public List<Group> getGroups() {
            return groups;
        }
    }