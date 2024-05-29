module com.example.ejemplojfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens view to javafx.fxml;
    opens controler to javafx.fxml;
    opens controlerView to javafx.fxml;

    exports view;
    exports controler;
    exports controlerView;
    exports model;

    // Si tienes otros paquetes que necesitas abrir o exportar, agrégalos aquí.
}
