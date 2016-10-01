package com.common.service.reference;

import com.commonTools.model.DBObject;
import com.persistence.ReferenceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ReferenceService")
public class ReferenceService {

	private static final Logger logger = LoggerFactory.getLogger(ReferenceService.class);

	@Autowired private ReferenceMapper referenceMapper;

	public List<DBObject> getTypeEmployeeList() {
		List<DBObject> typeEmployeeList = referenceMapper.getTypeEmployeeList();
		if( null != typeEmployeeList ){
			logger.debug(typeEmployeeList.toString());
		}
		return typeEmployeeList;
	}

}
