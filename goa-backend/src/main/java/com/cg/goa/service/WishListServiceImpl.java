package com.cg.goa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.goa.dao.IWishlistRepository;
import com.cg.goa.exception.WishlistException;
import com.cg.goa.model.UserdataModel;
import com.cg.goa.model.WishlistItemModel;

@Service
public class WishListServiceImpl implements IWishlistService {

	@Autowired
	private IWishlistRepository wishlistrepo;

	@Autowired
	private EMParserWishList parser;

	public WishListServiceImpl() {

	}
	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
	public WishListServiceImpl(IWishlistRepository wishlistrepo) {
		super();
		this.wishlistrepo = wishlistrepo;
		this.parser = new EMParserWishList();
	}

	@Transactional
	@Override
	public List<WishlistItemModel> findAllItems() {

		return wishlistrepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}
	@Transactional
	@Override
	public WishlistItemModel findWishlist(Long WishlistID) {
				return parser.parse(wishlistrepo.findById(WishlistID).orElse(null));
	}
	@Transactional
    @Override
	public boolean addProductToWishlist(String productId, Long wishlistID) {
		if (wishlistrepo.existsById(wishlistID)) {
			WishlistItemModel w = parser.parse(wishlistrepo.findById(wishlistID).orElse(null));
			w.setProductId(productId);
			parser.parse(wishlistrepo.save(parser.parse(w)));
			return true;
		}
		return false;
	}
	
	@Transactional
	@Override
	public List<WishlistItemModel> findWishlistItem(String productId, Long userId) throws WishlistException {
		List<WishlistItemModel> w3 = new ArrayList<WishlistItemModel>();
		List<WishlistItemModel> w2 = wishlistrepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
		for (WishlistItemModel w1 : w2) {
			if (w1.getUserId()!=userId) {
				continue;
			}else {
			w3.add(w1);
			}
		}
		return w3;
	}
	/*
	 * @Override public boolean deleteWishlistItem(String productId, String userId)
	 * throws WishlistException { List<WishlistItemModel> w2 =
	 * wishlistrepo.findAll().stream().map(parser::parse).collect(Collectors.toList(
	 * )); for (WishlistItemModel w1 : w2) { if
	 * (!w1.getUserId().equalsIgnoreCase(userId)) { throw new
	 * WishlistException("Unable to delete without productId and userId"); }
	 * wishlistrepo.deleteById(w1.getWishlistId()); return true; } return false; }
	 */
	@Transactional
	@Override
	public boolean deleteWishlist(Long Wishlist) throws WishlistException {
		if (wishlistrepo.existsById(Wishlist)) {
			wishlistrepo.deleteById(Wishlist);
			return true;
		} else {
			throw new WishlistException("id cannot be null or not found");
		}
	}
	@Transactional
	@Override
	public WishlistItemModel addWishlistItem(WishlistItemModel wishlistItem) throws WishlistException {
		if (wishlistrepo.existsById(wishlistItem.getWishlistId())) {
			throw new WishlistException("whislist is not added");
		}
		parser.parse(wishlistrepo.save(parser.parse(wishlistItem)));
		return wishlistItem;
	}

}