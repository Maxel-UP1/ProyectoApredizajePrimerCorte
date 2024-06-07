package view;

import controler.CourseController;
import controlerView.CourseControllerView;
import controlerView.RouteControllerView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RouteView extends Application {

    private CourseController courseController;

    public RouteView(CourseController courseController) {
        this.courseController = courseController;
    }

    @Override
    public void start(Stage stage) throws IOException {
        // Muestra la ventana principal
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RouteView.fxml"));
        RouteControllerView courseControllerView = new RouteControllerView(courseController);


        fxmlLoader.setController(courseControllerView);

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        stage.setTitle("Tabla de Rutas");
        stage.setScene(scene);
        stage.show();
    }
}
