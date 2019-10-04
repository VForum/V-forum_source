package com.vforum.validation;

import java.util.ArrayList;
import java.util.List;

import com.vforum.model.RegisterEmployeeModel;

public class EmployeesModelValidator {

public boolean validate(RegisterEmployeeModel model) {
		
		boolean result=false;
		
		if(validString(model.getFirstName()) && validString(model.getLastName()) && validNumber(model.getEmployeeId()) && validEmail(model.getEmail())){
			result=true;
		}
		
		
		return result;
	}
	
	
	public boolean validString(String val) {
		
		boolean result=false;
		char chars[]=val.toCharArray();
		List<Character> alphabets=new ArrayList<>();
		for(int i=97;i<=122;i++) {
			alphabets.add((char)i);
		}
		
		for(char ch:chars) {
			if(alphabets.contains(ch)) {
				result=true;
			}else {
				return false;
			}
		}
		return result;
	}

	public boolean validNumber(int number) {
		boolean result=false;
		String data=String.valueOf(number);
		if(data.matches(".*[0-9]")) {
			result=true;
		}
		return result;
	}
	
	
	
	public boolean validEmail(String email) {
		boolean result=false;
		if(email.matches("^(.+)@(.+)$")) {
			result=true;
		}
		return result;
	}
}

