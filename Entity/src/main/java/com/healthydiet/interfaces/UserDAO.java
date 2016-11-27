package com.healthydiet.interfaces;

import com.healthydiet.entity.User;

import java.sql.SQLException;

/**
 * Created by Яна on 29.10.2016.
 */
public interface UserDAO {
    public void addUser(User user) throws SQLException;
    public void updateUser(User user) throws SQLException;
    public User getUserById(int id) throws SQLException;
    public User getUserByUsernameAndPassword(String username, String password);
    public void deleteUser(User user) throws SQLException;
}
