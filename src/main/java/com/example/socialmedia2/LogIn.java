package com.example.socialmedia2;

import java.sql.*;
import java.util.HashMap;

public class LogIn {
    private HashMap<String, String> user_identification = new HashMap<>();
    private HashMap<String, Boolean> loggedInUsers = new HashMap<>();

    public LogIn() {
        retrieveUserInformation();
    }

    public void registration(String username, String password) {
        if (user_identification.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different username.");
        } else {
            user_identification.put(username, password);
            saveUserInformation(username, password); // Save user information to the database
            System.out.println("Registration successful! Please proceed to login");
        }
    }

    public void logIn(String username, String password) {
        if (user_identification.containsKey(username) && user_identification.get(username).equals(password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    public boolean logInUser(String username, String password) {
        if (user_identification.containsKey(username) && user_identification.get(username).equals(password)) {
            if (loggedInUsers.containsKey(username)) {
                System.out.println("User is already logged in.");
                return false;
            } else {
                loggedInUsers.put(username, true);
                System.out.println("Log in successful!");
                return true;
            }
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return false;
        }
    }

    public void logOut(String username) {
        if (loggedInUsers.containsKey(username)) {
            loggedInUsers.remove(username);
            System.out.println("Log out successful!");
        } else {
            System.out.println("User is not logged in!");
        }
    }

    public void retrieveUserInformation() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialmedia", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");

            while (resultSet.next()) {
                String username = resultSet.getString("userName");
                String password = resultSet.getString("password");
                user_identification.put(username, password);
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveUserInformation(String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialmedia", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user(userName, password) VALUES (?, ?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}