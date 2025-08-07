package com.example;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;


@Configuration   
@PropertySource("classpath:app.properties")
@ComponentScan("com.example")
public class Config {


    // TODO-02: Define a DataSource bean named dataSource.
    // Use the EmbeddedDatabaseBuilder class to create an in-memory database.
    // The type of database should be HSQLDB.
    // Have it run the schema.sql and data.sql scripts on startup.
    // These files can be found in the root of the classpath:
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("classpath:schema.sql")
                .addScript("classpath:data.sql")
                .build();
    }

    // TODO-03: Define a JdbcClient bean named jdbcClient.
    // The JdbcClient has a create() factory method to create a new instance.
    // Inject it with the Datasource bean you defined above.
    @Bean
    public JdbcClient jdbcClient(DataSource dataSource) {
        return JdbcClient.create(dataSource);
    }


}
