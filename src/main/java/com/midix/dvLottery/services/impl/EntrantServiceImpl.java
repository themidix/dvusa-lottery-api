package com.midix.dvLottery.services.impl;

import com.midix.dvLottery.dto.EntrantDTO;
import com.midix.dvLottery.entity.Entrant;
import com.midix.dvLottery.exception.EmailDoNotMatchException;
import com.midix.dvLottery.mapper.EntrantMapper;
import com.midix.dvLottery.entity.User;
import com.midix.dvLottery.repository.EntrantRepository;
import com.midix.dvLottery.services.EntrantService;
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
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class EntrantServiceImpl implements EntrantService {

    private static Logger logger = LoggerFactory.getLogger(EntrantServiceImpl.class);
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
        return entrantRepository.findById(entrantId).orElseThrow(()->{
            logger.error("error loading entrant");
            throw new EntityNotFoundException("Entrant with ID" + entrantId + "not found");
        });
    }

    @Override
    public Page<EntrantDTO> loadEntrantByName(String name, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Entrant> entrantPage = entrantRepository.findStudentsByName(name, pageRequest);
        logger.info("Successfully load Entrants");
        return new PageImpl<>(entrantPage.getContent().stream().map(entrant -> entrantMapper.toEntrantDTO(entrant)).collect(Collectors.toList()), pageRequest, entrantPage.getTotalElements());
    }

    @Override
    public EntrantDTO loadEntrantByEmail(String email) {
        return entrantMapper.toEntrantDTO(entrantRepository.findEntrantByEmail(email));
    }
    @Override
    public EntrantDTO createEntrant(EntrantDTO entrantDTO) throws EmailDoNotMatchException {
            checkIfEmailMatch(entrantDTO);
            String email = entrantDTO.getUser().getEmail();
            User user = userService.createUser(email, entrantDTO.getUser().getPassword());
            userService.assignRoleToUser(user.getEmail(), "Entrant");
            Entrant entrant = entrantMapper.toEntrantEntity(entrantDTO);
            entrant.setUser(user);
            Entrant savedEntrant = entrantRepository.save(entrant);
            logger.info("Entrant successfully created");
            return entrantMapper.toEntrantDTO(savedEntrant);
    }
    @Override
    public EntrantDTO updateEntrant(EntrantDTO entrantDTO) {
        Entrant loadedEntrant = loadEntrantByID(entrantDTO.getEntrantId());
        Entrant entrant = entrantMapper.toEntrantEntity(entrantDTO);
        entrant.setUser(loadedEntrant.getUser());
        Entrant updatedEntrant = entrantRepository.save(entrant);
        logger.info("Entrant successfully updated");
        return entrantMapper.toEntrantDTO(updatedEntrant);
    }
//    @Override
//    public void deleteEntrant(Long entrantId) {
//        Entrant entrant = loadEntrantByID(entrantId);
//        if(entrant == null){
//            logger.error("unable to delete entrant");
//            throw new NullPointerException();
//        }
//        entrantRepository.deleteById(entrantId);
//        logger.info("Successfully deleted entrant");
//    }
    @Override
    public void deleteEntrant(Long entrantId) {
        Entrant entrant = loadEntrantByID(entrantId);
        if (entrant == null) {
            logger.error("Unable to delete entrant");
            throw new NullPointerException();
        }

        // Remove the user associated with the entrant
        User user = entrant.getUser();
        if (user != null) {
            userService.removeRoleFromUser(user.getEmail(), "Entrant");
            userService.deleteUser(user.getUserId());
        }

        // Delete the entrant
        entrantRepository.deleteById(entrantId);
        logger.info("Successfully deleted entrant with ID: " + entrantId);
    }
    private void checkIfEmailMatch(EntrantDTO entrantDTO) throws EmailDoNotMatchException {
        if(!entrantDTO.getUser().getEmail().equals(entrantDTO.getEmailAddress())){
            logger.error("Unable to create Entrant");
            throw new EmailDoNotMatchException("Email does not match");
        }
    }
}
