package com.midix.dvLottery.services.impl;

import com.midix.dvLottery.dto.AddressDTO;
import com.midix.dvLottery.dto.ChildDTO;
import com.midix.dvLottery.dto.EntrantDTO;
import com.midix.dvLottery.dto.SpouseDTO;
import com.midix.dvLottery.entity.*;
import com.midix.dvLottery.exception.EmailDoNotMatchException;
import com.midix.dvLottery.mapper.AddressMapper;
import com.midix.dvLottery.mapper.ChildMapper;
import com.midix.dvLottery.mapper.EntrantMapper;
import com.midix.dvLottery.mapper.SpouseMapper;
import com.midix.dvLottery.repository.ChildRepository;
import com.midix.dvLottery.repository.EntrantRepository;
import com.midix.dvLottery.repository.SpouseRepository;
import com.midix.dvLottery.services.ChildService;
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
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
@Slf4j
@Service
@Transactional
public class EntrantServiceImpl implements EntrantService {
    private static Logger logger = LoggerFactory.getLogger(EntrantServiceImpl.class);
    private EntrantRepository entrantRepository;
    private EntrantMapper entrantMapper;
    private UserService userService;
    private ChildRepository childRepository;
    private ChildService childService;

    private SpouseRepository spouseRepository;

    public EntrantServiceImpl(EntrantRepository entrantRepository, EntrantMapper entrantMapper, UserService userService, ChildRepository childRepository, ChildService childService, SpouseRepository spouseRepository) {
        this.entrantRepository = entrantRepository;
        this.entrantMapper = entrantMapper;
        this.userService = userService;
        this.childRepository = childRepository;
        this.childService = childService;
        this.spouseRepository = spouseRepository;
    }
    @Override
    public EntrantDTO createEntrant(EntrantDTO entrantDTO) throws EmailDoNotMatchException {
        checkIfEmailMatch(entrantDTO);
        String email = entrantDTO.getUser().getEmail();
        User user = userService.createUser(email, entrantDTO.getUser().getPassword());
        userService.assignRoleToUser(user.getEmail(), "Entrant");
        Entrant entrant = entrantMapper.toEntrantEntity(entrantDTO);
        AddressDTO addressDTO = entrantDTO.getAddress();
        SpouseDTO spouseDTO = entrantDTO.getSpouseDTO();
        SpouseMapper spouseMapper = new SpouseMapper();
        Spouse savedSpouse = spouseMapper.toSpouseEntity(spouseDTO);
        //Spouse savedSpouse = spouseRepository.save(spouse);
        AddressMapper addressMapper = new AddressMapper();
        Address address = addressMapper.toAddressEntity(addressDTO);

        ChildMapper childMapper = new ChildMapper();
        Set<Child> childSet = entrantDTO.getChildSet()
                .stream()
                .map(childDTO ->{
                    //return childRepository.save(childMapper.toChildEntity(childDTO));
                   return childMapper.toChildEntity(childDTO);
                        }
                )
                .collect(Collectors.toSet());
        entrant.setUser(user);
        entrant.setAddress(address);
        entrant.setSpouse(savedSpouse);
        entrant.setChildSet(childSet);
        Entrant savedEntrant = entrantRepository.save(entrant);
        logger.info("Entrant successfully created");
        return entrantMapper.toEntrantDTO(savedEntrant);
    }
    @Override
    public EntrantDTO updateEntrant(EntrantDTO entrantDTO) {
        Entrant loadedEntrant = loadEntrantByID(entrantDTO.getEntrantId());
        Entrant entrant = entrantMapper.toEntrantEntity(entrantDTO);
        // Update user and entrant properties
        entrant.setUser(loadedEntrant.getUser());
        entrant.setEntrantId(loadedEntrant.getEntrantId()); // Ensure the ID remains the same

        // Update the address
        AddressMapper addressMapper = new AddressMapper();
        AddressDTO addressDTO = entrantDTO.getAddress();
        if (addressDTO != null) {
            Address addressEntity = addressMapper.toAddressEntity(addressDTO);
            addressEntity.setAddressId(loadedEntrant.getAddress().getAddressId()); // Set the existing address ID
            entrant.setAddress(addressEntity);
        }

        SpouseMapper spouseMapper = new SpouseMapper();
        SpouseDTO spouseDTO = entrantDTO.getSpouseDTO();
        if(spouseDTO != null){
            Spouse spouseEntity = spouseMapper.toSpouseEntity(spouseDTO);
            spouseEntity.setSpouse_id(loadedEntrant.getSpouse().getSpouse_id());
            entrant.setSpouse(spouseEntity);
        }

        Set<Child> updatedChildSet = new HashSet<>();
        ChildMapper childMapper = new ChildMapper();
        for(ChildDTO childDTO: entrantDTO.getChildSet()){
            Long childId = childDTO.getChildId();
            Optional<Child> childSet = childRepository.findById(childId);
            if(!childSet.isPresent()){
                throw new EntityNotFoundException("Unable to find Child with ID: " + childId);
            }
            childId = childSet.get().getChildId();
            childDTO.setChildId(childId);
            Child child = childMapper.toChildEntity(childDTO);
            updatedChildSet.add(child);
            entrant.setChildSet(updatedChildSet);
        }
        Entrant updatedEntrant = entrantRepository.save(entrant);
        logger.info("Entrant successfully updated");
        return entrantMapper.toEntrantDTO(updatedEntrant);
    }
    @Override
    public Entrant loadEntrantByID(Long entrantId) {
        return entrantRepository.findById(entrantId).orElseThrow(()->{
            logger.error("error loading entrant");
            throw new EntityNotFoundException("Entrant with ID " + entrantId + " not found");
        });
    }
    @Override
    public Page<EntrantDTO> loadEntrantByName(String name, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Entrant> entrantPage = entrantRepository.findEntrantByName(name, pageRequest);
        logger.info("Successfully load Entrants");
        return new PageImpl<>(entrantPage.getContent().stream().map(entrant -> entrantMapper.toEntrantDTO(entrant)).collect(Collectors.toList()), pageRequest, entrantPage.getTotalElements());
    }
    @Override
    public EntrantDTO loadEntrantByEmail(String email) {
        return entrantMapper.toEntrantDTO(entrantRepository.findEntrantByEmail(email));
    }
    @Override
    public void deleteEntrant(Long entrantId) {
        Entrant entrant = loadEntrantByID(entrantId);
        if(entrant == null){
            logger.error("unable to delete entrant");
            throw new NullPointerException();
        }entrantRepository.deleteById(entrantId);
        logger.info("Successfully deleted entrant");
    }
    private void checkIfEmailMatch(EntrantDTO entrantDTO) throws EmailDoNotMatchException {
        if(!entrantDTO.getUser().getEmail().equals(entrantDTO.getEmailAddress())){
            logger.error("Unable to create Entrant");
            throw new EmailDoNotMatchException("Email does not match");
        }
    }
}
