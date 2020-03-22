package com.cognizant.employee.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.cognizant")
@PropertySource(value = { "classpath:db.properties" })
public class AppConfig {
	@Autowired
	private Environment env;

	@Bean
	public DataSource getDataSourceBean() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(env.getRequiredProperty("driver"));
		datasource.setUrl(env.getRequiredProperty("url"));
		datasource.setUsername(env.getRequiredProperty("user"));
		datasource.setPassword(env.getRequiredProperty("password"));
		return datasource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		return jdbcTemplate;

	}
}