package com.vforum.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vforum.model.RegisterEmployeeModel;

public class EmployeesModelValidator {

public boolean validate(RegisterEmployeeModel model) {
		
		boolean result=false;
		
		if(validString(model.getFirstName()) && validNumber(model.getPhoneNumber()) && validString(model.getLastName()) && validEmail(model.getEmail())){
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

	public boolean validNumber(String number) {
		boolean result=false;
		/*String data=number;
		if(data.matches(".*[0-9]")) {
			result=true;*/
		 Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
	        Matcher m = p.matcher(number); 
	        if(m.find() && m.group().equals(number)) {
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
	public boolean validPassword(String password) {
		boolean result=false;
		if(password.length()>=8) {
			result=true;
		}
		return result;
	}
	public boolean validDOB(String dob) {
		boolean result=false;
		String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(dob);
		  if(matcher.matches()) {
			  result=true;
		  }
		
		return result;
	}
}

