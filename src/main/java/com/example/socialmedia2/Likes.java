package com.example.socialmedia2;

import java.time.LocalDateTime;
import java.util.List;

public class Likes {
    private User username;
    private List<User> users;
    private LocalDateTime timestamp;
    private int count;

    public Likes(User username, List<User> users, LocalDateTime timestamp, int count) {
        this.username = username;
        this.users = users;
        this.timestamp = timestamp;
        this.count = count;
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
}
