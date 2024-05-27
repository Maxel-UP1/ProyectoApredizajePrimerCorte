module com.example.ejemplojfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens view to javafx.fxml;
    exports view;
    exports controlers;
    opens controlers to javafx.fxml;
}