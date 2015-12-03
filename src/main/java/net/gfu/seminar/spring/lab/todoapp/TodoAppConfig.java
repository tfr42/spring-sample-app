package net.gfu.seminar.spring.lab.todoapp;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
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
@PropertySource("file:${user.dir}/database.properties")
// Ohne Parameteter gleichbedeutend mit:
// @ComponentScan(basePackageClasses = {TodoAppConfig.class})
public class TodoAppConfig {

	@Autowired
	private Environment env;
	
	@Value("${jdbc.datasource.default.url}")
	private String jdbcUrl;

	@Value("${jdbc.datasource.default.user}")
	private String jdbcUser;
	
	@Value("${jdbc.datasource.default.password}")
	private String jdbcPassword;
	
	
	@Bean @Profile({"default", "test"})
	// Auch möglich: @Lazy @Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.datasource.default.driver"));
		dataSource.setUrl(jdbcUrl);
		dataSource.setUsername(jdbcUser);
		dataSource.setPassword(jdbcPassword);
		return dataSource;
	}
	
	@Bean @Profile({"production"})
	public DataSource productionDataSource() throws Exception {
		Context ctx = new InitialContext();
		return (DataSource) ctx.lookup("java.comp/env/jdbc/todoDataSource");
	}
	
	//@Bean
    public DataSource otherDataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript("classpath:com/bank/config/sql/schema.sql")
            .addScript("classpath:com/bank/config/sql/test-data.sql")
            .build();
    }
	
	@Bean @Autowired
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource);
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

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
	
	private Properties additionalProperties() {
		Properties prop = new Properties();
        prop.setProperty("hibernate.hbm2ddl.auto", "update");
        prop.setProperty("hibernate.id.new_generator_mappings", "true");
		return prop;
	}
	
}
