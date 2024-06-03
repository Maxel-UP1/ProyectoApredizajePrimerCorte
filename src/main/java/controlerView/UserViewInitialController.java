package controlerView;

import controler.CourseController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Course;

import java.io.IOException;

public class UserViewInitialController {
    private CourseController courseController;

    @FXML
    private Label bienvenidoLabel;
    @FXML
    private Label NameLabel;
    @FXML
    private Label matematicasLabel;
    @FXML
    private Label programacionLabel;
    @FXML
    private ComboBox<String> comboBoxMatematicas;
    @FXML
    private ComboBox<String> comboBoxProgramacion;
    @FXML
    private Button goBtn;

    @FXML
    private TableColumn<Course, String> curseMathColumn;
    @FXML
    private TableColumn<Course, String> descriptionMathColumn;
    @FXML
    private TableColumn<Course, Integer> itrScoreMathColumn;
    @FXML
    private Button sendbtn;
    @FXML
    private TableColumn<Course, String> curseProgrammingColumn;
    @FXML
    private TableColumn<Course, String> descriptionProgrammingColumn;
    @FXML
    private TableColumn<Course, Integer> itrScoreProgrammingColumn;

    @FXML
    private TableView<Course> mathTableView;
    @FXML
    private TableView<Course> programmingTableView;


    @FXML
    private Label helloLabel;

    private ObservableList<Course> mathCourses;
    private ObservableList<Course> programmingCourses;





    public UserViewInitialController() {

    }


    public UserViewInitialController(CourseController courseController) {
        this.courseController = courseController;
    }

    @FXML
    public void initialize() {
        // Configurar las columnas de la tabla
        curseMathColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionMathColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        itrScoreMathColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

        curseProgrammingColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionProgrammingColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        itrScoreProgrammingColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

        // Inicializar listas observables
        mathCourses = FXCollections.observableArrayList();
        programmingCourses = FXCollections.observableArrayList();

        // Llenar las listas con cursos
        for (Course course : courseController.getCourseList()) {
            if ("MATH".equals(course.getScience())) {
                mathCourses.add(course);
            } else if ("PROGRAMMING".equals(course.getScience())) {
                programmingCourses.add(course);
            }
        }

        // Configurar las tablas con las listas observables
        mathTableView.setItems(mathCourses);
        programmingTableView.setItems(programmingCourses);

        // Configurar los ComboBox con opciones de dificultad
        comboBoxMatematicas.setItems(FXCollections.observableArrayList("Beginner", "Intermediate", "Advanced"));
        comboBoxProgramacion.setItems(FXCollections.observableArrayList("Beginner", "Intermediate", "Advanced"));
    }

    @FXML
    public void selecDificultyMath(ActionEvent actionEvent) {
        String selectedDifficulty = comboBoxMatematicas.getValue();
        ObservableList<Course> filteredCourses = FXCollections.observableArrayList();
        for (Course course : courseController.getCourseList()) {
            if ("MATH".equals(course.getScience()) && matchesDifficulty(course, selectedDifficulty)) {
                filteredCourses.add(course);
            }
        }
        mathTableView.setItems(filteredCourses);
    }

    @FXML
    public void selecDificultyProgramming(ActionEvent actionEvent) {
        String selectedDifficulty = comboBoxProgramacion.getValue();
        ObservableList<Course> filteredCourses = FXCollections.observableArrayList();
        for (Course course : courseController.getCourseList()) {
            if ("PROGRAMMING".equals(course.getScience()) && matchesDifficulty(course, selectedDifficulty)) {
                filteredCourses.add(course);
            }
        }
        programmingTableView.setItems(filteredCourses);
    }

    @FXML
    public void searchCourse(ActionEvent actionEvent) {
        String selectedMathDifficulty = comboBoxMatematicas.getValue();
        String selectedProgrammingDifficulty = comboBoxProgramacion.getValue();

        ObservableList<Course> filteredMathCourses = FXCollections.observableArrayList();
        for (Course course : courseController.getCourseList()) {
            if ("MATH".equals(course.getScience()) && matchesDifficulty(course, selectedMathDifficulty)) {
                filteredMathCourses.add(course);
            }
        }
        mathTableView.setItems(filteredMathCourses);

        ObservableList<Course> filteredProgrammingCourses = FXCollections.observableArrayList();
        for (Course course : courseController.getCourseList()) {
            if ("PROGRAMMING".equals(course.getScience()) && matchesDifficulty(course, selectedProgrammingDifficulty)) {
                filteredProgrammingCourses.add(course);
            }
        }
        programmingTableView.setItems(filteredProgrammingCourses);
    }

    @FXML
    public void sendTree(ActionEvent actionEvent) {
        // Implementar funcionalidad para enviar datos



    }

    private boolean matchesDifficulty(Course course, String difficulty) {
        switch (difficulty) {
            case "Beginner":
                return course.getCluster() == 1;
            case "Intermediate":
                return course.getCluster() == 2 || course.getCluster() == 3;
            case "Advanced":
                return course.getCluster() >= 4;
            default:
                return true;
        }
    }

    @FXML
    private void sendTree() {
        sendTree(null);
    }

    @FXML
    private void guardarCurso(ActionEvent event) {
        try {
            // Cargar el archivo FXML del panel de saludo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CoursePanel.fxml"));
            Parent root = loader.load();

            // Crear una nueva escena con el panel de saludo
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void guardarProfesor(ActionEvent event) {
        try {
            // Cargar el archivo FXML del panel de saludo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TeacherPanel.fxml"));
            Parent root = loader.load();

            // Crear una nueva escena con el panel de saludo
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void guardarEstudiante(ActionEvent event) {
        try {
            // Cargar el archivo FXML del panel de saludo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/StudentPanel.fxml"));
            Parent root = loader.load();

            // Crear una nueva escena con el panel de saludo
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
