package com.vforum.dao;
/*
 * This interface for login contains the function declaration of the authentication
 */
import java.sql.SQLException;

public interface LoginDAO {

	public String userAuth(String userId,String password)throws ClassNotFoundException,SQLException;
}
