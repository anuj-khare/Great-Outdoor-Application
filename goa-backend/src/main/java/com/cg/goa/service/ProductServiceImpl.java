package com.cg.goa.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.goa.dao.ICartRepository;
import com.cg.goa.dao.IOrderRepository;
import com.cg.goa.dao.IProductRepository;
import com.cg.goa.dao.IUserRepository;
import com.cg.goa.exception.CartException;
import com.cg.goa.exception.OrderException;
import com.cg.goa.exception.ProductException;
import com.cg.goa.model.CartItemModel;
import com.cg.goa.model.OrderModel;
import com.cg.goa.model.ProductModel;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository productrepo;
	
	@Autowired
	private ICartRepository cartrepo;

	@Autowired
	private IOrderRepository orderrepo;
	
	@Autowired
	private IUserRepository userrepo;
	
	@Autowired
	private EMParserProduct parser;
	
	@Autowired
	private EMParserCart parser1;
	
	@Autowired
	private EMParserOrder parser2;
	/*
	 * A default Constructor with no implementation
	 */

	public ProductServiceImpl() {

	}
	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
	public ProductServiceImpl(IProductRepository productrepo, EMParserProduct parser) {
		super();
		this.productrepo = productrepo;
		this.parser = new EMParserProduct();
	}
	@Transactional
	@Override
	public List<ProductModel> findAllProducts() {
		return productrepo.findAll().stream().map(parser::parse).collect(Collectors.toList());

	}
	@Transactional
	@Override
	public ProductModel findByProductId(Long id) {
		return parser.parse(productrepo.findById(id).orElse(null));
	}
	@Transactional
	@Override
	public List<ProductModel> findByProductCategory(String productCategory) {
		return productrepo.findByCategory(productCategory).stream().map(parser::parse)
				.collect(Collectors.toList());

	}
	@Transactional
	@Override
	public ProductModel addProduct(ProductModel productEntity) throws ProductException {

		if (!productrepo.existsById(productEntity.getProductId())) {
			parser.parse(productrepo.save(parser.parse(productEntity)));
			return productEntity;
		} else {
			throw new ProductException("Product id already exists ");
		}
	}
	@Transactional
	@Override
	public ProductModel updateProduct(ProductModel productEntity) throws ProductException {
		if (productrepo.existsById(productEntity.getProductId())) {
			parser.parse(productrepo.save(parser.parse(productEntity)));
			return productEntity;
		} else {
			throw new ProductException("Product id not exists ");
		}

	}
	@Transactional
	@Override
	public boolean updateProductQuantity(Long quantity, Long productId) {
		if (productId != null) {
			if (productrepo.existsById(productId)) {
				ProductModel p=	parser.parse(productrepo.findById(productId).orElse(null));
				p.setQuantity(quantity);
				return true;
			}
		}
		return false;
	}
	@Transactional
	@Override
	public boolean deleteByProductId(Long id) throws ProductException {
			if (productrepo.findById(id) != null) {
				productrepo.deleteById(id);
				return true;
			} else {
				throw new ProductException("id cannot be nullor not found");
			}
	}
	
	@Transactional
	@Override
	public List<ProductModel> search(String keyword) {

		return productrepo.findByproductName(keyword).stream().map(parser::parse).collect(Collectors.toList());
	}
	
	@Transactional
	@Override
	public List<ProductModel> filter(Long maxPrice) {

		return productrepo.findByprice(maxPrice).stream().map(parser::parse).collect(Collectors.toList());
	}
	
	@Transactional
	@Override
	public boolean Addproducttocart(Long id, Long CartId,Long quantity) throws ProductException, CartException {
		ProductModel p=	parser.parse(productrepo.findById(id).orElse(null));
		CartItemModel c=parser1.parse(cartrepo.findByuserId(userrepo.findById(CartId).orElse(null)));//.orElse(null));
		if(c !=null) {
			if(!(productrepo.existsById(id))) {
				throw new ProductException("Please enter correct product Id");
			}
			else if(p.getQuantity()<quantity) {
				throw new ProductException("please Enter less Quantity");
			}
		c.setProductId(id);
		c.setTotalQuantity(quantity);
		c.setCartTotalPrice((quantity*p.getPrice()));
				parser1.parse(cartrepo.save(parser1.parse(c)));
		return true;
 		}
		else {
			throw new CartException("Cart Id do not exist ");
		}
	}
	
	@Transactional
	@Override
	public boolean Addproducttoorder(Long id, Long Order, Long quantity) throws ProductException, OrderException {
		ProductModel p=	parser.parse(productrepo.findById(id).orElse(null));
		OrderModel o=parser2.parse(orderrepo.findByuserId(userrepo.findById(Order).orElse(null)));;
		if(o!=null){
			if(!(productrepo.existsById(id))) {
				throw new ProductException("Please enter correct product Id");
			}
			else if(p.getQuantity()<quantity) {
				throw new ProductException("please Enter less Quantity");
			}
	           LocalDateTime now = LocalDateTime.now();  
			   LocalDateTime now1 = now.plusDays(10);
			o.setProductId(id);
			o.setTotalQuantity(quantity);
			o.setTotalPrice((quantity*p.getPrice()));
			o.setDispatchDate(now);
			o.setDeliveryDate(now1);
			parser2.parse(orderrepo.save(parser2.parse(o)));
			return true;
		}
		else {
			throw new OrderException("Order Id do not exist ");
		}
		
	}

}
