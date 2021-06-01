package com.cg.goa.service;

import com.cg.goa.exception.IDNotFoundException;
import com.cg.goa.exception.UserNotFoundException;
import com.cg.goa.model.UserdataModel;

public interface IUserService {
	
	public UserdataModel addUser(UserdataModel user)throws UserNotFoundException;

	public String loginUser(UserdataModel u)throws IDNotFoundException ;
	public String loginadmin(UserdataModel u)throws IDNotFoundException ;
	public String logout();
}
