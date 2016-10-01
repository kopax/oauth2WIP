package com.common.business.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Manager implements UserDetails, CredentialsContainer {

	public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

	private Integer id;

	private String login;

	private @JsonIgnore	String password;

	private List<Role> roleList;

	protected Manager() {}

	public Manager(String login, String password, List<Role> roleList) {
		setLogin(login);
		setPassword(password);
		setRoleList(roleList);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	/**
	 * Set password attributes as it is.
	 * @param password
	 */
	public void setHash(String password) { this.password = password; }

	/**
	 * Set and encode password attributes.
	 * @param rawPassword
	 */
	public void setPassword(String rawPassword) {
		this.password = PASSWORD_ENCODER.encode(rawPassword);
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>(getRoleList().size());

		for (Role role : getRoleList()) {
			String roleStr = role.toString();
			authorities.add(
					new SimpleGrantedAuthority(roleStr)
			);
		}

		return authorities;
	}

	@Override
	public String getUsername() {
		return getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public void eraseCredentials() {
		setPassword(null);
	}
}
