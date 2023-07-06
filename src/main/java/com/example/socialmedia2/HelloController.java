package com.example.socialmedia2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText ;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onSignIn() throws IOException {
        String email = emailField.getText();
        String password = passwordField.getText();

        if ("admin".equals(email) && "admin".equals(password)) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
            Parent root = loader.load();

            Scene scene = welcomeText.getScene();
            if (scene != null) {
                Stage stage = (Stage) scene.getWindow();
                stage.setScene(new Scene(root, 600, 400));
            }
        } else {
            // Show error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Wrong Credentials");
            alert.setContentText("Please enter correct email and password!");

            alert.showAndWait();
        }
    }
}
