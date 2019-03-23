package app.service;
import app.dao.Dao;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;



public class UserServiceImpl implements UserService {

    private Dao dao;

    public UserServiceImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void AddUser(User user) {
        this.dao.AddUser(user);
    }

    @Override
    @Transactional
    public void UpdateUser(User user) {
        this.dao.UpdateUser(user);
    }

    @Override
    @Transactional
    public void DeleteUser(int UserId) {
        this.dao.DeleteUser(UserId);
    }

    @Override
    @Transactional
    public List<User> AllUsers() {
        return dao.AllUsers();
    }

    @Override
    @Transactional
    public User GetId(int UserId) {
        return this.dao.GetId(UserId);
    }
}
