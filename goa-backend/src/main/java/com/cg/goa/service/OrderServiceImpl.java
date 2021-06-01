package com.cg.goa.service;


import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.cg.goa.dao.IOrderRepository;
import com.cg.goa.dao.IUserRepository;
import com.cg.goa.entity.OrderEntity;
import com.cg.goa.entity.Userdata;
import com.cg.goa.exception.OrderException;
import com.cg.goa.exception.UserNotFoundException;
import com.cg.goa.model.OrderModel;
import com.cg.goa.model.UserdataModel;


@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderRepository orderrepo;
	
	@Autowired
	private IUserRepository userrepo;

	@Autowired
	private EMParserOrder parser;
	/*
	 * A default Constructor with no implementation
	 */

	public OrderServiceImpl() {

	}

	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
	public OrderServiceImpl(IOrderRepository orderrepo) {
		super();
		this.orderrepo = orderrepo;
		this.parser = new EMParserOrder();
	}
	/*
	 * service implementation for Finding Order By UserId
	 */
	@Transactional
	@Override
	public OrderModel findOrdersByOrderId(Long order) {

		return parser.parse(orderrepo.findById(order).orElse(null));
	}
	/*
	 * service implementation for Finding All Orders
	 */
	@Transactional
	@Override
	public List<OrderModel> findAllOrders() {

		return orderrepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}
	/*
	 * service implementation for Adding new Order
	 * @Throws OrderException
	 */
	@Transactional
	@Override
	public OrderModel addOrder(OrderModel orderEntity) throws OrderException {
		if (!orderrepo.existsById(orderEntity.getOrderId())|| !(userrepo.existsById(orderEntity.getUserId()))) {
			parser.parse(orderrepo.save(parser.parse(orderEntity)));
		} else {
			throw new OrderException("already exist Found");
		}
		return orderEntity;
	}
	/*
	 * service implementation for deleting All Orders
	 * @Throws OrderException
	 */
	@Transactional
	@Override
	public boolean deleteAllOrders() throws OrderException {
		if (orderrepo.findAll().isEmpty()) {
			throw new OrderException("There are no orders to delete");
		}
		orderrepo.deleteAll();
		return true;
	}
	/*
	 * service implementation for deleting Order By Id
	 * @Throws OrderException
	 */
	@Transactional
	@Override
	public boolean deleteOrderById(Long orderId) throws OrderException {
		if (orderrepo.existsById(orderId)) {
			orderrepo.deleteById(orderId);
			return true;
		} else {
			throw new OrderException("Order Id is Not found");
		}
	}
	/*
	 * service implementation for Updating Date
	 * @Throws OrderException
	 */
	@Transactional
	@Override
	public boolean updateDate(OrderModel orderEntity)
			throws OrderException {
		if (!orderrepo.existsById(orderEntity.getOrderId())) {
			throw new OrderException("There is no such order id to update");
		}
		parser.parse(orderrepo.save(parser.parse(orderEntity)));
		return true;
	}

	
	@Transactional
	@Override
	public OrderModel vieworderByUserId(Long userId) throws OrderException,UserNotFoundException{
		Userdata user = userrepo.findById(userId).orElse(null);
		if(user==null) {
			throw new UserNotFoundException("ad");
		}
		OrderEntity order=user.getOrder();
		
		return parser.parse(order);
	}
	
	
	
}
