package app.dao;

import app.model.User;

import java.util.List;

public interface Dao {

    public void AddUser(User user);

    public void UpdateUser(User user);

    public void DeleteUser (int UserId);

    public List<User> AllUsers();

    public User GetId(int UserId);
}
