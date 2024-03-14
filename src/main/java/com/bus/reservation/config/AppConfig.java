package com.bus.reservation.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.bus.reservation")
@PropertySource("classpath:/com/bus/reservation/properties/general.properties")
@EnableJpaRepositories(basePackages = "com.bus.reservation.repo")
public class AppConfig implements WebMvcConfigurer{

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

//	@Bean
//	public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {
//		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource());
//		sessionFactory.setHibernateProperties(properties());
//		sessionFactory.setPackagesToScan("com.bus.reservation.entity");
//		return sessionFactory;
//	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		HibernateJpaVendorAdapter vendorAdaptor = new HibernateJpaVendorAdapter();
		entityManager.setDataSource(dataSource());
		entityManager.setJpaVendorAdapter(vendorAdaptor);
		entityManager.setPackagesToScan("com.bus.reservation.entity");
		entityManager.setJpaProperties(properties());
		return entityManager;
	}

	@Bean
	public Properties properties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}

	@Bean
	public DataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("guruCta");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/bus-reservation");
		dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
		dataSource.setInitialPoolSize(10);
		dataSource.setAcquireIncrement(5);
		dataSource.setMaxIdleTime(3000);
		dataSource.setMaxPoolSize(50);
		return dataSource;
	}
	
	@Bean
	public DataSourceInitializer dataSourceInitializer(@Qualifier("dataSource") final DataSource dataSource) {
	    ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
	    System.out.println("Inside dataSourceInitializer()...");
	    resourceDatabasePopulator.addScript(new ClassPathResource("data.sql"));
	    DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
	    dataSourceInitializer.setDataSource(dataSource);
	    dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
	    return dataSourceInitializer;
	}

//	@Bean
//	public HibernateTransactionManager transactionManager() {
//		HibernateTransactionManager transaction = new HibernateTransactionManager(sessionFactory);
//		return transaction;
//	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
	    JpaTransactionManager txManager = new JpaTransactionManager();
	    txManager.setEntityManagerFactory(entityManagerFactory);
	    return txManager;
	}
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/images").setCachePeriod(3600);
	}

}
