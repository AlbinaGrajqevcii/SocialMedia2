package com.example.socialmedia2;

import java.util.HashMap;

public class LogIn {
    private HashMap<String,String> user_identification = new HashMap<>();
    private HashMap<String, Boolean> loggedInUsers = new HashMap<>();


    public void registration(String userName, String password){
        if(user_identification.containsKey(userName)){
            System.out.println("Username already exists. Please choose a different username.");

        }else {
            user_identification.put(userName,password);
            System.out.println("Registration successful! Please proceed to login");

        }
    }

    public void logIn(String username, String password) {
        if (user_identification.containsKey(username) && user_identification.get(username).equals(password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password. Please try again.");

        }}

            public Boolean logInUser (String userName, String password){
                if (user_identification.containsKey(userName) && user_identification.get(userName).equals(password)) {

                    if (loggedInUsers.containsKey(userName)) {
                        System.out.println("User is already logged in.");
                        return false;
                    } else {
                        loggedInUsers.put(userName, true);

                        System.out.println("Log in successfull!");

                        return true;

                    }

                } else {
                    System.out.println("Invalid username or password. Please try again.");
                    return false;
                }
            }
            public void LogOut (String userName){
                if (loggedInUsers.containsKey(userName)) {
                    loggedInUsers.remove(userName);
                    System.out.println("Log out successful!");

                } else {
                    System.out.println("User is not logged in!");
                }
            }

}