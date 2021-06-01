package com.cg.goa.api;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.cg.goa.exception.OrderException;
import com.cg.goa.exception.UserNotFoundException;
import com.cg.goa.model.OrderModel;
import com.cg.goa.service.IOrderService;

@RestController
@RequestMapping(path = "/OrderEntity")
@CrossOrigin
public class OrderApi {

	@Autowired
	private IOrderService orderservice;
	
	/*
	 * to list orders by UserId
	 * return : List<Order>
	 * params : userId
	 */
	@GetMapping("/{order}")
	public ResponseEntity<OrderModel> findOrdersByOrderId(@PathVariable("order")Long order) {
		return ResponseEntity.ok(orderservice.findOrdersByOrderId(order));
	}
	/*
	 * to list allorders
	 * return : list
	 * params : NIL
	 */
	@GetMapping
	public ResponseEntity<List<OrderModel>> findAllOrders() {
		return ResponseEntity.ok(orderservice.findAllOrders());
	}

	
	/*
	 * to add new order
	 * return : orderEntity
	 * params : NIL
	 */
	@PostMapping
	public ResponseEntity<OrderModel> addOrder(@RequestBody OrderModel orderEntity) throws OrderException {
		orderEntity = orderservice.addOrder(orderEntity);

		return new ResponseEntity<>(orderEntity, HttpStatus.CREATED);

	}

	
	/*
	 * to delete All orders
	 * return : Boolean
	 * params : NIL
	 */
	@DeleteMapping
	public ResponseEntity<Boolean> deleteAllOrders() throws OrderException {
		return ResponseEntity.ok(orderservice.deleteAllOrders());

	}
	/*
	 * to updateDate id, dates
	 * return : Boolean
	 * params : orderId, dispatchDate,arrivalDate
	 */
	@PutMapping
	public ResponseEntity<Boolean> updateDate(@RequestBody OrderModel orderEntity) 
			throws OrderException {
		Boolean p = orderservice.updateDate(orderEntity);
		return ResponseEntity.ok(p);

	}
	/*
	 * to deleteOrderByorderId
	 * return : Boolean
	 * params : orderId
	 */
	@DeleteMapping("/{orderId}")
	public ResponseEntity<Boolean> deleteOrderById(@PathVariable("orderId") Long orderId)
			throws OrderException {
		Boolean p =orderservice.deleteOrderById(orderId);;
		
		return ResponseEntity.ok(p);
			
	
	}
	
	@GetMapping("/order/{userId}")
	public ResponseEntity<OrderModel> vieworderByUserId(@PathVariable("userId") Long userId) throws OrderException, UserNotFoundException {
		ResponseEntity<OrderModel> response = null;
		OrderModel order = orderservice.vieworderByUserId(userId);
		
		if (order == null) {
			 response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} else {
			response = ResponseEntity.ok(order);
		}
		return response;
	}
	
}
