package com.common.service.db;

import com.common.business.db.SchemaVersion;

import java.util.List;

public interface SchemaVersionServiceDAO {

	/**
	 * @return List<SchemaVersion>
	 */
	public List<SchemaVersion> getSchemaVersionList();

}
