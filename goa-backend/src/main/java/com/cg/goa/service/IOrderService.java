package com.cg.goa.service;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.goa.exception.OrderException;
import com.cg.goa.exception.UserNotFoundException;
import com.cg.goa.model.OrderModel;

public interface IOrderService {

	public OrderModel findOrdersByOrderId(Long order);

	public List<OrderModel> findAllOrders();

	public OrderModel addOrder(OrderModel orderEntity) throws OrderException;

	public boolean deleteAllOrders() throws OrderException;

	public boolean deleteOrderById(Long orderId) throws OrderException;

	public boolean updateDate(OrderModel orderEntity) throws OrderException;

	
	public OrderModel vieworderByUserId(Long userId) throws OrderException,UserNotFoundException;
}
