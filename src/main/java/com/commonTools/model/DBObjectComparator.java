package com.commonTools.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;

public class DBObjectComparator implements Comparator<DBObject>
{

	private static final Logger logger = LoggerFactory.getLogger(DBObjectComparator.class);

	public int compare( DBObject db1,
	                    DBObject db2 )
	{
		return new Integer( db1.getId() ).compareTo( new Integer( db2.getId()) );
	}
}
