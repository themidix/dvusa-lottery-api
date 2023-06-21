package com.midix.dvLottery.services.impl;

import java.util.List;

import com.midix.dvLottery.services.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midix.dvLottery.models.Child;
import com.midix.dvLottery.repository.ChildRepository;

@Service
public class ChildServiceImp implements ChildService {
	@Autowired
	ChildRepository childRepository;

	@Override
	public Child saveChild(Child c) {
		return childRepository.save(c);
	}

	@Override
	public Child updateChild(Child c) {
		return childRepository.save(c);
	}

	@Override
	public void deleteChild(Child c) {
		childRepository.delete(c);
	}

	@Override
	public void deleteChildById(Long id) {
		childRepository.deleteById(id);
	}

	@Override
	public Child getChild(Long id) {
		return childRepository.findById(id).get();
	}

	@Override
	public List<Child> getAllChildren() {
		return childRepository.findAll();
	}
}
