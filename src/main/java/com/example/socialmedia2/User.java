package com.example.socialmedia2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class User {
    private int userID;
    private String userName;
    private String password;
    private List<User> followers;
    private List<Posts> posts;

    public User(int userID, String userName, String password, List<User> followers, List<Posts> posts) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.followers = followers;
        this.posts = posts;
    }

    public void retrieveUserDataFromDatabase(Connection connection) throws SQLException {
        // Retrieve user data from the database based on the username
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE username = ?");
        statement.setString(1, userName);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            // Retrieve and set user properties from the database
            // Example: this.username = resultSet.getString("username");
            // Example: this.password = resultSet.getString("password");
        }
    }
public User(String userName,String password){
    this.userName = userName;
    this.password = password;

}
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", followers=" + followers +
                ", posts=" + posts +
                '}';
    }
}


