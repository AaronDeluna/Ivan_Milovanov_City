package org.javaacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Семейное положение.
 */
@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal = true)
public enum MaritalStatus {
    NOT_MARRIED("Не женат"),
    MARRIED("Женат"),
    DIVORCED("В разводе"),
    ;

    String description;
}
