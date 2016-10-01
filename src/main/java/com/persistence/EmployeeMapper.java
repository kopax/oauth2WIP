package com.persistence;

import com.common.business.user.Employee;

import java.util.List;

public interface EmployeeMapper {

	/**
	 * @return all the employees
	 */
	public List<Employee> getAll();

	/**
	 * @return one employee
	 */
	public Employee getById(Integer id);

	/**
	 * @param employee
	 * @return the number of rows affected
	 */
	public Integer insert(Employee employee);

	/**
	 * @param employee
	 * @return the number of rows affected
	 */
	public Integer update(Employee employee);

	/**
	 * @param id
	 * @return null
	 */
	public void removeById(Integer id);

}