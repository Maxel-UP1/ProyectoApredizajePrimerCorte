package view;

import controler.CourseController;
import controlerView.CourseControllerView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CourseView extends Application {

    private CourseController courseController;

    public CourseView(CourseController courseController) {
        this.courseController = courseController;
    }

    @Override
    public void start(Stage stage) throws IOException {
        // Muestra la ventana principal
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CoursePanel.fxml"));
        CourseControllerView courseControllerView = new CourseControllerView(courseController);


        fxmlLoader.setController(courseControllerView);

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("Registro de Cursos");
        stage.setScene(scene);
        stage.show();
    }
}

