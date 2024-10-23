package org.javaacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Тип гражданского действия.
 */
@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal = true)
public enum CivilActionType {

    BIRTH_REGISTRATION("Регистрация рождения"),
    WEDDING_REGISTRATION("Регистрация свадьбы"),
    DIVORCE_REGISTRATION("Регистрация развода"),
    ;

    String description;
}
