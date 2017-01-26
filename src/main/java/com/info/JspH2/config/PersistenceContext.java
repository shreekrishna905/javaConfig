package com.info.JspH2.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@ComponentScan(basePackages="com.info.JSPH2.service")
public class PersistenceContext {

	
	@Bean
	   public DataSource restDataSource() {
		
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
			.addScript("db/sql/create-db.sql")
			.addScript("db/sql/insert-db.sql")
			.build();
		return db;
	   }
	
	@Bean
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(restDataSource());
	}
	
	
}
