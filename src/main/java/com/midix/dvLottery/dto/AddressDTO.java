package com.midix.dvLottery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private Long addressId;
    private String inCareOf;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String district;
    private String postalCode;
    private String country;
//    private EntrantDTO entrantDTO;
}
