package com.midix.dvLottery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.midix.dvLottery.models.Passport;

public interface PassportRepository extends JpaRepository<Passport, Long> {

}
