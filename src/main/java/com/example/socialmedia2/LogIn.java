package com.example.socialmedia2;

import java.util.HashMap;

public class LogIn {
    private HashMap<String,String> user_identification = new HashMap<>();
    private HashMap<String, Boolean> loggedInUsers = new HashMap<>();


    public void registration(String username, String password){
        if(user_identification.containsKey(username)){
            System.out.println("Username already exists. Please choose a different username.");

        }else {
            user_identification.put(username,password);
            System.out.println("Registration successful! Please proceed to login");

        }
    }

    public void logIn(String username, String password) {
        if (user_identification.containsKey(username) && user_identification.get(username).equals(password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password. Please try again.");

        }}

            public Boolean logInUser (String username, String password){
                if (user_identification.containsKey(username) && user_identification.get(username).equals(password)) {

                    if (loggedInUsers.containsKey(username)) {
                        System.out.println("User is already logged in.");
                        return false;
                    } else {
                        loggedInUsers.put(username, true);

                        System.out.println("Log in successfull!");

                        return true;

                    }

                } else {
                    System.out.println("Invalid username or password. Please try again.");
                    return false;
                }
            }
            public void LogOut (String username){
                if (loggedInUsers.containsKey(username)) {
                    loggedInUsers.remove(username);
                    System.out.println("Log out successful!");

                } else {
                    System.out.println("User is not logged in!");
                }
            }

}