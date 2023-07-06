package com.example.socialmedia2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class Likes {
    private User username;
    private List<User> users;
    private LocalDateTime timestamp;
    private int count;


    public Likes(User loggedInUser, List<User> users, LocalDateTime timestamp, int count) {
        this.username = loggedInUser;
        this.users = users;
        this.timestamp = timestamp;
        this.count = count;
    }

    public void retrieveUserDataFromDatabase(Connection connection) throws SQLException {
        // Retrieve user data from the database based on the username
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE username = ?");
        statement.setString(1, getUsername().getUserName());
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            // Retrieve and set user properties from the database
            // Example: this.username = resultSet.getString("username");
            // Example: this.password = resultSet.getString("password");
        }
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void addUser(User username) {
        users.add(username);
        count++;
    }

    public void removeUser(User username) {
        users.remove(username);
        count--;
    }

    @Override
    public String toString() {
        return "Likes{" +
                "username=" + username +
                ", users=" + users +
                ", timestamp=" + timestamp +
                ", count=" + count +
                '}';
    }
}
