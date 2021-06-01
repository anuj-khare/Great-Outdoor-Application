package com.cg.goa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.goa.entity.OrderEntity;
import com.cg.goa.entity.Userdata;
@Repository
public interface IOrderRepository extends JpaRepository<OrderEntity, Long> {

	OrderEntity findByuserId(Userdata user);

}
