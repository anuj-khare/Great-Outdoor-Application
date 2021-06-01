package com.cg.goa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.goa.entity.CartItemEntity;
import com.cg.goa.entity.Userdata;

@Repository
public interface ICartRepository extends JpaRepository<CartItemEntity, Long> {
	boolean deleteByUserId(String userId);

	CartItemEntity findAllByProductId(Long productId);

	boolean deleteByproductId(Long productId);

	
	CartItemEntity findByuserId(Userdata  user);

	List<CartItemEntity> findAllByuserId(Integer userId);

	void deleteByuserId(Integer userId);

	//List<CartItemEntity> findCartlist(Integer userId);

}
