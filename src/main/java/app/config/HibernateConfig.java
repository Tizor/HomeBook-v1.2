package app.config;

import app.dao.Dao;
import app.dao.DaoImpl;
import app.model.User;
import app.service.UserService;
import app.service.UserServiceImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "app")
public class HibernateConfig {
    LocalSessionFactoryBean factoryBean;

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource DS = new DriverManagerDataSource();
        DS.setUrl("jdbc:mysql://localhost:3306/phone_book5");
        DS.setUsername("root");
        DS.setPassword("root");
        DS.setDriverClassName("com.mysql.jdbc.Driver");
        return DS;
    }

    @Bean
    public SessionFactory getSessionFactory() {
         factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());

        Properties props = new Properties();
        props.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        factoryBean.setHibernateProperties(props);
        factoryBean.setAnnotatedClasses(User.class);

        SessionFactory sf = factoryBean.getObject();
        return sf;
    }


    @Bean
    public Dao getDao() {
        return new DaoImpl(getSessionFactory());}


        @Bean
        public UserService getUserService () {

        return new UserServiceImpl(getDao());
        }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory());
        return transactionManager;}

    }

