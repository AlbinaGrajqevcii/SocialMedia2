package com.example.socialmedia2;

import javafx.application.Application;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.*;
public class Main  {
    public static void main(String[] args)throws ClassNotFoundException, SQLException {

        boolean loggedIn = false;

//        User user1 = new User("dalinaelshani", "dalina123");


//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialmedia", "root", "");
//        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user(userName, password) VALUES (?, ?)");
//        if (user1.getUserName() != null) {
//            preparedStatement.setString(1, user1.getUserName());
//        } else {
//            preparedStatement.setNull(1, Types.VARCHAR);
//        }
//        if (user1.getPassword() != null) {
//            preparedStatement.setString(2, user1.getPassword());
//        } else {
//            preparedStatement.setNull(2, Types.VARCHAR);
//        }
//        preparedStatement.executeUpdate();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialmedia", "root", "");

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user(userName, password) VALUES (?, ?)");

        connection.setAutoCommit(true);
        ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM user");

        while (resultSet.next()) {
            String username = resultSet.getString("userName");
            String password = resultSet.getString("password");
//            System.out.println("Username: " + username + ", Password: " + password);
        }
        LogIn login = new LogIn();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1.Register");
            System.out.println("2.Log In");
            System.out.println("3.Exit");
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
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);
                    preparedStatement.executeUpdate();

                    System.out.println("\nLog In");
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    loggedIn = login.logInUser(username, password);

                    break;
                case 2:
                    System.out.println("\nLog In");
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    login.logInUser(username, password);
                    if (loggedIn) {
                        User loggedInUser = new User(username, password);
                        loggedInUser.retrieveUserDataFromDatabase(connection); // Retrieve user data from the database
                        System.out.println("Logged in as: " + loggedInUser.getUserName());
                        manageApplication(loggedInUser, scanner);
                        break;// Pass the loggedInUser object and scanner to the manageApp method
                    }
                    break;

                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.Please try again!");

            }
            break;

        }

        while (true) {
            System.out.println("\n=== Social Media App ===");
            System.out.println("1. Manage Posts");
            System.out.println("2. Manage Likes");
            System.out.println("3. Manage Comments");
            System.out.println("4. Manage Followers");
            System.out.println("5. Log Out");
            System.out.print("Enter your choice: ");
            int choice2 = scanner.nextInt();
            scanner.nextLine();

            switch (choice2) {
                case 1:
                    managePosts();
                    break;
                case 2:
                    manageLikes(loggedInUser);
                    break;
                case 3:
                    manageComments();
                    break;
                case 4:
                    manageFollowers();
                    break;
                case 5:
                    loggedIn = false;
                    System.out.println("Logged Out");
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void manageApplication(User loggedInUser, Scanner scanner) {
    }

    private static void managePosts() {
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
    }


    private static void manageComments() {
        Comments postComments = new Comments();
        postComments.addComment("Great post!");
        postComments.addComment("I totally agree with you.");
        postComments.addComment("Could you provide more details?");

        List<String> comments = postComments.getComments();
        System.out.println("Comments:");
        for (String comment : comments) {
            System.out.println(comment);
        }
    }

public static  void manageFollowers() {
        User user1 = new User(1, "albinagrajqevci","albina123", new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2, "dalinaelshani","dalina123", new ArrayList<>(), new ArrayList<>());
        User user3 = new User(3,"medinashabani","medina123",new ArrayList<>(),new ArrayList<>());
        User user4 = new User(4,"artaa","artaa123",new ArrayList<>(),new ArrayList<>());
        User user5 = new User(5,"Orgessa","orgessa123",new ArrayList<>(),new ArrayList<>());
        User user6 = new User(6,"elfatekrasniqi","elfate123",new ArrayList<>(),new ArrayList<>());

        Followers followers = new Followers(user1, user1.getFollowers());
        followers.addFollower(user1);
        followers.addFollower(user2);
        followers.addFollower(user3);
        followers.addFollower(user4);
        followers.addFollower(user5);
        followers.addFollower(user6);
        followers.removeFollower("follower2");
        followers.removeFollower("follower3");
        List<User> followerList = followers.getFollowers();

        System.out.println("Followers:");
        for (User follower : followerList) {
            System.out.println(follower);
        }

        System.out.println("User ID: " + user1.getUserID());
        System.out.println("Username: " + user1.getUserName());
        System.out.println("Followers: " + user1.getFollowers());
//         user1.getPosts().add(post1);
//         user1.getPosts().add(post2);
//         user1.getFollowers().add(user2);
    }
    private static void manageLikes(User loggedInUser) {
        User user1 = new User(1, "albinagrajqevci","albina123", new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2, "dalinaelshani","dalina123", new ArrayList<>(), new ArrayList<>());
        User user3 = new User(3,"medinashabani","medina123",new ArrayList<>(),new ArrayList<>());
        User user4 = new User(4,"artaa","artaa123",new ArrayList<>(),new ArrayList<>());
        User user5 = new User(5,"Orgessa","orgessa123",new ArrayList<>(),new ArrayList<>());
        User user6 = new User(6,"elfatekrasniqi","elfate123",new ArrayList<>(),new ArrayList<>());
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user6);


        Likes likes = new Likes(loggedInUser, users, LocalDateTime.now(), users.size());

        // Display initial state
        System.out.println("Initial Likes:");
        System.out.println("Username: " + loggedInUser.getUserName());
        System.out.println("Users who liked: " + likes.getUsers());
        System.out.println("Timestamp: " + likes.getTimestamp());
        System.out.println("Count: " + likes.getCount());

        // Add a user to likes
        likes.addUser(user5);
    }
}
