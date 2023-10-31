package com.midix.dvLottery.repository;

import com.midix.dvLottery.entity.DvBusiness;
import com.midix.dvLottery.entity.Entrant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DVBusinessRepository extends JpaRepository<DvBusiness,Long> {
    @Query(value = "select b from DvBusiness as b where b.businessEmail=:email")
    DvBusiness findDvBusinessByEmail(@Param("email") String email);
    @Query(value = "select b from DvBusiness as b where b.businessName like %:name% ")
    Page<DvBusiness> findDvBusinessByName(@Param("name") String name, PageRequest pageRequest);
}
