package com.common.web;

import com.common.business.db.BackupUtils;
import com.common.business.db.SchemaVersion;
import com.common.business.user.Employee;
import com.common.business.user.EmployeeOld;
import com.common.service.db.SchemaVersionService;
import com.common.service.user.EmployeeService;
import com.commonTools.model.Snoop;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This is a test controller, we do not care about it's units tests and conventions
 */
@RestController
public class TestController {


	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired private EmployeeService employeeService;
	@Autowired private SchemaVersionService schemaVersionService;


	@RequestMapping("/test/backup/restore")
	public String restoreDbBackup(String sql) {
		BackupUtils.Restoredbfromsql(sql);
		return "Restore done";
	}

	@RequestMapping("/test/schemaVersionList.json")
	@PreAuthorize("hasAuthority('MANAGER')")
	public List<SchemaVersion> getSchemaVersionList() {
		return schemaVersionService.getSchemaVersionList();
	}


	@RequestMapping("/test/logger.json")
	public String logger() {
		logger.debug("This is a debug message");
		logger.info("This is a info message");
		logger.warn("This is a warn message");
		logger.error("This is a error message");
		return "Check your console and/or log file";
	}


	@RequestMapping("/test/noDbEmployeeSample.json")
	public Employee employeeSample() {
		Employee e = new Employee("Jason", "Bourne", "test", null);
		e.setFirstName("Dimitri");
		e.setLastName("Kopriwa");
		return e;
	}

	@RequestMapping("/test/dbEmployeeSample.json")
	public Employee dbEmployeeSample() {
		Employee dbEmployeeSample = employeeService.getById(1);
		if( null == dbEmployeeSample ){
			dbEmployeeSample = new Employee("Jason", "Bourne", "test", null);
			employeeService.save(dbEmployeeSample);
			dbEmployeeSample = employeeService.getById(dbEmployeeSample.getId());
			dbEmployeeSample.setLastName("Stateman");
			employeeService.save(dbEmployeeSample);
			dbEmployeeSample = employeeService.getById(dbEmployeeSample.getId());
			employeeService.removeById(dbEmployeeSample.getId());
		}
		return dbEmployeeSample;
	}


}
