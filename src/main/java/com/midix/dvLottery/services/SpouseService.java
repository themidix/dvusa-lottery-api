package com.midix.dvLottery.services;

import com.midix.dvLottery.dto.SpouseDTO;
import com.midix.dvLottery.entity.Spouse;
import com.midix.dvLottery.exception.EmailDoNotMatchException;
import org.springframework.data.domain.Page;

public interface SpouseService {

    Spouse loadSpouseByID(Long entrantId);
    Page<SpouseDTO> loadSpouseByName(String name, int page, int size);
    SpouseDTO createSpouse(SpouseDTO spouseDTO) throws EmailDoNotMatchException;
    SpouseDTO updateSpouse(SpouseDTO spouseDTO);
    void deleteSpouse(Long spouseId);
}
