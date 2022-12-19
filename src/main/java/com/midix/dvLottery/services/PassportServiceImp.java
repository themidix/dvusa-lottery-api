package com.midix.dvLottery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midix.dvLottery.models.Passport;
import com.midix.dvLottery.repository.PassportRepository;

@Service
public class PassportServiceImp implements PassportService {
	@Autowired
	PassportRepository passportRepository;

	@Override
	public Passport savePassport(Passport p) {
		return passportRepository.save(p);
	}

	@Override
	public Passport updatePassport(Passport p) {
		return passportRepository.save(p);
	}

	@Override
	public void deletePassport(Passport p) {
		passportRepository.delete(p);
	}

	@Override
	public void deletePassportById(Long id) {
		passportRepository.deleteById(id);
	}

	@Override
	public Passport getPassport(Long id) {
		return passportRepository.findById(id).get();
	}

	@Override
	public List<Passport> getAllPassports() {
		return passportRepository.findAll();
	}
}
