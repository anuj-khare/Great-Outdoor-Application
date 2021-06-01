package com.cg.goa.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.goa.entity.ProductEntity;
import com.cg.goa.entity.SalesReportEntity;
@Repository
public interface ISalesReportRepository extends JpaRepository<SalesReportEntity, Long>{
	ProductEntity p=new ProductEntity();
	boolean existsByproductId(Long productId);
	SalesReportEntity findAllByproductId(Long productId);
	SalesReportEntity findByproductId(Long productId);
	
}