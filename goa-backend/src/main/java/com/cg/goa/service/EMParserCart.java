package com.cg.goa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.goa.dao.ICartRepository;
import com.cg.goa.dao.IProductRepository;
import com.cg.goa.dao.IUserRepository;
import com.cg.goa.entity.CartItemEntity;
import com.cg.goa.model.CartItemModel;

@Service
public class EMParserCart {

	@Autowired
	private ICartRepository cartrepo;
	
	@Autowired
	private IUserRepository userrepo;
	
	@Autowired
	private IProductRepository productrepo;
	
	
	@Autowired
	private EMParserUser user;
	
	@Autowired
	private EMParserProduct productparser;
	
	public EMParserCart() {
		this.user = new EMParserUser();
		this.productparser=new EMParserProduct();
	}
	
	public EMParserCart(ICartRepository cartrepo,EMParserProduct productparser) {
		super();
		this.cartrepo = cartrepo;
		this.user = new EMParserUser();
		this.productparser=new EMParserProduct();
	}


	public CartItemEntity parse(CartItemModel source) {
		return source == null ? null
				: new CartItemEntity(source.getCartId(),
						userrepo.findById(source.getUserId()).orElse(null),
						source.getCartTotalPrice(),
						source.getTotalQuantity(),
						productrepo.findById(source.getProductId()).orElse(null)
						);

	}

	
	public CartItemModel parse(CartItemEntity source) {
		return source == null ? null
				: new CartItemModel(source.getCartId(),
						source.getUserId().getUserId(),
						source.getProductId().getProductId(),
						source.getCartTotalPrice(),
						source.getTotalQuantity()
						
						);

	}

}
