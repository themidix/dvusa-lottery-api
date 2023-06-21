package com.midix.dvLottery.runner;

import com.midix.dvLottery.models.User;
import com.midix.dvLottery.services.RoleService;
import com.midix.dvLottery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;


    @Override
    public void run(String... args) throws Exception {
       createRoles();
        createAdmin();
    }

    private void createAdmin() {
        User user = userService.createUser("admin@gmail.com", "12345678");
        if(user != null)
            userService.assignRoleToUser("admin@gmail.com", "Admin");
    }

    private void createRoles() {
        Arrays.asList("Admin", "Entrant", "Customer").forEach(role -> roleService.createRole(role));
    }
}
