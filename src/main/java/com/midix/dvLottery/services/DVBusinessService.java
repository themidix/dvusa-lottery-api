package com.midix.dvLottery.services;

import com.midix.dvLottery.dto.DVBusinessDTO;
import com.midix.dvLottery.dto.EntrantDTO;
import com.midix.dvLottery.entity.DvBusiness;
import com.midix.dvLottery.entity.Entrant;
import com.midix.dvLottery.exception.EmailDoNotMatchException;
import org.springframework.data.domain.Page;

public interface DVBusinessService {

    DvBusiness loadDVBusinessById(Long dvBusinessId);
    Page<DVBusinessDTO> loadDVBusinessByName(String name, int page, int size);
    DVBusinessDTO showDVBusinessDTOByEmail(String email);
    DVBusinessDTO createDVBusiness(DVBusinessDTO businessDTO) throws EmailDoNotMatchException;
    DVBusinessDTO updateDVBusiness(DVBusinessDTO businessDTO);

}
