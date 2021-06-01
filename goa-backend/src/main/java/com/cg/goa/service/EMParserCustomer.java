package com.cg.goa.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.goa.dao.ICustomerRepository;
import com.cg.goa.entity.CustomerEntity;
import com.cg.goa.model.AddressModel;
import com.cg.goa.model.CustomerModel;
@Service
public class EMParserCustomer {
	@Autowired
	private ICustomerRepository customerRepo;
	
	
	public CustomerEntity parse(CustomerModel source) {
		return source == null ? null
				: new CustomerEntity(source.getCustomerId(), 
						source.getCustomerName(), 
						source.getMobileNo(),
						source.getEmail(),
						parse(source.getAddress()),
						source.getRole()
						);
	}


	private AddressModel parse( AddressModel source) {
		return source == null ? null:
			new AddressModel(source.getAddressId(),
					source.getBuildingName(),
					source.getStreetNo(),
					source.getCity(),
					source.getArea(),
					source.getState(),
					source.getZip()
					);
	}
	public CustomerModel parse(CustomerEntity source) {
		return source == null ? null
				: new CustomerModel(source.getCustomerId(),
                               source.getCustomerName(), 
                               source.getMobileNo(),
						       source.getEmail(),
						       parse(source.getAddress()),
						       source.getRole()
						       );
	}



}
