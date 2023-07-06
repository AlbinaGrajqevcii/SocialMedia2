package com.example.socialmedia2;

import java.util.ArrayList;
import java.util.List;

public class Comments {

        private List<String> comments;

        public Comments() {
            this.comments = new ArrayList<>();
        }

        public void addComment(String comment) {
            comments.add(comment);
            System.out.println("Comment added: " + comment);
        }

        public List<String> getComments() {
            return comments;
        }


    }