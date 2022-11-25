package com.midix.dvLottery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.midix.dvLottery.models.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long> {

}
