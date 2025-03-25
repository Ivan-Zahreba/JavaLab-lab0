package model;

// Клас, що представляє людину
public class Human {
    private String firstName; // Ім'я
    private String lastName; // Прізвище
    private String middleName; // По батькові
    private Sex sex; // Стать

    public Human(String firstName, String lastName, String middleName, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.sex = sex;
    }

    // Геттери
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Sex getSex() {
        return sex;
    }
}