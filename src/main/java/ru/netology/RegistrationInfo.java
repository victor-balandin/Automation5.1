package ru.netology;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class RegistrationInfo {
    private final String city;
    private final LocalDate date;
    private final String name;
    private final String phone;


    public RegistrationInfo(String city, LocalDate date, String name, String phone) {
        this.city = city;
        this.date = date;
        this.name = name;
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String testDate = date.format(formatter);
        return testDate;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAnotherDate() {
        LocalDate anotherDate = date.plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String secondDate = anotherDate.format(formatter);
        return secondDate;
    }
}
