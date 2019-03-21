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

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource DS = new DriverManagerDataSource();
        DS.setUrl("jdbc:mysql://localhost:3306/phone_book5");
        DS.setUsername("root");
        DS.setPassword("root");
        DS.setDriverClassName("com.mysql.jdbc.Driver");
        return DS;
    }

    @Bean
    public SessionFactory getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());

        Properties props=new Properties();
        props.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        factoryBean.setHibernateProperties(props);
        factoryBean.setAnnotatedClasses(User.class);

        SessionFactory sf = factoryBean.getObject();
        return sf;
    }

    /*   @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());

        Properties props=new Properties();
        props.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        factoryBean.setHibernateProperties(props);
        factoryBean.setAnnotatedClasses(User.class);
        return factoryBean;
    }*/

  /*  @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }*/

    @Bean
public Dao getDao(){
        return new DaoImpl(getSessionFactory());
    }

    @Bean
    public UserService getUserService(){
        return new UserServiceImpl(getDao());
    }

}

/*<bean id="bookDao" class="net.proselyte.bookmanager.dao.BookDaoImpl">
        <property name="sessionFactory" ref="hibernate4AnnotatedSessionFactory"/>
    </bean>

    <bean id="bookService" class="net.proselyte.bookmanager.service.BookServiceImpl">
        <property name="bookDao" ref="bookDao"/>
    </bean>*/

/*public class HibernateConfig {

    private  static  SessionFactory  sessionFactory;
    private static Session session;

    private static LocalSessionFactoryBean localSessionFactoryBean;

    @Bean
    public LocalSessionFactoryBean getSession() throws HibernateException {

        Properties prop = new Properties();

        prop.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
        prop.setProperty(Environment.URL,  "jdbc:mysql://localhost:3306/phone_book5");
        prop.setProperty(Environment.USER, "root");
        prop.setProperty(Environment.PASS, "root");
        prop.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

        Configuration config = new Configuration();
        config.setProperties(prop);
        config.addAnnotatedClass(User.class);

        if(localSessionFactoryBean == null) {
            localSessionFactoryBean = config.buildSessionFactory();
            localSessionFactoryBean = sessionFactory.openSession();
            return  localSessionFactoryBean;
        }
        localSessionFactoryBean = sessionFactory.openSession();
        return localSessionFactoryBean;
    }*/


