package com.persistence;

import com.commonTools.model.DBObject;

import java.util.List;

public interface ReferenceMapper {

	/**
	 * @return List<TypeEmployee>
	 */
	public List<DBObject> getTypeEmployeeList();
}
