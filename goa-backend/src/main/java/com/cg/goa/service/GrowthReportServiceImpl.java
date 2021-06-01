package com.cg.goa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.goa.dao.IGrowthReportRepository;
import com.cg.goa.entity.GrowthReportEntity;
import com.cg.goa.exception.GrowthReportException;
import com.cg.goa.exception.SalesReportException;
import com.cg.goa.model.GrowthReportModel;

@Service
public class GrowthReportServiceImpl implements IGrowthReportService {

	@Autowired
	private IGrowthReportRepository growthrepo;

	@Autowired
	private EMParserGrowthReport parser;
	/*
	 * A default Constructor with no implementation
	 */

	public GrowthReportServiceImpl() {

	}
	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
	public GrowthReportServiceImpl(IGrowthReportRepository growthrepo) {
		super();
		this.growthrepo = growthrepo;
		this.parser = new EMParserGrowthReport();
	}

	
	@Override
	public List<GrowthReportModel> findAllGrowthReport() {	
		List<GrowthReportEntity> p=growthrepo.findAll();
		System.out.println("output");
		
		List<GrowthReportModel> retList= new ArrayList<>();
		
		for(GrowthReportEntity category : p)
			retList.add(parser.parse(category));
		
		return retList;
	}
	
	@Transactional
	@Override
	public boolean addGrowthReport(GrowthReportModel g) throws SalesReportException {
		Long id = g.getGrowthReportId();
		if(growthrepo.existsById(id)) {
			throw new SalesReportException("Report already exists");
		}
			g=parser.parse(growthrepo.save(parser.parse(g)));
		return true;
	}

	@Override
	public boolean deleteAllGrowthReport() throws GrowthReportException {
		if(growthrepo.findAll()!=null) {
			growthrepo.deleteAll();
	    	return true;
		}
		else {
			throw new GrowthReportException("Nothing to delete. Report table is empty");
		}
		
		
	}

	@Override
	public boolean deleteGrowthReportById(Long growthReportId) throws GrowthReportException {
		if (growthrepo.existsById(growthReportId)) {
			growthrepo.deleteById(growthReportId);
			return true;
		}
		else {
			throw new GrowthReportException("No Growth Report is present with " + growthReportId);
		
		}

	}

}
