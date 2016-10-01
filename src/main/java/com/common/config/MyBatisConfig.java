package com.common.config;

import com.common.business.db.SchemaVersion;
import com.common.business.user.Employee;
import com.common.business.user.Manager;
import com.common.business.user.Role;
import com.common.mybatis.typehandler.DateTimeTypeHandler;
import com.common.mybatis.typehandler.RoleListTypeHandler;
import com.commonTools.model.DBObject;
import com.commonTools.model.Snoop;
import com.commonTools.model.SnoopDBObject;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.DateTime;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("com.persistence")
public class MyBatisConfig {

	private static final Logger logger = LoggerFactory.getLogger(MyBatisConfig.class);

	@Autowired
	private DataV1DataSourceConfig dataV1DataSourceConfig;

	@Bean
	public DateTimeTypeHandler getDateTimeTypeHandler(){
		return new DateTimeTypeHandler();
	}

	@Bean
	public RoleListTypeHandler getRoleListTypeHandler() { return new RoleListTypeHandler(); }

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataV1DataSourceConfig.getDataSource());
		sessionFactory.setTypeHandlers(new TypeHandler[] {
			new DateTimeTypeHandler(),
			new RoleListTypeHandler()
		});
		sessionFactory.setTypeAliases(new Class[] {
			Role.class,
			DateTime.class,
			Manager.class,
			Employee.class,
			DBObject.class,
			Snoop.class,
			SnoopDBObject.class,
			SchemaVersion.class,
		});
		return sessionFactory;
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}