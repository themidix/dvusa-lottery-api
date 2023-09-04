package com.midix.dvLottery.services.impl;

import com.midix.dvLottery.entity.Role;
import com.midix.dvLottery.entity.User;
import com.midix.dvLottery.repository.RoleRepository;
import com.midix.dvLottery.repository.UserRepository;
import com.midix.dvLottery.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
@Slf4j
@Service
@Transactional
public class UserServiceImpl  implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User loadUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User createUser(String email, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        return userRepository.save(new User(email,encodedPassword));
    }

    @Override
    public void assignRoleToUser(String email, String roleName) {
        User user = loadUserByEmail(email);
        Role role = roleRepository.findByName(roleName);
        user.assignRoleToUser(role);
    }

    @Override
    public void removeRoleFromUser(String email, String roleName) {
        User user = loadUserByEmail(email);
        Role role = roleRepository.findByName(roleName);
        user.removeRoleFromUser(role);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->{
            logger.error("error loading entrant");
            throw new EntityNotFoundException("User with ID" + userId + " not found");
        });
        userRepository.deleteById(user.getUserId());
        logger.info("User successfully removed");
    }
}
