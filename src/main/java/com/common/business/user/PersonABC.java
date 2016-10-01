package com.common.business.user;

import com.commonTools.model.SnoopDBObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public abstract class PersonABC extends SnoopDBObject implements Serializable {

	private static final Logger logger = LoggerFactory.getLogger(PersonABC.class);

	private String firstName;
	private String lastName;

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

	@Override
	public String getDescription() {
		return getFirstName() + " " + getLastName();
	}
}
