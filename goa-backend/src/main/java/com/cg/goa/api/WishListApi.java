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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.goa.exception.IDNotFoundException;
import com.cg.goa.exception.ProductException;
import com.cg.goa.exception.WishlistException;
import com.cg.goa.model.CustomerModel;
import com.cg.goa.model.ProductModel;
import com.cg.goa.model.UserdataModel;
import com.cg.goa.model.WishlistItemModel;
import com.cg.goa.service.IWishlistService;

@RestController
@RequestMapping(path = "/WishlistItemEntity")
@CrossOrigin
public class WishListApi {

	@Autowired
	private IWishlistService wishlistservice;

	@GetMapping
	public ResponseEntity<List<WishlistItemModel>> findAllItems() {
		return ResponseEntity.ok(wishlistservice.findAllItems());
	}

	@GetMapping("/{WishlisId}")
	public ResponseEntity<WishlistItemModel> findWishlist(@PathVariable("WishlisId") Long Wishlist) {

		return ResponseEntity.ok(wishlistservice.findWishlist(Wishlist));
	}

	@GetMapping("findWishlistItem/{productId}")
	public ResponseEntity<List<WishlistItemModel>> findWishlistItem(@PathVariable("productId") String productId,
			@RequestBody  Long userId) throws WishlistException {

		return ResponseEntity.ok(wishlistservice.findWishlistItem(productId, userId));
	}

	@PostMapping("/{productId},{id}")
	public ResponseEntity<Boolean> addProduct(@PathVariable("productId") String productId,
			@PathVariable("id") Long WishListId) throws WishlistException {
		Boolean w = wishlistservice.addProductToWishlist(productId, WishListId);
		return new ResponseEntity<>(w, HttpStatus.CREATED);

	}

	/*
	 * @DeleteMapping("deleteWishlistItem/{productId},{userId}") public
	 * ResponseEntity<Boolean> deleteWishlistItem(@PathVariable(value = "productId")
	 * String productId, @PathVariable("userId") String userId) throws
	 * WishlistException {
	 * 
	 * return ResponseEntity.ok(wishlistservice.deleteWishlistItem(productId,
	 * userId));
	 * 
	 * }
	 */

	@DeleteMapping("deleteWishlist/{WishlisId}")
	public ResponseEntity<Boolean> deleteWishlist(@PathVariable(value = "WishlisId") Long Wishlist)
			throws WishlistException {
		return ResponseEntity.ok(wishlistservice.deleteWishlist(Wishlist));
	}

	@PostMapping
	public ResponseEntity<WishlistItemModel> addWishlistItem(@RequestBody WishlistItemModel wishlistItem) throws WishlistException {
		WishlistItemModel p = wishlistservice.addWishlistItem(wishlistItem);
		return new ResponseEntity<>(p, HttpStatus.CREATED);
	}

}