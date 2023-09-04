package com.midix.dvLottery.repository;

import com.midix.dvLottery.dto.SpouseDTO;
import com.midix.dvLottery.entity.Spouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpouseRepository extends JpaRepository<Spouse, Long> {
    @Query(value = "select * from spouse where spouse_id in (select entrant_id  from entrants where entrant_Id =:entrantId)", nativeQuery = true)
    SpouseDTO findSpouseByEntrantId(@Param("entrantId")Long entrantId);
    @Query(value = "select s from Spouse as s where s.firstName like %:name% or s.lastName like %:name%")
    Page<Spouse> findSpouseByName(@Param("name") String name, PageRequest pageRequest);
}
