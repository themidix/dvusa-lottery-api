package com.midix.dvLottery.mapper;

import com.midix.dvLottery.dto.SpouseDTO;
import com.midix.dvLottery.entity.Spouse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class SpouseMapper {

    public SpouseDTO toSpouseDTO(Spouse spouse){
        SpouseDTO spouseDTO = new SpouseDTO();
        BeanUtils.copyProperties(spouse,spouseDTO);
        return  spouseDTO;
    }
    public Spouse toSpouseEntity(SpouseDTO spouseDTO){
        Spouse spouse = new Spouse();
        BeanUtils.copyProperties(spouseDTO,spouse);
        return spouse;
    }
}
