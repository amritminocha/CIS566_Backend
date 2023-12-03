package com.hotel.api.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
public class DatabaseConfig {

	@Value("${spring.datasource.url}")
	private String dataSourceUrl;

	@Value("${spring.datasource.username}")
	private String dataSourceUsername;

	@Value("${spring.datasource.password}")
	private String dataSourcePassword;

	@Value("${spring.datasource.driver-class-name}")
	private String dataSourceDriverClassName;

	private static JdbcTemplate jdbcTemplateInstance;

	@Bean
	public JdbcTemplate jdbcTemplate() {
		if (jdbcTemplateInstance == null) {
			jdbcTemplateInstance = createJdbcTemplate();
		}
		return jdbcTemplateInstance;
	}

	private JdbcTemplate createJdbcTemplate() {
		DataSource dataSource = createDataSource();

		return new JdbcTemplate(dataSource);
	}

	private DataSource createDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dataSourceDriverClassName);
		dataSource.setUrl(dataSourceUrl);
		dataSource.setUsername(dataSourceUsername);
		dataSource.setPassword(dataSourcePassword);
		return dataSource;
	}
}
