package controlerView;

import controler.CourseController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import utilities.Utilities;

import javax.swing.*;

public class CourseControllerView {
    public TextField lblName;
    public TextField lblNumCredits;
    public TextField lblDificulty;
    public TextField lblDescription;
    public Button btnClose;
    public Button btnSave;
    public Button btnEliminateCurse;


    private String scinceSelected;
    public Label lblReturnInfo;
    public ComboBox comboBoxSince = new ComboBox();
    ObservableList<String> sicneList = FXCollections.observableArrayList("MATH" , "PROGRAMMING");
    JOptionPane jp  = new JOptionPane();

    private CourseController courseController;
    private Utilities utilities = new Utilities();

    public CourseControllerView(CourseController courseController) {
        this.courseController = courseController;

    }


    public void closeWindow(ActionEvent actionEvent) {
        //como la clase no cuenta con un stage asociado se usa esta forma
        // Obtener el nodo raíz del evento
        Node source = (Node) actionEvent.getSource();
        // Obtener el Stage asociado al nodo raíz
        Stage stage = (Stage) source.getScene().getWindow();
        // Cerrar la ventana
        stage.close();

    }


    public void addCourse(ActionEvent actionEvent) {
        String name = lblName.getText();
        String dificulty = utilities.cleanNames(lblDificulty.getText());
        String description = utilities.cleanNames(lblDescription.getText());
        int id = utilities.generateRandomNumber(10, 250);

        if (name.isEmpty() || dificulty.isEmpty() || description.isEmpty() || scinceSelected == null || scinceSelected.isEmpty()) {
            lblReturnInfo.setText("Todos los campos son obligatorios");
            return;
        }

        try {
            int difficulty = Integer.parseInt(dificulty);
            if (difficulty > 6 || difficulty < 0) {
                lblReturnInfo.setText("La dificultad no puede ser mayor a 6 o menor a 0");
                return;
            }
        } catch (NumberFormatException e) {
            lblReturnInfo.setText("La dificultad debe ser un número válido");
            return;
        }

        if (courseController.validaNameCourse(name)) {
            lblReturnInfo.setText("El curso ya existe");
        } else {
            //los creditos inician en 0
            lblReturnInfo.setText("Curso creado con éxito");
            lblReturnInfo.setStyle("-fx-text-fill: green;");
            String infoCourse = courseController.addCourseByView(id, name, 0,Integer.parseInt(dificulty), description, scinceSelected);
            jp.showMessageDialog(null, "Curso creado. Revise la información: \n" + infoCourse, "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }



    public void viewSicne(Event event) {
        //muestra lo del combovox
        utilities.fillComboVox(comboBoxSince, sicneList);

    }

    public void selecScine(Event event) {
        //Retorna el valor seleccionado
        scinceSelected = comboBoxSince.getValue().toString();

    }




    public void deleteCurse(ActionEvent actionEvent) {
        String courseName = jp.showInputDialog(null, "Ingrese el nombre del curso a eliminar:", "Eliminar Curso", JOptionPane.QUESTION_MESSAGE);

        if (courseName != null) {

            if (courseController.validaNameCourse(courseName)) {
                courseController.deleteCourseByName(courseName);
                lblReturnInfo.setStyle("-fx-text-fill: green;");
                lblReturnInfo.setText("Curso Eliminado");
            } else {
                lblReturnInfo.setStyle("-fx-text-fill: red;");
                lblReturnInfo.setText("Curso No Encontrado");
            }
        }else {
            lblReturnInfo.setText("El nombre del curso no puede estar vacío");

        }

    }
}
