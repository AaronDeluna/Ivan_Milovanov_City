package org.javaacademy.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.javaaccademy.entity.Gender;
import org.javaaccademy.entity.Human;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Citizen extends Human {
    MaritalStatus maritalStatus = MaritalStatus.NOT_MARRIED;
    Human spouse;

    public Citizen(String name, String lastName, String surname, Gender gender) {
        super(name, lastName, surname, gender);
    }

    /**
     * Выполняет развод гражданина.
     */
    public void divorce(Citizen secondCitizen) {
        if (this.getSpouse() != null && secondCitizen.getSpouse() != null) {
            this.setSpouse(null);
            secondCitizen.setSpouse(null);
            this.setMaritalStatus(MaritalStatus.DIVORCED);
            secondCitizen.setMaritalStatus(MaritalStatus.DIVORCED);
        }
    }

    /**
     * Выполняет регистрацию брака гражданина.
     */
    public void marriage(Citizen secondCitizen) {
        if (this.getSpouse() == null && secondCitizen.getSpouse() == null) {
            this.setSpouse(secondCitizen);
            secondCitizen.setSpouse(this);
            this.setMaritalStatus(MaritalStatus.MARRIED);
            secondCitizen.setMaritalStatus(MaritalStatus.MARRIED);
        }
    }
}
