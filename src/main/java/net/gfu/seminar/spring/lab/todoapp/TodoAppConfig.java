package net.gfu.seminar.spring.lab.todoapp;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableTransactionManagement
// Ohne Parameteter gleichbedeutend mit:
// @ComponentScan(basePackageClasses = {TodoAppConfig.class})
public class TodoAppConfig {

	@Bean
	// Auch möglich: @Lazy @Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:./todo;DB_CLOSE_DELAY=-1;INIT=CREATE SCHEMA IF NOT EXISTS testDatabase");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
	
	//@Bean
    public DataSource otherDataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript("classpath:com/bank/config/sql/schema.sql")
            .addScript("classpath:com/bank/config/sql/test-data.sql")
            .build();
    }
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan("net.gfu.seminar.spring.lab.todoapp.domain");
		
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		factory.setJpaVendorAdapter(adapter);
		factory.setJpaProperties(additionalProperties());
		return factory;
	}
	
	@Bean @Autowired
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager txm = new JpaTransactionManager();
		txm.setEntityManagerFactory(emf);
		return txm;
	}

	private Properties additionalProperties() {
		Properties prop = new Properties();
        prop.setProperty("hibernate.hbm2ddl.auto", "update");
        prop.setProperty("hibernate.id.new_generator_mappings", "true");
		return prop;
	}
	
}
