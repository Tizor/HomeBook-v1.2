package app.dao;


import app.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class DaoImpl implements Dao {
@Autowired
    public SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {

        List<User> UserList = sessionFactory.getCurrentSession().createQuery("from User").getResultList();
        return UserList;}

    @Override
    public void addUser(User user) {

        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void updateUser(User user) {

        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);

    }

    @Override
    public void deleteUser(int UserId) {

        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(UserId));
        session.delete(user);

    }

    @Override
    public User getId(int UserId) {

        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, new Integer(UserId));
        return user;
    }


}
