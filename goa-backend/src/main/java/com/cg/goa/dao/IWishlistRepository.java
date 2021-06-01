package com.cg.goa.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.goa.entity.Userdata;
import com.cg.goa.entity.WishlistItemEntity;

@Repository
public interface IWishlistRepository extends JpaRepository<WishlistItemEntity, Long>{

	

	List<WishlistItemEntity> findByuserId(Userdata userId);

	//WishlistItemEntity findByproductId(String ProductId);

	//List<WishlistItemModel> findAllById(String userId);


	

}
