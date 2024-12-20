package org.example;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class PersonProcessor {

    private static final Logger logger = LoggerSetup.getLogger();

    public static List<Person> filterAdults(List<Person> persons) {
        return persons.stream()
                .filter(person -> person.getAge() > 18)
                .peek(person -> logger.info("Взрослые: " + person.getName()))
                .collect(Collectors.toList());
    }

    public static List<Map<String, String>> extractNamesAndEmails(List<Person> adults) {
        return adults.stream()
                .map(person -> Map.of("name", person.getName(), "email", person.getEmail()))
                .collect(Collectors.toList());
    }

    public static double calculateAverageAge(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
    }

    public static List<Person> filterLeapYearBorn(List<Person> persons) {
        return persons.stream()
                .filter(person -> {
                    int year = person.getBirthDate().getYear();
                    return (year % 4 == 0 || year % 400 == 0) && year % 100 != 0;
                })
                .collect(Collectors.toList());
    }

    public static Map<String, List<Person>> groupByAge(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(person -> {
                    if (person.getAge() <= 12) return "Ребёнок";
                    else if (person.getAge() <= 30) return "Молодёжь";
                    else return "Пожилой";
                }));
    }
}
