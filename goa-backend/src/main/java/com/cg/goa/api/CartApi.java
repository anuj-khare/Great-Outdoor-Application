package com.cg.goa.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.cg.goa.exception.CartException;
import com.cg.goa.exception.OrderException;
import com.cg.goa.exception.UserNotFoundException;
import com.cg.goa.model.CartItemModel;
import com.cg.goa.model.OrderModel;
import com.cg.goa.service.ICartService;

@RestController
@RequestMapping("/CartItemEntity")
@CrossOrigin
public class CartApi {

	@Autowired
	private ICartService cartservice;
	/*
	 * to retrieve all cartlist
	 * return : List
	 * params : NIL
	 */
	@GetMapping
	public ResponseEntity<List<CartItemModel>> findCartlist() {

		return ResponseEntity.ok(cartservice.findCartlist());
	}
	/*
	 * to add new cart
	 * return : cart
	 * params : NIL
	 */
	@GetMapping("/{cartId}")
	public ResponseEntity<CartItemModel> findCartItem(@PathVariable("cartId")Long cartId ) {
		ResponseEntity<CartItemModel> response = null;
		CartItemModel cart = cartservice.findCartItem(cartId);

		if (cart == null) {
			response = ResponseEntity.notFound().build();
		} else {
			response = ResponseEntity.ok(cart);
		}
		return response;
	}

	
	/*
	 * to add new cart
	 * return : cart
	 * params : NIL
	 */
	@PostMapping
	public ResponseEntity<CartItemModel> createCart(@RequestBody CartItemModel cart) throws CartException {
		cart = cartservice.addCart(cart);
		return new ResponseEntity<>(cart, HttpStatus.CREATED);
	}

	
	/*
	 * to update cart
	 * return : cart
	 * params : NIL
	 */
	@PutMapping("/{id},{quantity}")
	public ResponseEntity<Boolean> updateCart(@PathVariable("id") Long CartId,@PathVariable("quantity") long quantity) throws CartException {
		boolean cart = cartservice.updateCart(CartId, quantity);
		return ResponseEntity.ok(cart);
	}
	/*
	 * to delete  cartItem
	 * return : cart
	 * params : cartId, productId
	 */
	@DeleteMapping("/{cartId},{productId}")
	public ResponseEntity<Boolean> deleteCartItem(@PathVariable("cartId") Long cartId,
			@PathVariable("productId") Long productId) throws CartException {
		ResponseEntity<Boolean> response = null;
		boolean cart = cartservice.deleteCartItem(cartId, productId);
		if (cart == false) {
			response = ResponseEntity.notFound().build();
		} else {
			response = ResponseEntity.ok(cart);
		}
		return response;
	}

	
	/*
	 * to delete cartList
	 * return : cart
	 * params : userId
	 */
	@DeleteMapping("deleteCart/{cartId}")
	public ResponseEntity<Boolean> deleteCartList(@PathVariable("cartId") Long cartId) throws CartException {
		CartItemModel c=new CartItemModel();
		c.setCartId(cartId);
		Boolean p = cartservice.deleteCartlist(c);
		return ResponseEntity.ok(p);

	}
	
	@GetMapping("/cart/{userId}")
	public ResponseEntity<CartItemModel> viewcartByUserId(@PathVariable("userId") Long userId) throws CartException, UserNotFoundException {
		ResponseEntity<CartItemModel> response = null;
		CartItemModel cart = cartservice.viewcartByUserId(userId);
		
		if (cart == null) {
			 response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} else {
			response = ResponseEntity.ok(cart);
		}
		return response;
	}
	
	
	@PutMapping("/carttoorder/{cartId},{userId}")
	public ResponseEntity<Boolean> carttoorder(@PathVariable("cartId") Long cartId,@PathVariable("userId") Long userId) throws CartException {
		ResponseEntity<Boolean> response = null;
		Boolean cart = cartservice.orderToCart(cartId, userId);
		
		if (cart == false) {
			response = ResponseEntity.notFound().build();
		} else {
			response = ResponseEntity.ok(cart);
		}
		return response;
	}

}