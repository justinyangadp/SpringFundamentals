package com.example;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;


@Configuration
@PropertySource("classpath:app.properties")
@ComponentScan("com.example")
public class Config {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.HSQL)
            .addScript("classpath:schema.sql") 
            .addScript("classpath:data.sql")   
            .build();
    }

    // TODO-02: Examine this LocalContainerEntityManagerFactoryBean.
    // 1) It is a Specialized Spring FactoryBean that creates JPA EntityManagerFactory instances.
    // 2) Setting the datasources makes it aware of the database dialect (e.g. Oracle, MySQL, etc.)
    // 3) We tell it the location of our @Entity classes.
    // 4) We set the JPA vendor adapter to Hibernate.
    // 5) Setting Hibernate specific properties to show well formatted SQL - very useful when debugging.
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
        var emfb = new	LocalContainerEntityManagerFactoryBean();	    // (1)
        emfb.setDataSource(ds);									        // (2)
        emfb.setPackagesToScan("com.example.domain");                   // (3)

        var adapter = new HibernateJpaVendorAdapter();				    // (4)
        emfb.setJpaVendorAdapter(adapter);

        var props = new Properties();									// (5)
        props.setProperty("hibernate.show_sql", "true"); 
        props.setProperty("hibernate.format_sql", "true"); 
        props.setProperty("hibernate.use_sql_comments", "true"); 

        emfb.setJpaProperties(props);
        return emfb;
    }  

    //  TODO-03: define a transactionManager @Bean of type PlatformTransactionManager.
    //  Inject the bean method with a reference to an EntityManagerFactory.
    //  Instantiate and return a JpaTransactionManager injected with the EntityManagerFactory.
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

}
