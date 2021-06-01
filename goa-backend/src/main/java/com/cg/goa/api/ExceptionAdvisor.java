package com.cg.goa.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.goa.exception.CartException;
import com.cg.goa.exception.GrowthReportException;
import com.cg.goa.exception.IDNotFoundException;
import com.cg.goa.exception.OrderException;
import com.cg.goa.exception.ProductException;
import com.cg.goa.exception.SalesReportException;
import com.cg.goa.exception.UserNotFoundException;


@RestControllerAdvice
public class ExceptionAdvisor {
	@ExceptionHandler(CartException.class)
	public ResponseEntity<String> CartException(CartException excep) {
		return new ResponseEntity<>(excep.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(GrowthReportException.class)
	public ResponseEntity<String> GrowthReportException(GrowthReportException excep) {
		return new ResponseEntity<>(excep.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(IDNotFoundException.class)
	public ResponseEntity<String> IDNotFoundException(IDNotFoundException excep) {
		return new ResponseEntity<>(excep.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<String> OrderException(OrderException excep) {
		return new ResponseEntity<>(excep.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<String> ProductException(ProductException excep) {
		return new ResponseEntity<>(excep.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(SalesReportException.class)
	public ResponseEntity<String> SalesReportException(SalesReportException excep) {
		return new ResponseEntity<>(excep.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> UserNotFoundException(UserNotFoundException excep) {
		return new ResponseEntity<>(excep.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> Exception(Exception excep) {
		return new ResponseEntity<>(excep.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
