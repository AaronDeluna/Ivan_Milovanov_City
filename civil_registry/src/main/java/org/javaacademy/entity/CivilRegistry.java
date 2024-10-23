package org.javaacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.javaacademy.service.CitizenService;
import org.javaacademy.service.StatisticsService;

import java.util.*;

/**
 * ЗАГС.
 */
@AllArgsConstructor
public class CivilRegistry {
    String name;
    final MultiValuedMap<Date, CivilActionRecord> records = new ArrayListValuedHashMap<>();
    final CitizenService citizenService = new CitizenService();
    final StatisticsService statisticsService = new StatisticsService();

    /**
     * Регистрирует рождение ребенка.
     *
     * @param newborn новорожденный гражданин
     * @param father отец новорожденного
     * @param mother мать новорожденного
     * @param dateBirthRegistration дата регистрации рождения
     */
    public void registerChildBirth(Citizen newborn, Citizen father, Citizen mother, Date dateBirthRegistration) {
        newborn.setParents(father, mother);
        records.put(dateBirthRegistration, new CivilActionRecord(
                dateBirthRegistration,
                CivilActionType.BIRTH_REGISTRATION
        ));
    }

    /**
     * Регистрирует брак между двумя гражданами.
     *
     * @param man гражданин, вступающий в брак
     * @param woman гражданка, вступающая в брак
     * @param weddingRegistrationDate дата регистрации брака
     * @throws IllegalArgumentException если один из граждан уже женат
     */
    public void weddingRegistration(Citizen man, Citizen woman, Date weddingRegistrationDate) {
        citizenService.registerMarriage(man, woman);
        records.put(weddingRegistrationDate, new CivilActionRecord(
                weddingRegistrationDate,
                CivilActionType.WEDDING_REGISTRATION
        ));
    }

    /**
     * Регистрирует развод между двумя гражданами.
     *
     * @param man гражданин, участвующий в разводе
     * @param woman гражданка, участвующая в разводе
     * @param divorceRegistrationDate дата регистрации развода
     */
    public void registrationDivorce(Citizen man, Citizen woman, Date divorceRegistrationDate) {
        citizenService.registerDivorce(man, woman);
        records.put(divorceRegistrationDate, new CivilActionRecord(
                divorceRegistrationDate,
                CivilActionType.DIVORCE_REGISTRATION
        ));
    }

    /**
     * Получает статистику по гражданским действиям за указанную дату.
     *
     * @param date дата, для которой необходимо получить статистику
     * @return строка с статистикой гражданских действий
     */
    public String getStatisticsByDate(Date date) {
        return statisticsService.getStatisticsByDate(records, date, name);
    }
}
