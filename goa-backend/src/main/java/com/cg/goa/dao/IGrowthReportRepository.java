package com.cg.goa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.goa.entity.GrowthReportEntity;

@Repository
public interface IGrowthReportRepository extends JpaRepository<GrowthReportEntity, Long> {
	boolean existsById(Long growthReportId);
}
