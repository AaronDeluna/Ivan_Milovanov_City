package org.javaacademy.service;

import org.apache.commons.collections4.MultiValuedMap;
import org.javaacademy.entity.CivilActionRecord;

import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsService {

    /**
     * Получает статистику гражданских действий по указанной дате.
     *
     * @param date дата, для которой необходимо получить статистику
     * @return строка с статистикой гражданских действий
     */
    public String getStatisticsByDate(MultiValuedMap<Date, CivilActionRecord> records, Date date, String registryName) {
        StringBuilder stringBuilder = new StringBuilder("Статистика по ЗАГС: " + registryName + "\n");
        Map<String, Long> statistic = records.values().stream()
                .filter(record -> record.getValidityDate().equals(date))
                .collect(Collectors.groupingBy(
                        record -> record.getCivilActionType().getDescription(),
                        Collectors.counting()
                ));

        statistic.forEach((actionType, count) -> stringBuilder.append(actionType)
                .append(": ")
                .append(count)
                .append("\n"));

        return stringBuilder.toString();
    }
}
