package com.midix.dvLottery.restController;

import com.midix.dvLottery.dto.EntrantDTO;
import com.midix.dvLottery.models.User;
import com.midix.dvLottery.services.EntrantService;
import com.midix.dvLottery.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entrants")
@CrossOrigin("*")
public class EntrantRestController {

    private EntrantService entrantService;
    private UserService userService;

    public EntrantRestController(EntrantService entrantService, UserService userService) {
        this.entrantService = entrantService;
        this.userService = userService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('Admin')")
    public EntrantDTO createEntrant(@RequestBody EntrantDTO entrantDTO){
        User user = userService.loadUserByEmail(entrantDTO.getUser().getEmail());
        if(user != null)
            throw new RuntimeException("Email already exist");
        return entrantService.createEntrant(entrantDTO);
    }
}
