package com.common.service.user;

import com.common.business.user.Employee;
import com.persistence.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EmployeeService")
public class EmployeeService implements EmployeeServiceDAO {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired private EmployeeMapper employeeMapper;

	public List<Employee> getAll() {
		List<Employee> employeeList = employeeMapper.getAll();
		return employeeList;
	}

	public Employee getById(Integer id){
		Employee employee = employeeMapper.getById(id);
		return employee;
	}

	public Employee save(Employee employee) {
		if (null == employee.getId()) {
			employeeMapper.insert(employee);
			return employee;
		} else {
			employeeMapper.update(employee);
			return employee;
		}
	}

	public void removeById(Integer id){
		employeeMapper.removeById(id);
	}

}
