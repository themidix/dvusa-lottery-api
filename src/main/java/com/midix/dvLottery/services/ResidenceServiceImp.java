package com.midix.dvLottery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midix.dvLottery.models.Residence;
import com.midix.dvLottery.repository.ResidenceRepository;

@Service
public class ResidenceServiceImp implements ResidenceService {
	@Autowired
	ResidenceRepository residenceRepository;

	@Override
	public Residence saveResidence(Residence r) {
		return residenceRepository.save(r);
	}

	@Override
	public Residence updateResidence(Residence r) {
		return residenceRepository.save(r);
	}

	@Override
	public void deleteResidence(Residence r) {
		residenceRepository.delete(r);
	}

	@Override
	public void deleteResidenceById(Long id) {
		residenceRepository.deleteById(id);
	}

	@Override
	public Residence getResidence(Long id) {
		return residenceRepository.findById(id).get();
	}

	@Override
	public List<Residence> getAllResidence() {
		return residenceRepository.findAll();
	}
}
