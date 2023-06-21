package com.midix.dvLottery.services;

import com.midix.dvLottery.dto.EntrantDTO;
import com.midix.dvLottery.entity.Entrant;

public interface EntrantService {

    Entrant loadEntrantByID(Long entrantId);
    EntrantDTO loadEntrantByEmail(String email);
    EntrantDTO createEntrant(EntrantDTO entrantDTO);
    EntrantDTO updateEntrant(EntrantDTO entrantDTO);
    void deleteEntrant(Long entrantId);
}
