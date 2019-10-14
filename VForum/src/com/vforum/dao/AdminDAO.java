package com.vforum.dao;

import java.sql.SQLException;
import java.util.List;

import com.vforum.entities.Employees;

public interface AdminDAO {

	public  List<Employees> getEmployeeDetails() throws ClassNotFoundException,SQLException;
}
