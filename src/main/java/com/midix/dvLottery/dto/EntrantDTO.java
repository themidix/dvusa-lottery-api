package com.midix.dvLottery.dto;

import com.midix.dvLottery.constant.EducationLevel;
import com.midix.dvLottery.constant.Gender;
import com.midix.dvLottery.constant.MaritalStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntrantDTO {
    private Long entrantId;
    private String firstName;
    private String lastName;
    private String middleName;
    private Gender gender;
    private Date birthDate;
    private String birthCity;
    private String countryOfBirth;
    private String eligibilityCountry;
    private String entrantPhotograph;
    private SpouseDTO spouseDTO;
    private AddressDTO address;
    private String countryOfResidence;
    private String phoneNumber;
    private String emailAddress;
    private EducationLevel educationLevel;
    private MaritalStatus maritalStatus;
    private int numberOfChildren;
    private Set<ChildDTO> childSet;
    private UserDTO user;
}
