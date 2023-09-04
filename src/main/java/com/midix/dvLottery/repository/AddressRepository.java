package com.midix.dvLottery.repository;

import com.midix.dvLottery.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address,Long> {
    @Query(value = "select * from address where address_id in (select fk_address_id  from entrants where entrant_Id =:entrantId)", nativeQuery = true)
    Address findAddressByEntrantId(@Param("entrantId")Long entrantId);

}
