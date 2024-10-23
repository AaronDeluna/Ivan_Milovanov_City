package org.javaacademy;

import org.javaacademy.entity.Citizen;
import org.javaacademy.entity.CivilRegistry;
import org.javaacademy.entity.MaritalStatus;
import org.javaaccademy.entity.Gender;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Citizen fatherCitizen = new Citizen("D", "D", "D", Gender.MALE);
        Citizen matherCitizen = new Citizen("R", "R", "R", Gender.FEMALE);
        Citizen childCitizen = new Citizen("e", "e", "e", Gender.FEMALE);

        Date date = new Date(2003, 2, 12);
        Date date2 = new Date(2003, 2, 11);
        CivilRegistry civilRegistry = new CivilRegistry("13-ГЛАВНЫЙ ЗАГС");

        civilRegistry.registerChildBirth(fatherCitizen, fatherCitizen, childCitizen, date);
        civilRegistry.registerChildBirth(fatherCitizen, matherCitizen, childCitizen, date);
        civilRegistry.registerChildBirth(fatherCitizen, matherCitizen, childCitizen, date);

        civilRegistry.weddingRegistration(fatherCitizen, matherCitizen, date);

        civilRegistry.registrationDivorce(fatherCitizen, matherCitizen, date);
        System.out.println(civilRegistry.getStatisticsByDate(date));
    }
}