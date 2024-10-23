package org.javaaccademy.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter(value = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Human {
    @NonNull
    String name;
    @NonNull
    String lastName;
    @NonNull
    String surname;
    @NonNull
    Gender gender;

    Human father;
    Human mother;

    List<Human> childrenList = new ArrayList<>();

    public Human(String name, String lastName, String surname, Gender gender) {
        this.name = capitalize(name);
        this.lastName = capitalize(lastName);
        this.surname = capitalize(surname);
        this.gender = gender;
    }

    /**
     * Преобразует первую букву строки в верхний регистр.
     *
     * @param text исходный текст для преобразования
     * @return строка с первой буквой в верхнем регистре
     */
    private String capitalize(String text) {
        return StringUtils.capitalize(text);
    }

    /**
     * Устанавливает родителей для данного человека.
     *
     * <p>Добавляет текущего человека в список детей у отца и матери.</p>
     *
     * @param father объект Human, представляющий отца
     * @param mother объект Human, представляющий мать
     */
    public void setParents(Human father, Human mother) {
        this.father = father;
        this.mother = mother;
        father.getChildrenList().add(this);
        mother.getChildrenList().add(this);
    }

    /**
     * Создает ребенка с заданными именем, фамилией, отчеством и полом.
     *
     * <p>Проверяет, чтобы родители имели разные гендеры, и устанавливает их в качестве родителей для ребенка.</p>
     *
     * @param name имя ребенка
     * @param lastName фамилия ребенка
     * @param surname отчество ребенка
     * @param gender пол ребенка
     * @param secondParent второй родитель ребенка
     * @return новый объект Human, представляющий ребенка
     * @throws IllegalArgumentException если родители имеют одинаковый пол
     */
    public Human createChild(String name, String lastName, String surname, Gender gender, Human secondParent) {
        if (this.gender == secondParent.gender) {
            throw new IllegalArgumentException("Ошибка: Гендер должен быть разный!");
        }

        Human child = new Human(name, lastName, surname, gender);
        if (this.gender == Gender.MALE) {
            child.setParents(this, secondParent);
        } else {
            child.setParents(secondParent, this);
        }
        return child;
    }

    /**
     * Возвращает полное имя в формате "отчество, имя, фамилия".
     *
     * @return строка, представляющая полное имя
     */
    public String getFulName() {
        return String.format("%s, %s, %s", surname, name, lastName);
    }
}
