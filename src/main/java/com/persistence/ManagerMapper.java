package com.persistence;

import com.common.business.user.Manager;

import java.util.List;

public interface ManagerMapper {

	/**
	 * @return one manager
	 */
	public Manager getByLogin(String login);

	/**
	 * @return all the managers
	 */
	public List<Manager> getAll();

	/**
	 * @return one manager
	 */
	public Manager getById(Integer id);

	/**
	 * @param manager
	 * @return the number of rows affected
	 */
	public Integer insert(Manager manager);

	/**
	 * @param manager
	 * @return the number of rows affected
	 */
	public Integer update(Manager manager);

	/**
	 * @param id
	 * @return null
	 */
	public void removeById(Integer id);

}