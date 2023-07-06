package com.example.socialmedia2;

import java.util.ArrayList;
import java.util.List;

public class Followers {
    private User username;
    private List<User> followers;

    public Followers(User username, List<User> followers) {
        this.username = username;
        this.followers = followers;
    }

    public void addFollower(User followerUsername) {
        if (!followers.contains(followerUsername)) {
            followers.add(followerUsername);
            System.out.println(followerUsername + " is now following " + username);
        } else {
            System.out.println(followerUsername + " is already following " + username);
        }
    }

    public void removeFollower(String followerUsername) {
        if (followers.contains(followerUsername)) {
            followers.remove(followerUsername);
            System.out.println(followerUsername + " is no longer following " + username);
        } else {
            System.out.println(followerUsername + " is not following " + username);
        }
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    @Override
    public String toString() {
        return "Followers{" +
                "username=" + username +
                ", followers=" + followers +
                '}';
    }
}
