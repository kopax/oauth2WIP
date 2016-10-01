package com.common.config;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.io.IOException;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	@Qualifier("tokenServices")
	private DefaultTokenServices tokenServices;

	@Override
	public void configure(final HttpSecurity http) throws Exception {
		// @formatter:off
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).and().authorizeRequests()
				.anyRequest().authenticated();
		// .requestMatchers().antMatchers("/foos/**","/bars/**")
		// .and()
		// .authorizeRequests()
		// .antMatchers(HttpMethod.GET,"/foos/**").access("#oauth2.hasScope('foo')
		// and #oauth2.hasScope('read')")
		// .antMatchers(HttpMethod.POST,"/foos/**").access("#oauth2.hasScope('foo')
		// and #oauth2.hasScope('write')")
		// .antMatchers(HttpMethod.GET,"/bars/**").access("#oauth2.hasScope('bar')
		// and #oauth2.hasScope('read')")
		// .antMatchers(HttpMethod.POST,"/bars/**").access("#oauth2.hasScope('bar')
		// and #oauth2.hasScope('write') and hasRole('ROLE_ADMIN')")
		;
		// @formatter:on
	}

	// Remote token service
/*
	@Primary
	@Bean
	public RemoteTokenServices tokenService() {
		final RemoteTokenServices tokenService = new RemoteTokenServices();
		tokenService.setCheckTokenEndpointUrl("http://localhost:8080/oauth/check_token");
		tokenService.setClientId("backoffice");
		tokenService.setClientSecret("kopax");
		return tokenService;
	}
*/

	// JWT token store

	@Override
	public void configure(final ResourceServerSecurityConfigurer config) {
		config.tokenServices(tokenServices);
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		// converter.setSigningKey("123");
		final Resource resource = new ClassPathResource("public.txt");
		String publicKey = null;
		try {
			publicKey = IOUtils.toString(resource.getInputStream());
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
		converter.setVerifierKey(publicKey);
		return converter;
	}

/*
	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore());
		return defaultTokenServices;
	}

	// JDBC token store configuration


	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataV1DataSourceConfig.getDataSource());
	}
*/
}
