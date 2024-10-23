package org.javaaccademy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal = true)
public enum Gender {
    MALE("Мужской"),
    FEMALE("Женский"),
    ;
    String gender;
}
