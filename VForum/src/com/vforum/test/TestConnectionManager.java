package com.vforum.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.vforum.integrate.ConnectionManager;

public class TestConnectionManager {

	@Test
	void testOpenConnection_positive() {
		try {
			Connection connection=ConnectionManager.
					openConnection();
			assertEquals(true,connection!=null);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			assertTrue(false);
		}
	
	}

}
