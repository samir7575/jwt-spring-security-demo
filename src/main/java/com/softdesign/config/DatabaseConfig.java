package com.softdesign.config;

import com.softdesign.model.User;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * Created by malek on 21/01/17.
 */

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    @Autowired
    private ApplicationContext appContext;

    @Bean
    public HikariDataSource getDataSource()
    {
        HikariDataSource ds = new HikariDataSource();
        ds.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        ds.addDataSourceProperty("databaseName", "milkzo_blog");
        ds.addDataSourceProperty("portNumber", "3306");
        ds.addDataSourceProperty("serverName", "127.0.0.1");
        ds.addDataSourceProperty("user", "root");
        ds.addDataSourceProperty("password", "********");

        return ds;
    }


    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(hibernate5SessionFactoryBean().getObject());
        return manager;
    }

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean hibernate5SessionFactoryBean(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(appContext.getBean(HikariDataSource.class));
        localSessionFactoryBean.setAnnotatedClasses(
                User.class
        );

        Properties properties = new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        //properties.put("hibernate.current_session_context_class","thread");
        properties.put("hibernate.hbm2ddl.auto","update");

        localSessionFactoryBean.setHibernateProperties(properties);
        return localSessionFactoryBean;
    }

}
