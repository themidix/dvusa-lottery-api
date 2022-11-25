package com.midix.dvLottery.services;

import java.util.List;

import com.midix.dvLottery.models.Residence;

public interface ResidenceService {
	Residence saveResidence(Residence r);

	Residence updateResidence(Residence r);

	void deleteResidence(Residence r);

	void deleteResidenceById(Long id);

	Residence getResidence(Long id);

	List<Residence> getAllResidence();
}
