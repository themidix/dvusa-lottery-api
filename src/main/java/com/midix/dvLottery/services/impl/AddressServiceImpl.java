package com.midix.dvLottery.services.impl;

import com.midix.dvLottery.dto.AddressDTO;
import com.midix.dvLottery.entity.Address;
import com.midix.dvLottery.entity.Entrant;
import com.midix.dvLottery.mapper.AddressMapper;
import com.midix.dvLottery.repository.AddressRepository;
import com.midix.dvLottery.repository.EntrantRepository;
import com.midix.dvLottery.services.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    private static Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final EntrantRepository entrantRepository;

    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper, EntrantRepository entrantRepository) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
        this.entrantRepository = entrantRepository;
    }

    @Override
    public Address loadAddressByID(Long addressId) {
         return addressRepository.findById(addressId).orElseThrow(()->{
            logger.error("error loading address");
            throw new EntityNotFoundException("Address with ID" + addressId+ " not found");
        });
    }

    @Override
    public AddressDTO addAddressDTO(AddressDTO addressDTO) {
        Address address = addressMapper.toAddressEntity(addressDTO);
//        Entrant entrant = entrantRepository.
//                findById(addressDTO.getEntrantDTO().getEntrantId()).orElseThrow(() -> new EntityNotFoundException("Entrant with ID " + addressDTO.getEntrantDTO().getEntrantId() + " Not Found"));
//        address.setEntrant(entrant);
        Address savedAddress = addressRepository.save(address);
        logger.info("Address successfully added");
        return addressMapper.toAddressDTO(savedAddress);
    }

    @Override
    public Address updateAddress(Address address) {
        return null;
    }

    @Override
    public void removeAddress(Long addressId) {

    }
}
