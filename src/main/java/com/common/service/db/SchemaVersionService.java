package com.common.service.db;

import com.common.business.db.SchemaVersion;
import com.persistence.SchemaVersionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SchemaVersionService")
public class SchemaVersionService implements SchemaVersionServiceDAO {


	private static final Logger logger = LoggerFactory.getLogger(SchemaVersionService.class);

	@Autowired
	private SchemaVersionMapper schemaVersionMapper;

	/**
	 * @return List<SchemaVersion>
	 */
	public List<SchemaVersion> getSchemaVersionList(){
		List<SchemaVersion> schemaVersionList = schemaVersionMapper.getSchemaVersionList();
		if( null != schemaVersionList ){
			logger.debug(schemaVersionList.toString());
		}
		return schemaVersionList;
	}

}
