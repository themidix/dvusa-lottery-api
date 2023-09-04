package com.midix.dvLottery.services.impl;

import com.midix.dvLottery.dto.ChildDTO;
import com.midix.dvLottery.entity.Child;
import com.midix.dvLottery.mapper.ChildMapper;
import com.midix.dvLottery.repository.ChildRepository;
import com.midix.dvLottery.services.ChildService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
@Slf4j
@Transactional
public class ChildServiceImp implements ChildService {
    private static Logger logger = LoggerFactory.getLogger(ChildServiceImp.class);
    private ChildMapper childMapper;
    private ChildRepository childRepository;
    public ChildServiceImp(ChildMapper childMapper, com.midix.dvLottery.repository.ChildRepository childRepository) {
        this.childMapper = childMapper;
        this.childRepository = childRepository;
    }

    @Override
    public Child saveChild(Child c) {
        return null;
    }

    @Override
    public ChildDTO updateChild(ChildDTO childDTO) {
        log.info("3. Child ID: " + childDTO.getChildId());
        Child loadedChild = childRepository.findById(childDTO.getChildId()).orElseThrow(()-> new EntityNotFoundException("Unable to find child with ID " + childDTO.getChildId()));
        loadedChild.setChildId(childDTO.getChildId());
        loadedChild.setFirstName(childDTO.getFirstName());
        loadedChild.setLastName(childDTO.getLastName());
        Child child = childRepository.save(loadedChild);
        log.info("4. Child ID: " + loadedChild.getChildId());
        return childMapper.toChildDTO(child);
    }

    @Override
    public void deleteChildById(Long childId) {
        childRepository.deleteById(childId);
    }

    @Override
    public Child getChild(Long id) {
        return null;
    }

    @Override
    public List<Child> getAllChildren() {
        return null;
    }
}
