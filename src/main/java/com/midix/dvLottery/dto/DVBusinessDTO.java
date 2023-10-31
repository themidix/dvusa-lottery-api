package com.midix.dvLottery.dto;

import com.midix.dvLottery.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DVBusinessDTO {
    private Long dvBusinessId;
    private String businessName;
    private String businessAddress;
    private String businessEmail;
    private String businessPhoneNumber;
}
