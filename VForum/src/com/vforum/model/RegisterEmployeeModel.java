package com.vforum.model;
/**
 * 
 * @author sathish
 *
 */
public class RegisterEmployeeModel {

	private String employeeUid;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String designation;
	private String dob;
	private String password;
	
	public RegisterEmployeeModel() { }


	public String getEmployeeUid() {
		return employeeUid;
	}



	public void setEmployeeUid(String employeeUid) {
		this.employeeUid = employeeUid;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "RegisterEmployeeModel [employeeUid=" + employeeUid + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", designation=" + designation
				+ ", dob=" + dob + ", password=" + password + "]";
	}

	
	
}
