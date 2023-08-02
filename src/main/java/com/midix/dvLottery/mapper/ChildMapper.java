package com.midix.dvLottery.mapper;

import com.midix.dvLottery.dto.ChildDTO;
import com.midix.dvLottery.entity.Child;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ChildMapper {

    public ChildDTO toChildDTO(Child child){
        ChildDTO childDTO = new ChildDTO();
        BeanUtils.copyProperties(child,childDTO);
        return  childDTO;
    }

    public Child toChildEntity(ChildDTO childDTO){
        Child child = new Child();
        BeanUtils.copyProperties(childDTO,child);
        return child;
    }
}
