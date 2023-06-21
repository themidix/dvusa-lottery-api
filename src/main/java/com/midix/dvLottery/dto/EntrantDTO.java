package com.midix.dvLottery.dto;

import com.midix.dvLottery.models.User;

import javax.persistence.*;

public class EntrantDTO {

    private Long entrantId;

    private String firstName;

    private String lastName;

    private String middleName;

    private String gender;

    private UserDTO user;

    public Long getEntrantId() {
        return entrantId;
    }

    public void setEntrantId(Long entrantId) {
        this.entrantId = entrantId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
