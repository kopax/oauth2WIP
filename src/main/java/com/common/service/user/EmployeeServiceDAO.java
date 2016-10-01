package com.common.service.user;

import com.common.business.user.Employee;
import com.common.business.user.EmployeeOld;

import java.util.List;

public interface EmployeeServiceDAO {

	/**
	 * @return a list of all {@link Employee}s
	 */
	public List<Employee> getAll();

	/**
	 * @return one {@link Employee}
	 */
	public Employee getById(Integer id);

	/**
	 * @param employee
	 * @return employee
	 */
	public Employee save(Employee employee);


	/**
	 * @param id
	 * @return null
	 */
	public void removeById(Integer id);

}
