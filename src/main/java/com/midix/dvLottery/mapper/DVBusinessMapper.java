package com.midix.dvLottery.mapper;

import com.midix.dvLottery.dto.DVBusinessDTO;
import com.midix.dvLottery.entity.DvBusiness;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DVBusinessMapper {

    public DVBusinessDTO toDVBusinessDTO(DvBusiness dvBusiness){
        DVBusinessDTO dvBusinessDTO = new DVBusinessDTO();
        BeanUtils.copyProperties(dvBusiness,dvBusinessDTO);
        return  dvBusinessDTO;
    }
    public DvBusiness toDVBusiness(DVBusinessDTO dvBusinessDTO){
        DvBusiness dvBusiness = new DvBusiness();
        BeanUtils.copyProperties(dvBusinessDTO,dvBusiness);
        return dvBusiness;
    }
}
