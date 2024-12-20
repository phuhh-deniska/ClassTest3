package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PersonFilter {

    public static void main(String[] args) {
        try {
            LoggerSetup.setupLogger();

            String inputFilePath = "inputFile.json";
            List<Person> persons = JsonFileHandler.readPersonsFromJson(inputFilePath);

            List<Person> adults = PersonProcessor.filterAdults(persons);

            List<Map<String, String>> namesAndEmails = PersonProcessor.extractNamesAndEmails(adults);

            String outputFilePath = "filtered_persons.json";
            JsonFileHandler.writeToJson(namesAndEmails, outputFilePath);

            double averageAge = PersonProcessor.calculateAverageAge(persons);
            LoggerSetup.getLogger().info("Средний возраст: " + averageAge);

            List<Person> leapYearBorn = PersonProcessor.filterLeapYearBorn(persons);
            LoggerSetup.getLogger().info("Високосный год рождения: " + leapYearBorn);

            Map<String, List<Person>> ageGroups = PersonProcessor.groupByAge(persons);
            LoggerSetup.getLogger().info("Возрастные группы: " + ageGroups);

        } catch (IOException e) {
            LoggerSetup.getLogger().severe("Исключение: " + e.getMessage());
        }
    }
}
