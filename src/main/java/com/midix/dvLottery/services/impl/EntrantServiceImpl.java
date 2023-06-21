package com.midix.dvLottery.services.impl;

import com.midix.dvLottery.dto.EntrantDTO;
import com.midix.dvLottery.entity.Entrant;
import com.midix.dvLottery.mapper.EntrantMapper;
import com.midix.dvLottery.models.User;
import com.midix.dvLottery.repository.EntrantRepository;
import com.midix.dvLottery.services.EntrantService;
import com.midix.dvLottery.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
public class EntrantServiceImpl implements EntrantService {

    private EntrantRepository entrantRepository;
    private EntrantMapper entrantMapper;
    private UserService userService;

    public EntrantServiceImpl(EntrantRepository entrantRepository, EntrantMapper entrantMapper, UserService userService) {
        this.entrantRepository = entrantRepository;
        this.entrantMapper = entrantMapper;
        this.userService = userService;
    }

    @Override
    public Entrant loadEntrantByID(Long entrantId) {
        return entrantRepository.findById(entrantId).orElseThrow(()->new EntityNotFoundException("Entrant with ID" + entrantId + "not found"));
    }

    @Override
    public EntrantDTO loadEntrantByEmail(String email) {
        return entrantMapper.fromEntrant(entrantRepository.findEntrantByEmail(email));
    }

    @Override
    public EntrantDTO createEntrant(EntrantDTO entrantDTO) {
        User user = userService.createUser(entrantDTO.getUser().getEmail(), entrantDTO.getUser().getPassword());
        userService.assignRoleToUser(user.getEmail(), "Entrant");
        Entrant entrant = entrantMapper.fromEntrantDTO(entrantDTO);
        entrant.setUser(user);
        Entrant savedEntrant = entrantRepository.save(entrant);
        return entrantMapper.fromEntrant(savedEntrant);
    }

    @Override
    public EntrantDTO updateEntrant(EntrantDTO entrantDTO) {
        Entrant loadedEntrant = loadEntrantByID(entrantDTO.getEntrantId());
        Entrant entrant = entrantMapper.fromEntrantDTO(entrantDTO);
        entrant.setUser(loadedEntrant.getUser());
        Entrant updatedEntrant = entrantRepository.save(entrant);
        return entrantMapper.fromEntrant(updatedEntrant);
    }

    @Override
    public void deleteEntrant(Long entrantId) {
        Entrant entrant = loadEntrantByID(entrantId);
        if(entrant == null){
            throw new NullPointerException();
        }
        entrantRepository.deleteById(entrantId);
    }
}
