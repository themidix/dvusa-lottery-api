package com.midix.dvLottery.mapper;

import com.midix.dvLottery.dto.AddressDTO;
import com.midix.dvLottery.entity.Address;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address toAddressEntity(AddressDTO addressDTO){
        Address address = new Address();
        BeanUtils.copyProperties(addressDTO,address);
        return address;
    }

    public AddressDTO toAddressDTO(Address address){
        AddressDTO addressDTO = new AddressDTO();
        BeanUtils.copyProperties(address,addressDTO);
        return addressDTO;
    }
}
