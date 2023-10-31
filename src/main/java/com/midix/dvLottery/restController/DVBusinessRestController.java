package com.midix.dvLottery.restController;

import com.midix.dvLottery.dto.DVBusinessDTO;
import com.midix.dvLottery.exception.EmailDoNotMatchException;
import com.midix.dvLottery.services.DVBusinessService;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dvBusinesses")
@CrossOrigin("*")
public class DVBusinessRestController {

    private DVBusinessService dvBusinessService;

    public DVBusinessRestController(DVBusinessService dvBusinessService) {
        this.dvBusinessService = dvBusinessService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('Admin')")
    public DVBusinessDTO createDVBusiness(@RequestBody DVBusinessDTO dvBusinessDTO) throws EmailDoNotMatchException {
//        DVBusinessDTO dvBusiness = dvBusinessService.showDVBusinessDTOByEmail(dvBusinessDTO.getBusinessEmail());
//        if(dvBusiness != null)
//            throw new RuntimeException("Email already exist");
        return dvBusinessService.createDVBusiness(dvBusinessDTO);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('Admin')")
    public Page<DVBusinessDTO> searchDVBusiness(@RequestParam(name = "keyword", defaultValue = "") String keyword,
                                         @RequestParam(name = "page", defaultValue = "0") int page,
                                         @RequestParam(name = "size", defaultValue = "5") int size) {
        return dvBusinessService.loadDVBusinessByName(keyword, page, size);
    }

    @PutMapping("/{dvBusinessId}")
    @PreAuthorize("hasAuthority('Admin')")
    public DVBusinessDTO updateDVBusiness(@RequestBody DVBusinessDTO dvBusinessDTO, @PathVariable Long dvBusinessId) {
        dvBusinessDTO.setDvBusinessId(dvBusinessId);
        return dvBusinessService.updateDVBusiness(dvBusinessDTO);
    }

    @GetMapping("/findByEmail")
    @PreAuthorize("hasAuthority('Admin')")
    public DVBusinessDTO loadDVBusinessByEmail(@RequestParam(name = "email", defaultValue = "") String email) {
        return dvBusinessService.showDVBusinessDTOByEmail(email);
    }
}
