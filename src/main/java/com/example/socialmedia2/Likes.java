package com.example.socialmedia2;

import java.time.LocalDateTime;
import java.util.List;

public class Likes {
    private User loggedInUser;
    private List<User> users;
    private LocalDateTime timestamp;
    private int count;


    public Likes(User loggedInUser, List<User> users, LocalDateTime timestamp, int count) {
        this.loggedInUser = loggedInUser;
        this.users = users;
        this.timestamp = timestamp;
        this.count = count;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
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
                "username=" + loggedInUser +
                ", users=" + users +
                ", timestamp=" + timestamp +
                ", count=" + count +
                '}';
    }
}
