package com.cg.goa.service;

import java.math.BigDecimal;
import java.util.List;

import com.cg.goa.exception.CartException;
import com.cg.goa.exception.OrderException;
import com.cg.goa.exception.ProductException;
import com.cg.goa.model.ProductModel;

public interface IProductService {

	List<ProductModel> findAllProducts();

	ProductModel findByProductId(Long id);

	List<ProductModel> findByProductCategory(String productCategory);

	ProductModel addProduct(ProductModel productEntity) throws ProductException;

	ProductModel updateProduct(ProductModel productEntity) throws ProductException;

	boolean updateProductQuantity(Long quantity,Long productId);

	boolean deleteByProductId(Long id) throws ProductException;

	List<ProductModel> search(String keyword);

	List<ProductModel> filter(Long maxPrice);
    
	boolean Addproducttocart(Long id,Long CartId,Long quantity) throws ProductException,CartException;
	
	boolean Addproducttoorder(Long id,Long Order,Long quantity) throws ProductException,OrderException;
}
