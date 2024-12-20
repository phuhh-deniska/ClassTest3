package org.example;

import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate birthDate;
    private String email;

    public Person(String name, LocalDate birthDate, String email) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    public boolean wasBornInLeapYear() {
        return birthDate.isLeapYear();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                '}';
    }
}
