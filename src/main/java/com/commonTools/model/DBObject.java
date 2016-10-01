package com.commonTools.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class DBObject implements Comparable<DBObject>, Cloneable {

	private static final Logger logger = LoggerFactory.getLogger(DBObject.class);

	private Integer id;
	private String description;

	public int compareTo( DBObject arg0 )
	{
		return this.getDescription().compareTo( arg0.getDescription() );
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
