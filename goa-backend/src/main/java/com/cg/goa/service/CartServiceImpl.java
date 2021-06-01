package com.cg.goa.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.goa.dao.ICartRepository;
import com.cg.goa.dao.IOrderRepository;
import com.cg.goa.dao.IUserRepository;
import com.cg.goa.entity.CartItemEntity;
import com.cg.goa.entity.Userdata;
import com.cg.goa.exception.CartException;
import com.cg.goa.exception.OrderException;
import com.cg.goa.exception.UserNotFoundException;
import com.cg.goa.model.CartItemModel;
import com.cg.goa.model.OrderModel;

@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	private ICartRepository cartrepo;
	
	@Autowired
	private IOrderRepository orderrepo;

	@Autowired
	private EMParserCart parser;
	
	@Autowired
	private IUserRepository userrepo;
	
	@Autowired
	private EMParserOrder parser2;
	/*
	 * A default Constructor with no implementation
	 */

	public CartServiceImpl() {

	}
	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
	public CartServiceImpl(ICartRepository cartrepo) {
		super();
		this.cartrepo = cartrepo;
		this.parser = new EMParserCart();
	}

	
	@Transactional
	@Override
	public List<CartItemModel> findCartlist() {
		//return cartrepo.findCartlist(userId);
		return cartrepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}

	
	@Transactional
	@Override
	public CartItemModel findCartItem(Long cartId) {
			CartItemModel p = parser.parse(cartrepo.findById(cartId).orElse(null));
			return p;
	}

	
	@Transactional
	@Override
	public CartItemModel addCart(CartItemModel cartItemEntity) throws CartException {
		if (cartrepo.existsById(cartItemEntity.getCartId())) {
			throw new CartException("It already exists");
		}
		parser.parse(cartrepo.save(parser.parse(cartItemEntity)));
		return cartItemEntity;
	}

	
	@Transactional
	@Override
	public boolean updateCart(Long id , long quantity) throws CartException {
		if (id != null) {
			if (cartrepo.existsById(id)) {
				CartItemModel p=parser.parse(cartrepo.findById(id).orElse(null));
				Long g=p.getCartTotalPrice();
				Long q=p.getTotalQuantity();
				Long c=  (g)/q;
				p.setTotalQuantity(quantity);
				p.setCartTotalPrice(c*quantity);
				parser.parse(cartrepo.save(parser.parse(p)));
				return true;
			}
		}
		return false;
	}

	
	@Transactional
	@Override
	public boolean deleteCartItem(Long cartId, Long productId) throws CartException {
		if (cartId != null || productId != null) {
			if (cartrepo.existsById(cartId)) {
				CartItemModel c = parser.parse(cartrepo.findById(cartId).orElse(null));
				return cartrepo.deleteByproductId(c.getProductId());
			}
		}
		else {
			throw new CartException("product is not found");
		}
		return false;
	}

	
	@Transactional
	@Override
	public boolean deleteCartlist(CartItemModel c) throws CartException {
		Long k=c.getCartId();
		if (cartrepo.existsById(k)) {
			cartrepo.deleteById(k);
			return true;
		}
		return false;
	}
	
	
	@Override
	public CartItemModel viewcartByUserId(Long userId) throws CartException, UserNotFoundException {
		Userdata user = userrepo.findById(userId).orElse(null);
		if(user==null) {
			throw new UserNotFoundException("ad");
		}
		CartItemEntity order=user.getCart();
		
		return parser.parse(order);
	}
	
	@Transactional
	@Override
	public boolean orderToCart(Long cartId, Long userId) throws CartException {
		CartItemModel c = parser.parse(cartrepo.findById(cartId).orElse(null));
		OrderModel o=parser2.parse(orderrepo.findByuserId(userrepo.findById(userId).orElse(null)));
		if(o!=null && (o.getUserId().equals(c.getUserId())) && (c.getCartId().equals(cartId))) {
			 LocalDateTime now = LocalDateTime.now();  
			 LocalDateTime now1 = now.plusDays(10);
			o.setProductId(c.getProductId());
			o.setTotalQuantity(c.getTotalQuantity());
			o.setTotalPrice(c.getCartTotalPrice());
			o.setDispatchDate(now);
			o.setDeliveryDate(now1);
			parser2.parse(orderrepo.save(parser2.parse(o)));
			return true;
		}
		else {
			throw new CartException("use same userId ");
		}
	}

}