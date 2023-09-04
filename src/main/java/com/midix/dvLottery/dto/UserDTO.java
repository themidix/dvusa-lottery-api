package com.midix.dvLottery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long userId;
    private String email;
    private String password;
}
