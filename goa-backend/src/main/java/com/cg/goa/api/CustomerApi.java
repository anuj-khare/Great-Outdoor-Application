package com.cg.goa.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.goa.model.CustomerModel;
import com.cg.goa.service.ICustomerService;

@RestController
@RequestMapping(path = "/CustomerEntity")
@CrossOrigin
public class CustomerApi {

	@Autowired
	private ICustomerService customerservice;
	/*
	 * to retrieve All Customers in Customer
	 * return : List
	 * params : NIL
	 */
	@GetMapping
	public ResponseEntity<List<CustomerModel>> getAllCustomers() {

		return ResponseEntity.ok(customerservice.getAllCustomers());

	}
	/*
	 * to Add new Customers in Customer
	 * return : Customer
	 * params : NIL
	 */
	@PostMapping
	public ResponseEntity<CustomerModel> addCustomer(@RequestBody CustomerModel customer) {
		customer = customerservice.addCustomer(customer);
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}
	/*
	 * to update Customers in Customer
	 * return : customer
	 * params : NIL
	 */
	@PutMapping
	public ResponseEntity<CustomerModel> updateCustomer(@RequestBody CustomerModel customer) {
		 customerservice.updateCustomer(customer);
		return ResponseEntity.ok(customer);
	}
	/*
	 * to remove Customer by Customer in Customer
	 * return : Boolean
	 * params : customer
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> removeCustomerById(@PathVariable("id") int customerId) {
		ResponseEntity<Boolean> response = null;
		Boolean p = customerservice.removeCustomer(customerId);
		if (p == false) {
			response = ResponseEntity.notFound().build();
		}
		else {
			response = ResponseEntity.ok(p);
		}
		return response;
	}
	/*
	 * to view Customer in Customer
	 * return : Customer
	 * params : viewCustomer
	 */
	@GetMapping("/viewCustomer")
	public ResponseEntity<CustomerModel> viewCustomer(@RequestBody CustomerModel customer) {
		customer=customerservice.viewCustomer(customer);
		return ResponseEntity.ok(customer);
		}
	
	@GetMapping("{id}")
	public ResponseEntity<CustomerModel> getById(@PathVariable("id") int customerId) {
		CustomerModel customer=customerservice.getById(customerId);
		return ResponseEntity.ok(customer);
		}
	
}
