package app.service;

import app.model.User;

import java.util.List;

public interface UserService {

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser (int UserId);

    public List<User> allUsers();

    public User getId(int UserId);
}
