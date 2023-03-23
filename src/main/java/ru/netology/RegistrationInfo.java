package ru.netology;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class RegistrationInfo {
    private final String city;
    private final String date;
    private final String name;
    private final String phone;


    public RegistrationInfo(String city, String date, String name, String phone) {
        this.city = city;
        this.date = date;
        this.name = name;
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAnotherDate() {
        String secondDate = LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return secondDate;
    }
}
