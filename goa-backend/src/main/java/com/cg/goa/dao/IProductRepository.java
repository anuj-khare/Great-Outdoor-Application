package com.cg.goa.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.goa.entity.ProductEntity;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, Long> {

	List<ProductEntity> findByCategory(String productCategory);

	List<ProductEntity> findByproductName(String keyword);

	List<ProductEntity> findByprice(Long maxPrice);

}
