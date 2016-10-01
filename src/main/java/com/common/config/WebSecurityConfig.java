//package com.common.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
//@Configuration
//@Order(1)
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//				.authorizeRequests().antMatchers("/login").permitAll()
//				.anyRequest().authenticated()
//				.and()
//				.formLogin().permitAll();
//
////		http
////				.authorizeRequests()
////				.anyRequest().fullyAuthenticated()
////				.and()
////				.formLogin();
//
//		//http.httpBasic().and().authorizeRequests().anyRequest().authenticated().and().csrf().disable();
//	}
//
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.ldapAuthentication()
//				.contextSource().url("ldaps://master-rbx-01.kopaxgroup.com:636/dc=kopaxgroup,dc=com")
//				.managerDn("cn=readonly,dc=kopaxgroup,dc=com").managerPassword("XyztK0p4x")
//				.and()
////				.userSearchBase("ou=users")
//				.userSearchFilter("(uid={0})");
////		auth
////				.ldapAuthentication()
////				.userDnPatterns("uid={0},ou=people")
////				.groupSearchBase("ou=groups")
////				.contextSource().ldif("classpath:db/ldap/test-server.ldif");
////		auth
////				.ldapAuthentication()
////				.userDnPatterns("uid={0}")
////				//.groupSearchBase("ou=groups")
////				//.userSearchFilter("(&(objectClass=posixAccount)(memberOf=cn=module_users,ou=groups,ou=school,o=kopax,dc=kopaxgroup,dc=com))")
////				.contextSource()
////				.root("dc=kopaxgroup,dc=com")
////				.managerDn("cn=readonly,dc=kopaxgroup,dc=com")
////				.managerPassword("XyztK0p4x")
////				.url("ldaps://master-rbx-01.kopaxgroup.com");
//
//				//.ldif("classpath:test-server.ldif");
//	}
//}