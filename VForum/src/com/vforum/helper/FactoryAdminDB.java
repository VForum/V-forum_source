package com.vforum.helper;
/*
 * This class is used for abstraction purpose
 */
import org.apache.log4j.Logger;

import com.vforum.dao.AdminDAO;
import com.vforum.dao.AdminDAOImpl;
import com.vforum.service.AdminService;
import com.vforum.service.AdminServiceImpl;

public class FactoryAdminDB {
	static Logger logger=Logger.getLogger(FactoryAdminDB.class.getName());
	
	public static AdminDAO createAdminDAO(){
		logger.info("---- In FactoryAdminDB createAdminDAO method called---- ");
		AdminDAO adminDAO=new AdminDAOImpl();
		logger.info("---- In FactoryAdminDB createAdminDAO method completed---- ");
		return adminDAO;
		
	}
	public static AdminService createAdminService(){
		logger.info("---- In FactoryAdminDB createAdminService method called---- ");
		AdminService adminService= new AdminServiceImpl();
		logger.info("---- In FactoryAdminDB createAdminService method completed---- ");
		return adminService;
	}
	
}
