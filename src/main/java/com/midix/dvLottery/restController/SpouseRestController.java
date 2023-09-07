package com.midix.dvLottery.restController;

import com.midix.dvLottery.dto.SpouseDTO;
import com.midix.dvLottery.services.SpouseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spouses")
@CrossOrigin("*")
public class SpouseRestController {

    private SpouseService spouseService;

    public SpouseRestController(SpouseService spouseService) {
        this.spouseService = spouseService;
    }
    @PutMapping("/{spouseId}")
    @PreAuthorize("hasAuthority('Admin')")
    public SpouseDTO updateSpouse(@RequestBody SpouseDTO spouseDTO, @PathVariable Long spouseId){
        spouseDTO.setSpouse_id(spouseId);
        return spouseService.updateSpouse(spouseDTO);
    }
}
