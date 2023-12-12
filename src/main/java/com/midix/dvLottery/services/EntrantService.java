package com.midix.dvLottery.services;

import com.midix.dvLottery.dto.EntrantDTO;
import com.midix.dvLottery.entity.Entrant;
import com.midix.dvLottery.exception.EmailDoNotMatchException;
import org.springframework.data.domain.Page;

public interface EntrantService {

    Entrant loadEntrantByID(Long entrantId);
    Page<EntrantDTO> loadEntrantByName(String name, int page, int size);
    EntrantDTO loadEntrantByEmail(String email);
    EntrantDTO createEntrant(EntrantDTO entrantDTO) throws EmailDoNotMatchException;
   EntrantDTO updateEntrant(EntrantDTO entrantDTO);
    //EntrantDTO updateEntrant(Long entrantId, EntrantDTO entrantDTO);
    void deleteEntrant(Long entrantId);
}