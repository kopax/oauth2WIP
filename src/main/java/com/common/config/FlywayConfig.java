package com.common.config;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class FlywayConfig {

	private final static Logger logger = LoggerFactory.getLogger(FlywayConfig.class);


	@Autowired
	private DataV1DataSourceSettings dataV1DataSourceSettings;

	@Autowired
	private DataV1DataSourceConfig dataV1DataSourceConfig;

	@Bean(initMethod = "migrate")
	public Flyway flyway() {
		Flyway flyway = new Flyway();
		flyway.setBaselineOnMigrate(true);
		flyway.setLocations("classpath:db/migration");
		flyway.setSqlMigrationPrefix("V");
		flyway.setSqlMigrationSuffix(".sql");
		flyway.setEncoding("UTF-8");
		flyway.setValidateOnMigrate(false);
		flyway.setOutOfOrder(true);
		flyway.setTargetAsString(dataV1DataSourceSettings.getVersion());
		flyway.setDataSource(dataV1DataSourceConfig.getDataSource());
		return flyway;
	}

	//	@Override
//	public void afterPropertiesSet() throws Exception {
//		try {
//			logger.info("afterPropertiesSet");
//			Flyway flyway = new Flyway();
//			flyway.setDataSource(dataSource());
//			flyway.setLocations("classpath:db/migration");
//			flyway.setSqlMigrationPrefix("V");
//			flyway.setSqlMigrationSuffix(".sql");
//			flyway.setEncoding("UTF-8");
//			flyway.setValidateOnMigrate(false);
//			flyway.setOutOfOrder(true);
//			flyway.setTargetAsString(connectionSettings.getVersion());
//			//flyway.init();
//			flyway.migrate();
//			logger.info("flyway migrated!");
//		} catch (FlywayException ex) {
//			logger.warn("flyway not migrated!", ex);
//		}
//	}
}
