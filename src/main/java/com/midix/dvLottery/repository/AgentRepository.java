package com.midix.dvLottery.repository;

import com.midix.dvLottery.entity.Entrant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.midix.dvLottery.entity.Agent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AgentRepository extends JpaRepository<Agent, Long> {
    @Query(value = "select e from Entrant as e where e.user.email=:email")
    Agent findAgentByEmail(@Param("email") String email);
    @Query(value = "select a from Agent as a where a.firstName like %:name% or a.lastName like %:name%")
    Page<Agent> findAgentByName(@Param("name") String name, PageRequest pageRequest);
}
