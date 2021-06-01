package com.cg.goa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.goa.dao.IOrderRepository;
import com.cg.goa.dao.IProductRepository;
import com.cg.goa.dao.IUserRepository;
import com.cg.goa.entity.OrderEntity;
import com.cg.goa.model.OrderModel;


@Service
public class EMParserOrder {

	@Autowired
	private IOrderRepository orderrepo;
	
	@Autowired
	private IUserRepository userrepo;
	
	@Autowired
	private EMParserUser user;
	
	@Autowired
	private IProductRepository productrepo;
	
	@Autowired
	private EMParserProduct productparser;
	
	public EMParserOrder() {
		this.user = new EMParserUser();
		this.productparser=new EMParserProduct();
	}
	
	public EMParserOrder(IOrderRepository orderrepo) {
		super();
		this.orderrepo = orderrepo;
		this.user = new EMParserUser();
		this.productparser=new EMParserProduct();
	}


	public OrderEntity parse(OrderModel source) {
		return source == null ? null
				: new OrderEntity(source.getOrderId(),
						userrepo.findById(source.getUserId()).orElse(null),
						productrepo.findById(source.getProductId()).orElse(null),
						source.getTotalPrice(),
						source.getTotalQuantity(),
						source.getDispatchDate(),
						source.getDeliveryDate()
						);
	}


	public OrderModel parse(OrderEntity source) {
		return source == null ? null
				: new OrderModel(source.getOrderId(),
						source.getUserId().getUserId(),
						source.getProductId().getProductId(),
						source.getTotalPrice(),
						source.getTotalQuantity(),
						source.getDispatchDate(),
						source.getDeliveryDate()
						
						);
	}


}
