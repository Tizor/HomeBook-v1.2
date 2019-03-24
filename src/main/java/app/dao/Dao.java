package app.dao;

import app.model.User;

import java.util.List;

public interface Dao {

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser (int UserId);

    public List<User> allUsers();

    public User getId(int UserId);
}
