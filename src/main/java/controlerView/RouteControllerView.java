package controlerView;

import controler.CourseController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import utilities.FileStorageUtilities;

import javax.swing.*;

public class RouteControllerView {
        JOptionPane jp = new JOptionPane();
        private FileStorageUtilities fileStorageUtilities = new FileStorageUtilities();
        private CourseController courseController;
        public RouteControllerView(CourseController courseController) {
                this.courseController = courseController;
        }

        @FXML
        private TableView<?> panelTableMatematicas;

        @FXML
        private TableColumn<?, ?> cursoVistoMatematicas;

        @FXML
        private TableColumn<?, ?> cursoPorVerMatematicas;

        @FXML
        private TableColumn<?, ?> cursoSiguienteMatematicas;

        @FXML
        private TableView<?> panelTableProgramacion;

        @FXML
        private TableColumn<?, ?> cursoVistoProgramacion;

        @FXML
        private TableColumn<?, ?> cursoPorVerProgramacion;

        @FXML
        private TableColumn<?, ?> cursoSiguienteProgramacion;

        @FXML
        private Button atrasButton;

        @FXML
        private Button buttonImagenMath;

        @FXML
        private Button buttonImagenProgra;

        @FXML
        private void initialize() {
                // Aquí puedes inicializar los datos de las tablas si es necesario
                // Por ejemplo, puedes cargar datos desde una base de datos o algún servicio
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
