package com.cg.goa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.goa.dao.IUserRepository;
import com.cg.goa.dao.IWishlistRepository;
import com.cg.goa.entity.WishlistItemEntity;
import com.cg.goa.model.WishlistItemModel;

@Service
public class EMParserWishList {

	@Autowired
	private IWishlistRepository wishlistrepo;
	
	@Autowired
	private IUserRepository userrepo;
	
	@Autowired
	private EMParserUser user;
	
	public EMParserWishList() {
		this.user = new EMParserUser();
	}
	
	
	public EMParserWishList(IWishlistRepository wishlistrepo) {
		super();
		this.wishlistrepo = wishlistrepo;
		this.user = new EMParserUser();
	}

	public WishlistItemEntity parse(WishlistItemModel source) {
		return source == null ? null
				: new WishlistItemEntity(source.getWishlistId(),
						userrepo.findById(source.getUserId()).orElse(null),
						source.getProductId()
						);
	}

	public WishlistItemModel parse(WishlistItemEntity source) {
		return source == null ? null
				: new WishlistItemModel(source.getWishlistId(),
						source.getUserId().getUserId(),
						source.getProductId()
						);
	}

}
