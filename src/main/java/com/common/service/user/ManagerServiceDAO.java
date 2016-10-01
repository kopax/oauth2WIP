package com.common.service.user;

import com.common.business.user.Manager;

import java.util.List;

public interface ManagerServiceDAO {

	/**
	 * @return one {@link Manager}
	 */
	public Manager getByLogin(String login);

	/**
	 * @return a list of all {@link Manager}s
	 */
	public List<Manager> getAll();

	/**
	 * @return one {@link Manager}
	 */
	public Manager getById(Integer id);

	/**
	 * @param manager
	 * @return employee
	 */
	public Manager save(Manager manager);


	/**
	 * @param id
	 * @return null
	 */
	public void removeById(Integer id);

}
