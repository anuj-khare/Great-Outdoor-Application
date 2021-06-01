package com.cg.goa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.goa.dao.IUserRepository;
import com.cg.goa.exception.IDNotFoundException;
import com.cg.goa.exception.UserNotFoundException;
import com.cg.goa.model.UserdataModel;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserRepository userrepo;

	@Autowired
	private EMParserUser parser;
	/*
	 * A default Constructor with no implementation
	 */
	public UserServiceImpl() {

	}
	
	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
	public UserServiceImpl(IUserRepository userrepo) {

		super();
		this.userrepo = userrepo;
		this.parser = new EMParserUser();
	}

	@Override
	public UserdataModel addUser(UserdataModel user) throws UserNotFoundException {
		if ((user.getUserId() == null) || userrepo.existsById(user.getUserId())) {
			throw new UserNotFoundException("UserId already exist! ");
		}
		 parser.parse(userrepo.save(parser.parse(user)));
		return user;
	}

	@Override
	public String loginUser(UserdataModel u) throws IDNotFoundException {
		Long userId = u.getUserId();
		String userPassword = u.getUserPassword();
		UserdataModel a=new UserdataModel();
		if(userrepo.existsById(userId)) {
		 a = parser.parse(userrepo.findById(userId).orElse(null));
		}else {
			throw new IDNotFoundException("Id not found");
		}
		 if ((a.getUserId()==userId)){
			 if(a.getUserPassword().equalsIgnoreCase(userPassword)) {
				 if(a.getUserType().equalsIgnoreCase("user")) {
					 return "login successfully";
				 }
				 else {
				 throw new UserNotFoundException("Login through Admin");
				 }
			 }
			 else {
				 throw new IDNotFoundException("Enter the correct User Id and Password ");
			 }
			 
		 }
		 else {
			 throw new IDNotFoundException("Id not found");
		 }
	}

	
	@Override
	public String loginadmin(UserdataModel u) throws IDNotFoundException {
		Long userId = u.getUserId();
		String userPassword = u.getUserPassword();
		UserdataModel a=new UserdataModel();
		if(userrepo.existsById(userId)) {
		 a = parser.parse(userrepo.findById(userId).orElse(null));
		}else {
			throw new IDNotFoundException("Id not found");
		}
		 if ((a.getUserId()==userId)){
			 if(a.getUserPassword().equalsIgnoreCase(userPassword)) {
				 if(a.getUserType().equalsIgnoreCase("admin")) {
					 return "login successfully";
				 }
				 else {
				 throw new UserNotFoundException("Login through User");
				 }
			 }
			 else {
				 throw new IDNotFoundException("Enter the correct User Id and Password ");
			 }
			 
		 }
		 else {
			 throw new IDNotFoundException("Id not found");
		 }
	}
	
	
	@Override
	public String logout() {
		
		return "logout success";
	}
	

}
