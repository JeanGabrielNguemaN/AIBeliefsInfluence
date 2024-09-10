package org.jgnn.study.web.securejpa.config;

import java.util.HashMap;
import java.util.Properties;

import javax.naming.NamingException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.jgnn.study.web.securejpa.RandomNumberGerator;
import org.jgnn.study.web.securejpa.dao.ActivityDao;
import org.jgnn.study.web.securejpa.dao.NewsDao;
import org.jgnn.study.web.securejpa.dao.RespostaDao;
import org.jgnn.study.web.securejpa.service.ActivityService;
import org.jgnn.study.web.securejpa.service.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.annotation.ApplicationScope;


@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "org.jgnn.study.web.securejpa")
public class PersistenceBeansConfig {

   // @Autowired
   // private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("org.jgnn.study.web.securejpa.model");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(additionalProperties());

        return em;
    }
     

    /*
    @Bean
    public DataSource dataSource() throws NamingException {
        return (DataSource) new JndiTemplate().lookup(env.getProperty("jdbc.url"));
    }
    */
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
     
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("jeansi21");
        dataSource.setUrl("jdbc:mysql://localhost:3306/iaperceptiondb?useTimezone=true&serverTimezone=UTC"); 
        
         
        return dataSource;
    }
    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
   
    final Properties additionalProperties() {
    	
        final Properties hibernateProperties = new Properties();
        
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", 
        										"update");
        hibernateProperties.setProperty("hibernate.dialect", 
        											"org.hibernate.dialect.MySQL5Dialect");
        hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", "false");
        return hibernateProperties;
    }
   


	@Bean
    public RespostaService respostaService() throws Exception {

		EntityManagerFactory emf = entityManagerFactory().getNativeEntityManagerFactory();
    	
        return new  RespostaService(emf, respostaDao());
    }

	
	@Bean
	public RespostaDao respostaDao() throws Exception {
		
		EntityManagerFactory emf = entityManagerFactory().getNativeEntityManagerFactory();
    	
        return new RespostaDao(emf);
	}
	
    @Bean
	public ActivityDao activityDao() throws Exception {
		
		EntityManagerFactory emf = entityManagerFactory().getNativeEntityManagerFactory();
    	
        return new ActivityDao(emf);
	}
    
    @Bean
	public NewsDao newsDao() throws Exception {
		
		EntityManagerFactory emf = entityManagerFactory().getNativeEntityManagerFactory();
    	
        return new NewsDao(emf);
	}
    
    
    
    @Bean
    public ActivityService activityService() throws Exception {

        return new  ActivityService(activityDao(), newsDao());
    }

   

    /*
    final Properties additionalProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", "false");
        return hibernateProperties;
    }*/
    


	@Bean
	@ApplicationScope
	public RandomNumberGerator randomNumberGerator() {
		return new RandomNumberGerator(101);
	}

}