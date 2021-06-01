package com.cg.goa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.goa.entity.CustomerEntity;

@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Integer>{
	
}
