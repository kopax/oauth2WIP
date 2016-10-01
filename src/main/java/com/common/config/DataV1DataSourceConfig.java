package com.common.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Configuration
public class DataV1DataSourceConfig {


	@Autowired
	private DataV1DataSourceSettings dataV1DataSourceSettings;

	private String version = "0.0.0";

	@Bean
	public DriverManagerDataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(dataV1DataSourceSettings.getUrl());
		dataSource.setUsername(dataV1DataSourceSettings.getUsername());
		dataSource.setPassword(dataV1DataSourceSettings.getPassword());
		dataSource.setDriverClassName(dataV1DataSourceSettings.getDriverClassName());
		// TODO read these prod params (http://stackoverflow.com/questions/31010989/spring-and-mysql-connections-keeps-creating-new-connections-instead-using-sleep)
		Properties properties = new Properties();
		properties.put("minIdle", dataV1DataSourceSettings.getMinIdle());
		properties.put("maxIdle", dataV1DataSourceSettings.getMaxIdle());
		properties.put("maxActive", dataV1DataSourceSettings.getMaxActive());
		properties.put("maxWait", dataV1DataSourceSettings.getMaxWait());
		properties.put("testOnBorrow", dataV1DataSourceSettings.getTestOnBorrow());
		properties.put("validationQuery", dataV1DataSourceSettings.getValidationQuery());
		properties.put("timeBetweenEvictionRunsMillis", dataV1DataSourceSettings.getTimeBetweenEvictionRunsMillis());
		properties.put("numTestsPerEvictionRun", dataV1DataSourceSettings.getNumTestsPerEvictionRun());
		properties.put("minEvictableIdleTimeMillis", dataV1DataSourceSettings.getMinEvictableIdleTimeMillis());
		properties.put("testWhileIdle", dataV1DataSourceSettings.getTestWhileIdle());
		dataSource.setConnectionProperties(properties);
		return dataSource;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(getDataSource());
	}

}
