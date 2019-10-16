package com.vforum.test;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.vforum.validation.EmployeesModelValidator;

public class TestRegisterEmployeesModelValidator {

	private EmployeesModelValidator validator=null;
	@Before
	public void setUp() throws Exception {
		validator=new EmployeesModelValidator();
	}

	@After
	public void tearDown() throws Exception {
		validator=null;
	}

	@Test
	void testValidString_positive() {
		
		boolean actual=validator.validString("badri");
		assertEquals(true,actual);
    	}
	@Test
	void testValidString_negative() {
		
		boolean actual=validator.validString("badri92");
		assertEquals(false,actual);
    	}
}
