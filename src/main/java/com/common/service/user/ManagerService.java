package com.common.service.user;

import com.common.business.user.Manager;
import com.persistence.ManagerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ManagerService")
public class ManagerService {

	private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

	@Autowired
	private ManagerMapper managerMapper;


	public Manager getByLogin(String login){
		Manager manager = managerMapper.getByLogin(login);
		return manager;
	}

	public List<Manager> getAll() {
		List<Manager> managerList = managerMapper.getAll();
		return managerList;
	}

	public Manager getById(Integer id){
		Manager manager = managerMapper.getById(id);
		return manager;
	}

	public Manager save(Manager manager) {
		if (null == manager.getId()) {
			managerMapper.insert(manager);
			return manager;
		} else {
			managerMapper.update(manager);
			return manager;
		}
	}

	public void removeById(Integer id){
		logger.debug("removeById", id);
		managerMapper.removeById(id);
	}

}
