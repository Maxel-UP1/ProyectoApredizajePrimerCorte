package controlerView;

import controler.CourseController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Course;
import utilities.FileStorageUtilities;

import javax.swing.*;
import java.util.ArrayList;

public class RouteControllerView {
        private CourseController courseController;

        public RouteControllerView(CourseController courseController) {
                this.courseController = courseController;
        }

        @FXML
        private TableView<CourseDisplay> panelTableMatematicas;

        @FXML
        private TableColumn<CourseDisplay, String> cursoVistoMatematicas;

        @FXML
        private TableColumn<CourseDisplay, String> cursoPorVerMatematicas;

        @FXML
        private TableColumn<CourseDisplay, String> cursoSiguienteMatematicas;

        @FXML
        private TableView<CourseDisplay> panelTableProgramacion;

        @FXML
        private TableColumn<CourseDisplay, String> cursoVistoProgramacion;

        @FXML
        private TableColumn<CourseDisplay, String> cursoPorVerProgramacion;

        @FXML
        private TableColumn<CourseDisplay, String> cursoSiguienteProgramacion;

        @FXML
        private Button atrasButton;

        @FXML
        private Button buttonImagenMath;

        @FXML
        private Button buttonImagenProgra;

        private FileStorageUtilities fileStorageUtilities = new FileStorageUtilities();
        private JOptionPane jp = new JOptionPane();

        @FXML
        private void initialize() {
                // Inicializar las columnas
                cursoVistoMatematicas.setCellValueFactory(new PropertyValueFactory<>("cursoVisto"));
                cursoPorVerMatematicas.setCellValueFactory(new PropertyValueFactory<>("cursoPorVer"));
                cursoSiguienteMatematicas.setCellValueFactory(new PropertyValueFactory<>("cursoSiguiente"));

                cursoVistoProgramacion.setCellValueFactory(new PropertyValueFactory<>("cursoVisto"));
                cursoPorVerProgramacion.setCellValueFactory(new PropertyValueFactory<>("cursoPorVer"));
                cursoSiguienteProgramacion.setCellValueFactory(new PropertyValueFactory<>("cursoSiguiente"));

                // Llenar la tabla de Matemáticas
                fillTableWithSpecificValues(panelTableMatematicas, courseController.treeMath().leftSubtreeValues(), courseController.treeMath().getRoot().getValue(), courseController.treeMath().rightSubtreeValues());

                // Llenar la tabla de Programación
                fillTableWithSpecificValues(panelTableProgramacion, courseController.treeProgra().leftSubtreeValues(), courseController.treeProgra().getRoot().getValue(), courseController.treeProgra().rightSubtreeValues());
        }

        private void fillTableWithSpecificValues(TableView<CourseDisplay> tableView, ArrayList<Course> leftValues, Course rootValue, ArrayList<Course> rightValues) {
                ObservableList<CourseDisplay> courses = FXCollections.observableArrayList();

                // Add all left subtree values
                for (Course course : leftValues) {
                        courses.add(new CourseDisplay(course.getName(), "", ""));
                }

                // Add the root value
                courses.add(new CourseDisplay("", rootValue.getName(), ""));

                // Add all right subtree values
                for (Course course : rightValues) {
                        courses.add(new CourseDisplay("", "", course.getName()));
                }

                tableView.setItems(courses);
        }

        @FXML
        public void goBack(ActionEvent actionEvent) {
                Node source = (Node) actionEvent.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();


        }

        @FXML
        public void buttonImagenMath(ActionEvent actionEvent) {
                //escribo en el archivo de los arboles de matematcias
                fileStorageUtilities.writeGrapht("graphMath", courseController.treeMath());
                //grafica la imagne segun la informacion
                String Renpods = fileStorageUtilities.drawGrapht(fileStorageUtilities.readDotFile("graphMath"));
                jp.showMessageDialog(null, Renpods);


        }

        @FXML
        public void buttonImagenProgra(ActionEvent actionEvent) {
                fileStorageUtilities.writeGrapht("graphProgram", courseController.treeProgra());
                String Renpods = fileStorageUtilities.drawGrapht(fileStorageUtilities.readDotFile("graphProgram"));
                jp.showMessageDialog(null, Renpods);
}
}
