package com.midix.dvLottery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midix.dvLottery.models.Conjoint;
import com.midix.dvLottery.repository.ConjointRepository;

@Service
public class ConjointServiceImp implements ConjointService {
	@Autowired
	ConjointRepository conjointRepository;

	@Override
	public Conjoint saveConjoint(Conjoint c) {
		return conjointRepository.save(c);
	}

	@Override
	public Conjoint updateConjoint(Conjoint c) {
		return conjointRepository.save(c);
	}

	@Override
	public void deleteConjoint(Conjoint c) {
		conjointRepository.delete(c);
	}

	@Override
	public void deleteConjointById(Long id) {
		conjointRepository.deleteById(id);
	}

	@Override
	public Conjoint getConjoint(Long id) {
		return conjointRepository.findById(id).get();
	}

	@Override
	public List<Conjoint> getAllConjoits() {
		return conjointRepository.findAll();
	}
}
