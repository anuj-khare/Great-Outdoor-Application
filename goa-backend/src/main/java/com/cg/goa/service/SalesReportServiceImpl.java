package com.cg.goa.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.goa.dao.ISalesReportRepository;
import com.cg.goa.exception.SalesReportException;
import com.cg.goa.model.ProductModel;
import com.cg.goa.model.SalesReportModel;

@Service
public class SalesReportServiceImpl implements ISalesReportService {

	@Autowired
	private ISalesReportRepository salesrepo;

	@Autowired
	private EMParserSalesReport parser;

	@Autowired
	private EMParserProduct parser1;

	/*
	 * A default Constructor with no implementation
	 */

	public SalesReportServiceImpl() {

	}
	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
	public SalesReportServiceImpl(ISalesReportRepository salesrepo) {
		super();
		this.salesrepo = salesrepo;
		this.parser = new EMParserSalesReport();
	}

	@Override
	public List<SalesReportModel> findAllSalesReport() {
		return salesrepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}

	@Override
	public SalesReportModel findAllSalesReportBySalesReportId(Long salesReportId) {
		if (salesReportId != null) {
			return parser.parse(salesrepo.findById(salesReportId).orElse(null));
		}
		return null;
	}

	@Override
	public boolean updateProductReport(Long salesReportId, Integer quantity, BigDecimal totalSale) {
		SalesReportModel s = new SalesReportModel();
		if (salesrepo.existsById(salesReportId)) {
			s = parser.parse(salesrepo.findById(salesReportId).orElse(null));
			s.setQuantitySold(quantity);
			s.setTotalSale(totalSale);
			parser.parse(salesrepo.save(parser.parse(s)));
			return true;
		}
		return false;

	}

	@Override
	public boolean deleteAllSalesReport() throws SalesReportException {
		if (salesrepo.findAll() != null) {
			salesrepo.deleteAll();
			return true;
		} else {
			throw new SalesReportException("Nothing to delete. Report table is empty");
		}

	}

	@Override
	public boolean deleteSalesReportById(Long salesReportId) throws SalesReportException {
		if (salesrepo.findById(salesReportId) != null) {
			salesrepo.deleteById(salesReportId);
			return true;
		} else {
			throw new SalesReportException("Nothing to delete. Report table is empty");
		}
	}
}
