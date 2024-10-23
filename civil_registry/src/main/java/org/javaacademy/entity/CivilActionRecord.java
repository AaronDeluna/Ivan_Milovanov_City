package org.javaacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.javaaccademy.entity.Human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Запись гражданского действия.
 */
@Getter
@FieldDefaults(makeFinal = true)
@AllArgsConstructor
public class CivilActionRecord {
    Date validityDate;
    CivilActionType civilActionType;
    List<Human> humanList = new ArrayList<>();
}
