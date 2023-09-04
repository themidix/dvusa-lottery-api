package com.midix.dvLottery.mapper;

import com.midix.dvLottery.dto.UserDTO;
import com.midix.dvLottery.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUserEntity(UserDTO userDTO){
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        return user;
    }

    public UserDTO toUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        return userDTO;
    }
}
