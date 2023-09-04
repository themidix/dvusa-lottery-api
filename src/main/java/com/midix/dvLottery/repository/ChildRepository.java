package com.midix.dvLottery.repository;

import com.midix.dvLottery.entity.Address;
import com.midix.dvLottery.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface ChildRepository extends JpaRepository<Child, Long> {

    @Query(value = "select * from children where child_id in (select fk_entrant_id  from entrants where entrant_Id =:entrantId)", nativeQuery = true)
    Set<Child> findChildByEntrantId(@Param("entrantId")Long entrantId);

}
