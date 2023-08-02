package com.midix.dvLottery.mapper;

import com.midix.dvLottery.dto.EntrantDTO;
import com.midix.dvLottery.entity.Entrant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EntrantMapper {

    public EntrantDTO toEntrantDTO(Entrant entrant){
        EntrantDTO entrantDTO = new EntrantDTO();
        BeanUtils.copyProperties(entrant,entrantDTO);
        return entrantDTO;
    }

    public Entrant toEntrantEntity(EntrantDTO entrantDTO){
        Entrant entrant = new Entrant();
        BeanUtils.copyProperties(entrantDTO,entrant);
        return entrant;
    }
}
