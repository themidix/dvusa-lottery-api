package com.midix.dvLottery.dto;
import com.midix.dvLottery.constant.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildDTO {

    private Long child_id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Gender gender;
    private Date birthDate;
    private String birthCity;
    private String countryOfBirth;
    private EntrantDTO entrantDTO;
}
