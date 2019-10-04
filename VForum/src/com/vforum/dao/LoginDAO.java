package com.vforum.dao;

import java.sql.SQLException;

public interface LoginDAO {

	public boolean userAuth(String userId,String password,int option)throws ClassNotFoundException,SQLException;
}
