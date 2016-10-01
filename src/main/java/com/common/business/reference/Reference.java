package com.common.business.reference;

import com.commonTools.model.DBObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Reference {

	private static final Logger logger = LoggerFactory.getLogger(Reference.class);

	private List<DBObject> typeEmployeeList;

	public List<DBObject> getTypeEmployeeList() {
		return typeEmployeeList;
	}

	public void setTypeEmployeeList(List<DBObject> typeEmployeeList) {
		this.typeEmployeeList = typeEmployeeList;
	}
}
