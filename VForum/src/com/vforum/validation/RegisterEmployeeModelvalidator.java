package com.vforum.validation;

import java.util.ArrayList;
import java.util.List;

import com.vforum.model.RegisterEmployeeModel;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class RegisterEmployeeModelvalidator {
	
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

}
