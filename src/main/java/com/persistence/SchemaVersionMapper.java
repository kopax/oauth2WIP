package com.persistence;

import com.common.business.db.SchemaVersion;

import java.util.List;

public interface SchemaVersionMapper {

	/**
	 * @return List<SchemaVersion>
	 */
	public List<SchemaVersion> getSchemaVersionList();

}
