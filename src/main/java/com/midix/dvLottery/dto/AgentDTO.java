package com.midix.dvLottery.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentDTO {
    private Long agentId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String agentEmail;
    private String agentPhoneNumber;
    private DVBusinessDTO dvBusinessDTO;
    private UserDTO userDTO;
}
