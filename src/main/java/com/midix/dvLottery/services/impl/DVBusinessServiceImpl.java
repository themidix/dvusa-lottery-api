package com.midix.dvLottery.services.impl;

import com.midix.dvLottery.dto.AddressDTO;
import com.midix.dvLottery.dto.DVBusinessDTO;
import com.midix.dvLottery.entity.*;
import com.midix.dvLottery.exception.EmailDoNotMatchException;
import com.midix.dvLottery.mapper.AddressMapper;
import com.midix.dvLottery.mapper.DVBusinessMapper;
import com.midix.dvLottery.repository.DVBusinessRepository;
import com.midix.dvLottery.services.DVBusinessService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.stream.Collectors;
@Slf4j
@Service
@Transactional
public class DVBusinessServiceImpl implements DVBusinessService {

    private static Logger logger = LoggerFactory.getLogger(DVBusinessServiceImpl.class);
    private DVBusinessRepository dvBusinessRepository;
    private DVBusinessMapper dvBusinessMapper;
    public DVBusinessServiceImpl(DVBusinessRepository dvBusinessRepository, DVBusinessMapper dvBusinessMapper) {
        this.dvBusinessRepository = dvBusinessRepository;
        this.dvBusinessMapper = dvBusinessMapper;
    }
    @Override
    public DvBusiness loadDVBusinessById(Long dvBusinessId) {
        return dvBusinessRepository.findById(dvBusinessId).orElseThrow(()->{
            logger.error("error loading DV Business");
            throw new EntityNotFoundException("Unable to DV Business with ID " + dvBusinessId );
        });
    }
    @Override
    public Page<DVBusinessDTO> loadDVBusinessByName(String name, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<DvBusiness> dvBusinessPage = dvBusinessRepository.findDvBusinessByName(name, pageRequest);
        logger.info("Successfully loaded DV Business ");
        return new PageImpl<>(dvBusinessPage.getContent().stream().map(dvBusiness -> dvBusinessMapper.toDVBusinessDTO(dvBusiness)).collect(Collectors.toList()), pageRequest, dvBusinessPage.getTotalElements());
    }
    @Override
    public DVBusinessDTO showDVBusinessDTOByEmail(String email) {
        return dvBusinessMapper.toDVBusinessDTO(dvBusinessRepository.findDvBusinessByEmail(email));
    }
    @Override
    public DVBusinessDTO createDVBusiness(DVBusinessDTO businessDTO) throws EmailDoNotMatchException {
        //checkIfEmailMatch(businessDTO);
        DvBusiness dvBusiness = dvBusinessMapper.toDVBusiness(businessDTO);
//        AddressMapper addressMapper = new AddressMapper();
//        AddressDTO addressDTO = businessDTO.getBusinessAddress();
//        Address address = addressMapper.toAddressEntity(addressDTO);
//        dvBusiness.setBusinessAddress(address);
        DvBusiness savedDVBusiness = dvBusinessRepository.save(dvBusiness);
        logger.info("DV Business successfully created");
        return dvBusinessMapper.toDVBusinessDTO(savedDVBusiness);
    }
    @Override
    public DVBusinessDTO updateDVBusiness(DVBusinessDTO businessDTO) {
        DvBusiness existingDVBusiness = loadDVBusinessById(businessDTO.getDvBusinessId());
        DvBusiness dvBusiness = dvBusinessMapper.toDVBusiness(businessDTO);
        dvBusiness.setDvBusinessId(existingDVBusiness.getDvBusinessId());
        DvBusiness updatedDVBusiness = dvBusinessRepository.save(dvBusiness);
        return dvBusinessMapper.toDVBusinessDTO(updatedDVBusiness);
    }
    private void checkIfEmailMatch(DVBusinessDTO dvBusinessDTO) throws EmailDoNotMatchException {
        DvBusiness dvBusiness = dvBusinessRepository.findDvBusinessByEmail(dvBusinessDTO.getBusinessEmail());
        if (dvBusiness == null || !dvBusiness.getBusinessEmail().equals(dvBusinessDTO.getBusinessEmail())) {
            logger.error("Unable to create DV Business");
            throw new EmailDoNotMatchException("Email does not match");
        }
    }
}
