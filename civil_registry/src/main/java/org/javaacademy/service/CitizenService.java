package org.javaacademy.service;

import org.javaacademy.entity.Citizen;
import org.javaacademy.entity.MaritalStatus;

public class CitizenService {

    /**
     * Регистрирует брак между двумя гражданами.
     *
     * @param man гражданин, вступающий в брак
     * @param woman гражданка, вступающая в брак
     * @throws IllegalArgumentException если один из партнеров уже состоит в браке
     */
    public void registerMarriage(Citizen man, Citizen woman) {
        validateMarriage(man, woman);
        man.marriage(woman);
    }

    /**
     * Проверяет, могут ли граждане зарегистрировать брак.
     *
     * @param man гражданин, вступающий в брак
     * @param woman гражданка, вступающая в брак
     * @throws IllegalArgumentException если один из граждан уже женат
     */
    private void validateMarriage(Citizen man, Citizen woman) {
        if (man.getMaritalStatus() == MaritalStatus.MARRIED || woman.getMaritalStatus() == MaritalStatus.MARRIED) {
            throw new IllegalArgumentException(
                    "Ошибка: Брак не может быть зарегистрирован, так как один из партнеров уже состоит в браке."
            );
        }
    }

    /**
     * Регистрирует развод для двух граждан.
     *
     * @param man гражданин, разводящийся
     * @param woman гражданка, разводящаяся
     */
    public void registerDivorce(Citizen man, Citizen woman) {
        man.divorce(woman);
    }
}

