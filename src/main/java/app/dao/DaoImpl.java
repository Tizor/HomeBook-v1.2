package app.dao;

import app.config.HibernateConfig;
import app.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.util.List;


@Repository
public class DaoImpl implements Dao {

    public SessionFactory sessionFactory;

    public DaoImpl(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    /*  @Autowired
    public HibernateConfig config;

    public Session session;*/

    @Override
    @SuppressWarnings("unchecked")
    public List<User> AllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> UserList = session.createQuery("from contacts").getResultList();
        return UserList;}



    @Override
    public void AddUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void UpdateUser(User user) {

        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);

    }

    @Override
    public void DeleteUser(int UserId) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer("UserId"));
        if (user != null) {
            session.delete(user);
        }
    }

    @Override
    public User GetId(int UserId) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer("UserId"));
        return user;
    }



 /*   @Override
    @SuppressWarnings("unchecked")
    public List<User> AllUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> UserList = session.createQuery("from contacts").list();
        return UserList;
    }*/

}
