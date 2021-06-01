package com.cg.goa.service;

import java.util.List;
import com.cg.goa.model.CustomerModel;

public interface ICustomerService {


	List<CustomerModel> getAllCustomers();
	CustomerModel addCustomer(CustomerModel customer);
	CustomerModel updateCustomer(CustomerModel customer);
	boolean removeCustomer(int customerId);
	CustomerModel viewCustomer(CustomerModel customer);
	CustomerModel  getById(int customerId);
}
