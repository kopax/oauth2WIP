package com.common.web;

import com.common.business.user.Employee;
import com.common.service.user.EmployeeService;
import com.common.store.ApiPointStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPointStore.EMPLOYEE)
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> getUserList(){
		return employeeService.getAll();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody Employee employee){
		employeeService.save(employee);
	}

	@RequestMapping(value = ApiPointStore.PARAM_ID, method = RequestMethod.GET)
	public Employee getById(@PathVariable Integer id){
		return employeeService.getById(id);
	}

	@RequestMapping(value = ApiPointStore.PARAM_ID, method = RequestMethod.DELETE)
	public void removeById(@PathVariable Integer id){
		employeeService.removeById(id);
	}

}
