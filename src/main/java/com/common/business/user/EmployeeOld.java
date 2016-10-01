package com.common.business.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EmployeeOld extends PersonABC implements Cloneable {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeOld.class);
	public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();


	private String password;
	private String[] roles;

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = PASSWORD_ENCODER.encode( password );
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}
}
