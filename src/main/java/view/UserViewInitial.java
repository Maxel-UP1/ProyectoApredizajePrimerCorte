package view;

import controler.CourseController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controlerView.UserInitialControllerView;

import java.io.IOException;

public class UserViewInitial extends Application {
    private CourseController courseController = new CourseController();
    int a;
    public static Stage currentStage;

    public  UserViewInitial( ){
        //crea el controlador, unico no se pueden crear mas
        this.courseController = new CourseController();
    }

    public void start(Stage stage) throws IOException {
        //cargar la persistencia (cursos)
        courseController.loadCoursesReadFile("courses");

        //incializa los controladores
        UserViewInitial  UserViewInitial = new UserViewInitial();



        FXMLLoader fxmlLoader = new FXMLLoader(UserViewInitial.class.getResource("UserViewInitial.fxml"));

        // Crear el controlador y configurarlo en el FXMLLoader
        UserInitialControllerView controller = new UserInitialControllerView(this.courseController);

        fxmlLoader.setController(controller);

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Aprendizaje Activo UP");
        stage.setScene(scene);
        stage.show();
    }


    // Metodo para cerrar las ventanas
    public void closeWindows(Stage stage) {
        stage.close();
    }

    public static void main(String[] args) {
        launch();
    }
}