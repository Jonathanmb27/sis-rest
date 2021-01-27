package com.innova.config.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@Import({TestDBConfig.class, MysqlConfig.class,TransactionalBDConfig.class})
@ComponentScan(basePackages = {"com.innova.repository.impl","com.innova.service.impl"})
@EnableTransactionManagement
public class JdbcTemplateConfig {


    @Autowired
    DataSource dataSource;

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }

}
