package com.cg.goa.api;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.goa.exception.SalesReportException;
import com.cg.goa.model.ProductModel;
import com.cg.goa.model.SalesReportModel;
import com.cg.goa.service.ISalesReportService;

@RestController
@RequestMapping(path = "/SalesReportEntity")
@CrossOrigin
public class SalesApi {
	@Autowired
	private ISalesReportService salesservice;
	/*
	 * to retrieve all Salesreport
	 * return :List<SalesReport>
	 * params : NIL
	 */
	@GetMapping
	public ResponseEntity<List<SalesReportModel>> findAllSalesReport() {
		return ResponseEntity.ok(salesservice.findAllSalesReport());
	}

	
	/*
	 * to update Sales Report
	 * return : productId, Quantity, totalSale
	 * params : productId, Quantity, totalSale
	 */
	@PutMapping("/{salesReportId},{quantity},{totalSale}")
	public ResponseEntity<Boolean> updateProductReport(@PathVariable("salesReportId") Long salesReportId,
			@PathVariable("quantity") Integer quantity, @PathVariable("totalSale") BigDecimal totalSale)
			throws SalesReportException {
		Boolean p = salesservice.updateProductReport(salesReportId, quantity, totalSale);
		return ResponseEntity.ok(p);
	}

	

	@GetMapping("/{salesReportId}")
	public ResponseEntity<SalesReportModel> findAllSalesReportByProductId(@PathVariable("salesReportId") Long salesReportId) {
		ResponseEntity<SalesReportModel> response = null;
		SalesReportModel p = salesservice.findAllSalesReportBySalesReportId(salesReportId);
		if (p == null) {
			response = ResponseEntity.notFound().build();
		} else {
			response = ResponseEntity.ok(p);
		}
		return response;
	}
	/*
	 * to delete All Sales Report
	 * return : Boolean
	 * params :NIL 
	 */
	@DeleteMapping
	public ResponseEntity<Boolean> deleteAllSalesReport() throws SalesReportException {
		ResponseEntity<Boolean> response = null;
		Boolean p = salesservice.deleteAllSalesReport();
		if (p == false) {
			response = ResponseEntity.notFound().build();
		}
		response = ResponseEntity.ok(p);
		return response;
	}
	/*
	 * to delete All Sales ReportbyId
	 * return : salesReportId
	 * params :NIL 
	 */
	@DeleteMapping("deletesalesreportby/{salesReportId}")
	public ResponseEntity<Boolean> deleteSalesReportById(@PathVariable(name="salesReportId") Long salesReportId) throws SalesReportException {
		ResponseEntity<Boolean> response = null;
		boolean p = salesservice.deleteSalesReportById(salesReportId);
		if (p == false) {
			response = ResponseEntity.notFound().build();
		}
		response = ResponseEntity.ok(p);
		return response;
	}

}