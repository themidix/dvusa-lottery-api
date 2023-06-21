package com.midix.dvLottery.services;

import com.midix.dvLottery.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User loadUserByEmail(String email);

    User createUser(String email, String password);

    void assignRoleToUser(String email, String roleName);
}
