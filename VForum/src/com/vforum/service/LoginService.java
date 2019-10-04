package com.vforum.service;

import java.sql.SQLException;

import com.vforum.model.LoginModel;

public interface LoginService {

	public String userAuthenticationService(LoginModel loginModel)throws ClassNotFoundException,SQLException;
}
