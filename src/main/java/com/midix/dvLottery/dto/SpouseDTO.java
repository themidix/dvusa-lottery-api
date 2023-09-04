package com.midix.dvLottery.dto;

import com.midix.dvLottery.constant.Gender;
import com.midix.dvLottery.entity.Entrant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpouseDTO {
    private Long spouse_id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Gender gender;
    private Date birthDate;
    private String birthCity;
    private String countryOfBirth;
    private String spousePhoto;
//    private EntrantDTO entrantDTO;
}
