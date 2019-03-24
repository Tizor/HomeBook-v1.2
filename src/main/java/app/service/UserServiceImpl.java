package app.service;
import app.dao.Dao;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
public class UserServiceImpl implements UserService {

@Autowired
    private Dao dao;

    @Override
    @Transactional
    public void addUser(User user) {
        this.dao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.dao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int UserId) {
        this.dao.deleteUser(UserId);
    }

    @Override
    @Transactional
    public List<User> allUsers() {
        return dao.allUsers();
    }

    @Override
    @Transactional
    public User getId(int UserId) {
        return this.dao.getId(UserId);
    }
}
