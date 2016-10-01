package com.common.service.reference;

import com.commonTools.model.DBObject;

import java.util.List;

public interface ReferenceServiceDAO {

	/**
	 * @return List<TypeEmployee>
	 */
	public List<DBObject> getTypeEmployeeList();
}
