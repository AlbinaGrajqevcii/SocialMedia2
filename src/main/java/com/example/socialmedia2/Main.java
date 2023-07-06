package com.example.socialmedia2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LogIn login = new LogIn();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1.Register");
            System.out.println("2.Log In");
            System.out.println("3.Log Out");
            System.out.println("4.Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1:
                    System.out.println("Registration");
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    login.registration(username, password);

                    System.out.println("\nLog In");
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    login.logInUser(username, password);

                    break;
                case 2:
                    System.out.println("\nLog In");
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    login.logInUser(username, password);
                    break;
                case 3:
                    System.out.println("Log Out");
                    System.out.println("Enter username: ");
                    String logoutUsername = scanner.nextLine();
                    login.LogOut(logoutUsername);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.Please try again!");

            }
            break;


        }

        User user1 = new User(1, "albinagrajqevci", new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2, "dalinaelshani", new ArrayList<>(), new ArrayList<>());
        List<Posts> postsList = new ArrayList<>();


        List<String> content1 = new ArrayList<>();
        content1.add("This is the first post.");
        content1.add("It contains some text content.");
        Posts post1 = new Posts("albinagrajqevci", content1, PostType.TEXT);


        List<String> content2 = new ArrayList<>();
        content2.add("This is the second post.");
        content2.add("It contains an image.");
        content2.add("image.jpg");
        Posts post2 = new Posts("dalinaelshani", content2, PostType.IMAGE);

        postsList.add(post1);
        postsList.add(post2);


        for (Posts post : postsList) {
            System.out.println(post);
        }


        Comments postComments = new Comments();
        // Add comments to the post
        postComments.addComment("Great post!");
        postComments.addComment("I totally agree with you.");
        postComments.addComment("Could you provide more details?");

        // Retrieve and print the comments
        List<String> comments = postComments.getComments();
        System.out.println("Comments:");
        for (String comment : comments) {
            System.out.println(comment);
        }

        Followers followers = new Followers(user1,user1.getFollowers());

        followers.addFollower(user1);
        followers.addFollower(user2);



        followers.removeFollower("follower2");

        List<User> followerList = followers.getFollowers();

        System.out.println("Followers:");
        for (User follower : followerList) {
            System.out.println(follower);
        }


        System.out.println("User ID: " + user1.getUserID());
        System.out.println("Username: " + user1.getUserName());
        System.out.println("Followers: " + user1.getFollowers());
        System.out.println("Posts: " + user1.getPosts());
        user1.getPosts().add(post1);
        user1.getPosts().add(post2);
        user1.getFollowers().add(user2);

    }
}
