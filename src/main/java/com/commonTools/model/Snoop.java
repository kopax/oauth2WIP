package com.commonTools.model;


import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Define an Object that store a datetime and a userId
 */
public class Snoop implements Serializable {

	private static final Logger logger = LoggerFactory.getLogger(Snoop.class);

	private DateTime dateTime;
	private Integer userId;

	public Snoop(){
		super();
	}

	public Snoop(Integer personId, DateTime dateTime) {
		super();
		this.dateTime = dateTime;
		this.userId = userId;
	}

	public DateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
