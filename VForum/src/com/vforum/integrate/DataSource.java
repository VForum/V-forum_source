package com.vforum.integrate;
/*
 * This class retrives database credentials from DB.properties file
 */
import java.util.ResourceBundle;

public class DataSource {

	private String driver;
	private String url;
	private String username;
	private String password;
	
	public DataSource() {
		ResourceBundle resourceBundle=
				ResourceBundle.getBundle("DB");
		
		this.driver=resourceBundle.getString("driver");
		this.url=resourceBundle.getString("url");
		this.username=resourceBundle.getString("username");
		this.password=resourceBundle.getString("password");
		
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
