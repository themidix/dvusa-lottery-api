package com.midix.dvLottery.restController;

import com.midix.dvLottery.dto.EntrantDTO;
import com.midix.dvLottery.entity.User;
import com.midix.dvLottery.exception.EmailDoNotMatchException;
import com.midix.dvLottery.services.EntrantService;
import com.midix.dvLottery.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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
    public EntrantDTO createEntrant(@RequestBody EntrantDTO entrantDTO) throws EmailDoNotMatchException {
        User user = userService.loadUserByEmail(entrantDTO.getUser().getEmail());
        if(user != null)
            throw new RuntimeException("Email already exist");
        return entrantService.createEntrant(entrantDTO);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('Admin')")
    public Page<EntrantDTO> searEntrants(@RequestParam(name = "keyword", defaultValue = "") String keyword,
                                           @RequestParam(name = "page", defaultValue = "0") int page,
                                           @RequestParam(name = "size", defaultValue = "5") int size) {
        return entrantService.loadEntrantByName(keyword, page, size);
    }
    @DeleteMapping("/{entrantId}")
    @PreAuthorize("hasAuthority('Admin')")
    public void removeEntrant(@PathVariable Long entrantId) {
        entrantService.deleteEntrant(entrantId);
    }
    @PutMapping("/{entrantId}")
    @PreAuthorize("hasAuthority('Admin')")
    public EntrantDTO updateEntrant(@RequestBody EntrantDTO entrantDTO, @PathVariable Long entrantId) {
        entrantDTO.setEntrantId(entrantId);
        return entrantService.updateEntrant(entrantDTO);
    }
    @GetMapping("/findByEmail")
    @PreAuthorize("hasAuthority('Entrant')")
    public EntrantDTO loadEntrantByEmail(@RequestParam(name = "email", defaultValue = "") String email) {
        return entrantService.loadEntrantByEmail(email);
    }

//    @PutMapping("/{entrantId}")
//    @PreAuthorize("hasAuthority('Admin')")
//    public ResponseEntity<EntrantDTO> updateEntrant(
//            @PathVariable Long entrantId,
//            @RequestBody EntrantDTO entrantDTO) {
//        EntrantDTO updatedEntrant = entrantService.updateEntrant(entrantId, entrantDTO);
//        return ResponseEntity.ok(updatedEntrant);
//    }
}
