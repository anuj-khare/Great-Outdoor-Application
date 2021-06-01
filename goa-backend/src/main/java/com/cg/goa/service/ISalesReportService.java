package com.cg.goa.service;

import java.math.BigDecimal;
import java.util.List;

import com.cg.goa.exception.SalesReportException;
import com.cg.goa.model.ProductModel;
import com.cg.goa.model.SalesReportModel;


public interface ISalesReportService {
	
	List<SalesReportModel> findAllSalesReport();
	
	SalesReportModel findAllSalesReportBySalesReportId( Long salesReportId);
	
    public boolean updateProductReport(Long salesReportId,Integer quantity,BigDecimal totalSale);
	
	boolean deleteAllSalesReport() throws SalesReportException;

	boolean  deleteSalesReportById(Long salesReportId) throws SalesReportException;

}
