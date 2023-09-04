package com.midix.dvLottery.services.impl;

import com.midix.dvLottery.dto.SpouseDTO;
import com.midix.dvLottery.entity.Spouse;
import com.midix.dvLottery.exception.EmailDoNotMatchException;
import com.midix.dvLottery.mapper.SpouseMapper;
import com.midix.dvLottery.repository.AddressRepository;
import com.midix.dvLottery.repository.SpouseRepository;
import com.midix.dvLottery.services.SpouseService;
import com.midix.dvLottery.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class SpouseServiceImp implements SpouseService {
    private static Logger logger = LoggerFactory.getLogger(SpouseServiceImp.class);
    private SpouseRepository spouseRepository;
    private SpouseMapper spouseMapper;

    public SpouseServiceImp(SpouseRepository spouseRepository, SpouseMapper spouseMapper) {
        this.spouseRepository = spouseRepository;
        this.spouseMapper = spouseMapper;
    }

    @Override
    public Spouse loadSpouseByID(Long spouseId) {
        return  spouseRepository.findById(spouseId).orElseThrow(()->{
            logger.error("error loading entrant");
            throw new EntityNotFoundException("Spouse with ID " + spouseId + " not found");
        });
    }

    @Override
    public Page<SpouseDTO> loadSpouseByName(String name, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Spouse> spousePage = spouseRepository.findSpouseByName(name, pageRequest);
        logger.info("Successfully load Entrants");
        return new PageImpl<>(spousePage.getContent().stream().map(spouse -> spouseMapper.toSpouseDTO(spouse)).collect(Collectors.toList()), pageRequest, spousePage.getTotalElements());
    }

    @Override
    public SpouseDTO createSpouse(SpouseDTO spouseDTO) throws EmailDoNotMatchException {
        Spouse spouse = spouseMapper.toSpouseEntity(spouseDTO);
        Spouse savedSpouse = spouseRepository.save(spouse);
        return spouseMapper.toSpouseDTO(savedSpouse);
    }

    @Override
    public SpouseDTO updateSpouse(SpouseDTO spouseDTO) {
        Long spouseId = spouseDTO.getSpouse_id();
        Optional<Spouse> optionalSpouse = spouseRepository.findById(spouseId);
        if(!optionalSpouse.isPresent()){
            log.error("Unable to find spouse with Id " + spouseId);
        }
        spouseDTO.setSpouse_id(optionalSpouse.get().getSpouse_id());
        Spouse updatedSpouse = spouseMapper.toSpouseEntity(spouseDTO);
        Spouse savedSpouse = spouseRepository.save(updatedSpouse);
        logger.info("Successfully updated Spouse with ID: " + spouseId);
        return spouseMapper.toSpouseDTO(savedSpouse);
    }

    @Override
    public void deleteSpouse(Long spouseId) {
        spouseRepository.deleteById(spouseId);
    }
}
