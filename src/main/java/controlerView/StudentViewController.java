package controlerView;

import controler.CourseController;
import controler.StudentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class StudentViewController {

    private StudentController studentController;

    @FXML
    private TextField textField1;

    public StudentViewController(){

    }
    public StudentViewController(StudentController studentController) {
        this.studentController = studentController;
    }

    @FXML
    private void guardar(ActionEvent event) {
        System.out.println("Entre Aca");
        System.out.println(textField1.getText());
    }
}
