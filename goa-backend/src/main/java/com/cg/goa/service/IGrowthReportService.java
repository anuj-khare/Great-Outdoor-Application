package com.cg.goa.service;

import java.util.List;
import com.cg.goa.exception.GrowthReportException;
import com.cg.goa.exception.SalesReportException;
import com.cg.goa.model.GrowthReportModel;

public interface IGrowthReportService {

	List<GrowthReportModel> findAllGrowthReport();

	boolean addGrowthReport(GrowthReportModel g) throws SalesReportException;

	boolean deleteAllGrowthReport() throws GrowthReportException;

	boolean deleteGrowthReportById(Long growthReportId) throws GrowthReportException;

	}
