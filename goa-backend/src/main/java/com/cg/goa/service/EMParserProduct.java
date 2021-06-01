package com.cg.goa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.goa.dao.ICartRepository;
import com.cg.goa.dao.IProductRepository;
import com.cg.goa.entity.ProductEntity;
import com.cg.goa.model.ProductModel;


@Service
public class EMParserProduct {

	@Autowired
	private IProductRepository productrepo;
	
	@Autowired
	private EMParserCart cartParser;
	
	@Autowired
	private EMParserOrder orderParser;
	
	public EMParserProduct() {
	this.cartParser=cartParser;
	this.orderParser=orderParser;
	}
	
	public EMParserProduct(IProductRepository productrepo, EMParserCart cartParser, EMParserOrder orderParser) {
		super();
		this.productrepo = productrepo;
		this.cartParser = cartParser;
		this.orderParser = orderParser;
	}

	public  ProductEntity parse(ProductModel source) {
		return source == null ? null
				: new ProductEntity(source.getProductId(), source.getProductName(), source.getPrice(),
						source.getImage(), source.getColor(), source.getCategory(), source.getQuantity(),
						source.getManufacturer(), source.getSpecification());
	}

	public  ProductModel parse(ProductEntity source) {
		return source == null ? null
				: new ProductModel(source.getProductId(), source.getProductName(), source.getPrice(), source.getImage(),
						source.getColor(), source.getCategory(), source.getQuantity(), source.getManufacturer(),
						source.getSpecification());
	}

	public  List<ProductEntity> parse2(List<ProductModel> products) {
		List<ProductEntity> products1 = new ArrayList<>();
		for (ProductModel model : products) {
			products1.add(parse(model));
		}
		return products1;
	}

	public  List<ProductModel> parse1(List<ProductEntity> products) {
		List<ProductModel> products1 = new ArrayList<>();
		for (ProductEntity model : products) {
			products1.add(parse(model));
		}
		return products1;
	}

}
