package com.common.config;

import com.common.business.user.Employee;
import com.common.business.user.Manager;
import com.common.business.user.Role;
import com.common.service.user.EmployeeService;
import com.common.service.user.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;

@Configuration
public class DatabaseLoader implements CommandLineRunner {

	@Autowired
	private final EmployeeService employeeService;

	@Autowired
	private final ManagerService managerService;

	@Autowired
	public DatabaseLoader(EmployeeService employeeService,
	                      ManagerService managerService) {

		this.employeeService = employeeService;
		this.managerService = managerService;
	}

	@Override
	public void run(String... strings) throws Exception {
		ArrayList<Role> dkaRoleList = new ArrayList<>();

		Manager test = this.managerService.getByLogin("dka");

		if( null == test )
		{
			dkaRoleList.add(Role.MANAGER);
			Manager dka = this.managerService.save(new Manager("dka", "dka", dkaRoleList));

			ArrayList<Role> ajtRoleList = new ArrayList<>();
			ajtRoleList.add(Role.USER);
			Manager ajt = this.managerService.save(new Manager("ajt", "ajt", ajtRoleList));

			SecurityContextHolder.getContext().setAuthentication(
					new UsernamePasswordAuthenticationToken("dka", null, dka.getAuthorities())
			);

			this.employeeService.save(new Employee("Frodo", "Baggins", "ring bearer", dka));
			this.employeeService.save(new Employee("Bilbo", "Baggins", "burglar", dka));
			this.employeeService.save(new Employee("Gandalf", "the Grey", "wizard", dka));

			SecurityContextHolder.getContext().setAuthentication(
					new UsernamePasswordAuthenticationToken("oliver", null, ajt.getAuthorities())
			);

			this.employeeService.save(new Employee("Samwise", "Gamgee", "gardener", ajt));
			this.employeeService.save(new Employee("Merry", "Brandybuck", "pony rider", ajt));
			this.employeeService.save(new Employee("Peregrin", "Took", "pipe smoker", ajt));

		}

		SecurityContextHolder.clearContext();
	}
}