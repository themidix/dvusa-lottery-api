package com.midix.dvLottery.restController;

import com.midix.dvLottery.dto.ChildDTO;
import com.midix.dvLottery.entity.Child;
import com.midix.dvLottery.services.ChildService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/children")
@CrossOrigin("*")
public class ChildController {

    private ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @PreAuthorize("hasAuthority('Admin')")
    @PutMapping("/{childId}")
    public ChildDTO updateChild(@RequestBody ChildDTO childDTO,@PathVariable Long childId) {
        childDTO.setChildId(childId);
        return childService.updateChild(childDTO);
    }
}
