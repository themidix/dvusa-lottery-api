package com.midix.dvLottery.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.midix.dvLottery.models.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
