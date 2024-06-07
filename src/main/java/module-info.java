module com.example.ejemplojfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.desktop;

    opens view to javafx.fxml;
    opens controler to javafx.fxml;
    opens controlerView to javafx.fxml;
    opens model to com.google.gson; // Esto abre el paquete model para Gson

    exports view;
    exports controler;
    exports controlerView;
    exports model;

    // Si tienes otros paquetes que necesitas abrir o exportar, agrégalos aquí.
}
