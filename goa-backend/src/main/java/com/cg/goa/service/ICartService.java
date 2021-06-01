package com.cg.goa.service;

import java.util.List;

import com.cg.goa.exception.CartException;
import com.cg.goa.exception.UserNotFoundException;
import com.cg.goa.model.CartItemModel;

public interface ICartService {

	List<CartItemModel> findCartlist();
	CartItemModel findCartItem(Long cartId);
	CartItemModel addCart(CartItemModel cartItemEntity) throws CartException;

	boolean updateCart(Long id , long quantity) throws CartException;
	boolean deleteCartItem(Long cartId,Long productId) throws CartException;

	boolean deleteCartlist(CartItemModel c) throws CartException;
	CartItemModel viewcartByUserId(Long userId) throws CartException,UserNotFoundException;
	
	boolean orderToCart(Long cartId,Long userId) throws  CartException;
}
