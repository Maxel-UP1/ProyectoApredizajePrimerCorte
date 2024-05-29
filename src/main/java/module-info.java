module com.example.ejemplojfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens view to javafx.fxml;

    exports view;
    exports controler;

    opens controler to javafx.fxml;

    exports controlerView;

}