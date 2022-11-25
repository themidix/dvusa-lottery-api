package com.midix.dvLottery.services;

import java.util.List;

import com.midix.dvLottery.models.Conjoint;

public interface ConjointService {
	Conjoint saveConjoint(Conjoint c);
	Conjoint updateConjoint(Conjoint c);
	void deleteConjoint(Conjoint c);
	void deleteConjointById(Long id);
	Conjoint getConjoint(Long id);
	List<Conjoint> getAllConjoits();
}
