module com.example.socialmedia2 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.socialmedia2 to javafx.fxml;
    exports com.example.socialmedia2;
}