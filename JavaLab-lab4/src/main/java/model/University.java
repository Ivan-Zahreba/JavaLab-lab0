package model;

        import java.util.List;
        import java.util.Objects;

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

            // Метод equals для порівняння університетів
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                University that = (University) o;
                return Objects.equals(name, that.name) &&
                        Objects.equals(head, that.head) &&
                        Objects.equals(faculties, that.faculties);
            }

            @Override
            public int hashCode() {
                return Objects.hash(name, head, faculties);
            }
        }