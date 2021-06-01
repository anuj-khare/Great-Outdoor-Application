package com.cg.goa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.goa.entity.Userdata;
@Repository
public interface IUserRepository extends JpaRepository<Userdata, Long>{

}
