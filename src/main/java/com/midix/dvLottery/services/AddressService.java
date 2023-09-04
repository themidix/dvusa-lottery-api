package com.midix.dvLottery.services;

import com.midix.dvLottery.dto.AddressDTO;
import com.midix.dvLottery.entity.Address;

public interface AddressService {
    Address loadAddressByID(Long entrantId);
    AddressDTO addAddressDTO(AddressDTO addressDTO);
    Address updateAddress(Address address);
    void removeAddress(Long addressId);
}
