package com.commonTools.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Define a DBObject that also have these columns to snoop another column
 */
public abstract class SnoopDBObject extends DBObject implements Serializable, Comparable<DBObject>, Cloneable {

	private static final Logger logger = LoggerFactory.getLogger(SnoopDBObject.class);

	private Snoop creation;
	private Snoop modification;

	public Snoop getCreation() {
		return creation;
	}

	public void setCreation(Snoop creation) {
		this.creation = creation;
	}

	public Snoop getModification() {
		return modification;
	}

	public void setModification(Snoop modification) {
		this.modification = modification;
	}
}
