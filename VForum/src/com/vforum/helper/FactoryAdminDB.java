package com.vforum.helper;

import com.vforum.dao.AdminDAO;
import com.vforum.dao.AdminDAOImpl;
import com.vforum.service.AdminService;
import com.vforum.service.AdminServiceImpl;

public class FactoryAdminDB {

	public static AdminDAO createAdminDAO(){
		AdminDAO adminDAO=new AdminDAOImpl();
		return adminDAO;
		
	}
	public static AdminService createAdminService(){
		AdminService adminService=
				new AdminServiceImpl();
		return adminService;
	}
	
}
