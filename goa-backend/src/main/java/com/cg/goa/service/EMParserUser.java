package com.cg.goa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.goa.dao.IUserRepository;
import com.cg.goa.entity.Userdata;
import com.cg.goa.model.UserdataModel;
@Service
public class EMParserUser {
	@Autowired
	private IUserRepository userrepo;
	
	
	
	public Userdata parse(UserdataModel source) {
		return source == null ? null
				: new Userdata(source.getUserName(), 
						source.getUserId(),
						source.getUserType(),
						source.getUserPassword()
						);
	}

	public UserdataModel parse(Userdata source) {
		return source == null ? null
				: new UserdataModel(source.getUserName(),
						source.getUserId(),
						source.getUserType(),
						source.getUserPassword()
						);
	}
	

	
}
