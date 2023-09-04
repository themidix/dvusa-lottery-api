package com.midix.dvLottery.repository;

import com.midix.dvLottery.entity.Entrant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EntrantRepository extends JpaRepository<Entrant, Long> {

    @Query(value = "select e from Entrant as e where e.user.email=:email")
    Entrant findEntrantByEmail(@Param("email") String email);

    @Query(value = "select e from Entrant as e where e.firstName like %:name% or e.lastName like %:name%")
    Page<Entrant> findEntrantByName(@Param("name") String name, PageRequest pageRequest);
}
