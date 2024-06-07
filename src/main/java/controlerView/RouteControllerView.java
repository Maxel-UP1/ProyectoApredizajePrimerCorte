package controlerView;

import controler.CourseController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class RouteControllerView {
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
                //como la clase no cuenta con un stage asociado se usa esta forma
                // Obtener el nodo raíz del evento
                Node source = (Node) actionEvent.getSource();
                // Obtener el Stage asociado al nodo raíz
                Stage stage = (Stage) source.getScene().getWindow();
                // Cerrar la ventana
                stage.close();


        }

        @FXML
        public void buttonImagenMath(ActionEvent actionEvent) {
                // Lógica para manejar el botón "Generar Imagen" para Matemáticas
                System.out.println("Botón Generar Imagen Matemáticas presionado");
                // Aquí puedes agregar la lógica para generar o mostrar la imagen relacionada con Matemáticas
        }

        @FXML
        public void buttonImagenProgra(ActionEvent actionEvent) {
                // Lógica para manejar el botón "Generar Imagen" para Programación
                System.out.println("Botón Generar Imagen Programación presionado");
                // Aquí puedes agregar la lógica para generar o mostrar la imagen relacionada con Programación
        }
}
