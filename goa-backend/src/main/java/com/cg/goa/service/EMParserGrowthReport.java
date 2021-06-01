package com.cg.goa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.goa.dao.IGrowthReportRepository;
import com.cg.goa.entity.GrowthReportEntity;
import com.cg.goa.model.GrowthReportModel;

@Service
public class EMParserGrowthReport {
	
	@Autowired
	private IGrowthReportRepository growthrepo;
	
	public GrowthReportEntity parse(GrowthReportModel source) {
		return source == null ? null
				: new GrowthReportEntity(source.getGrowthReportId(),
						source.getCurrentdate(),
						source.getRevenue(),
						source.getAmountChange(),
						source.getPercentageGrowth(),
						source.getColorCode()
						);
	}

	public GrowthReportModel parse(GrowthReportEntity source) {
		return source == null ? null
				: new GrowthReportModel(source.getGrowthReportId(),
						source.getCurrentdate(),
						source.getRevenue(),
						source.getAmountChange(),
						source.getPercentageGrowth(),
						source.getColorCode()
						);
	}

}
