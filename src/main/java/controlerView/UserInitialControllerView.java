package controlerView;

import controler.CourseController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Course;
import view.CourseView;

import java.io.IOException;

public class UserInitialControllerView {
    public Button sendbtn;
    public Button btnAddCourse;
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
    private TableColumn<Course, String> interestMathComboBoxColumn;

    @FXML
    private TableColumn<Course, String> curseProgrammingColumn;
    @FXML
    private TableColumn<Course, String> descriptionProgrammingColumn;
    @FXML
    private TableColumn<Course, Integer> itrScoreProgrammingColumn;
    @FXML
    private TableColumn<Course, String> interestProgrammingComboBoxColumn;

    @FXML
    private TableView<Course> mathTableView;
    @FXML
    private TableView<Course> programmingTableView;

    private ObservableList<Course> mathCourses;
    private ObservableList<Course> programmingCourses;

    public UserInitialControllerView() {}

    public UserInitialControllerView(CourseController courseController) {
        this.courseController = courseController;
    }

    public void updateDataMath(){
        // Configurar las columnas interestComboBoxColumn con un ComboBox para matemáticas
        interestMathComboBoxColumn.setCellFactory(new Callback<TableColumn<Course, String>, TableCell<Course, String>>() {
            @Override
            public TableCell<Course, String> call(TableColumn<Course, String> param) {
                return new TableCell<Course, String>() {
                    private final ComboBox<String> comboBox = new ComboBox<>(FXCollections.observableArrayList("Muy interesado", "Interesado", "Poco interesado"));

                    {
                        comboBox.setOnAction(event -> {

                            switch (comboBox.getSelectionModel().getSelectedIndex()) {
                                case 0:
                                    courseController.modifyCourseByCourse(getTableView().getItems().get(getIndex()), 5);
                                    //getTableView().getItems().get(getIndex()).setInterest(5);
                                    System.out.println("Muy interesado");
                                    break;
                                case 1:
                                    courseController.modifyCourseByCourse(getTableView().getItems().get(getIndex()), 3);
                                    //getTableView().getItems().get(getIndex()).setInterest(3);
                                    System.out.println("Interesado");
                                    break;
                                case 2:
                                    courseController.modifyCourseByCourse(getTableView().getItems().get(getIndex()), 1);
                                    //getTableView().getItems().get(getIndex()).setInterest(1);
                                    System.out.println("Poco interesado");
                                    break;
                            }
                            // escribir persistencia
                            courseController.writeFile("courses");

                        });
                    }

                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(comboBox);
                            comboBox.getSelectionModel().select(item);
                        }
                    }
                };
            }
        });
    }

    public void updateDataProgramming() {
        // Configurar las columnas interestComboBoxColumn con un ComboBox para programación
        interestProgrammingComboBoxColumn.setCellFactory(new Callback<TableColumn<Course, String>, TableCell<Course, String>>() {
            @Override
            public TableCell<Course, String> call(TableColumn<Course, String> param) {
                return new TableCell<Course, String>() {
                    //Muy Intersado es dominado, poco interesado es lo contrario a dominado
                    private final ComboBox<String> comboBox = new ComboBox<>(FXCollections.observableArrayList("Muy interesado", "Interesado", "Poco interesado"));

                    {
                        comboBox.setOnAction(event -> {
                            switch (comboBox.getSelectionModel().getSelectedIndex()) {
                                case 0:
                                    courseController.modifyCourseByCourse(getTableView().getItems().get(getIndex()), 5);
                                    System.out.println("Muy interesado");
                                    break;
                                case 1:
                                    courseController.modifyCourseByCourse(getTableView().getItems().get(getIndex()), 3);
                                    System.out.println("Interesado");
                                    break;
                                case 2:
                                    courseController.modifyCourseByCourse(getTableView().getItems().get(getIndex()), 1);
                                    System.out.println("Poco interesado");
                                    break;
                            }
                            // escribir persistencia
                            courseController.writeFile("courses");
                        });
                    }

                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(comboBox);
                            comboBox.getSelectionModel().select(item);
                        }
                    }
                };
            }
        });
    }


    @FXML
    public void initialize() {
        // Configurar las columnas de la tabla de matemáticas
        curseMathColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionMathColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        itrScoreMathColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

        // Configurar las columnas de la tabla de programación
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
        comboBoxMatematicas.setItems(FXCollections.observableArrayList("","Principiante", "Intermedio", "Avanzado"));
        comboBoxProgramacion.setItems(FXCollections.observableArrayList("","Principiante", "Intermedio", "Avanzado"));
        //llama al llenar datos de mataticas fila de interes
        updateDataMath();
        updateDataProgramming();



        // Añadir columnas a las tablas
        mathTableView.getColumns().add(interestMathComboBoxColumn);
        programmingTableView.getColumns().add(interestProgrammingComboBoxColumn);
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
        ObservableList<Course> filteredProgrammingCourses = FXCollections.observableArrayList();

        if (selectedMathDifficulty == null || selectedMathDifficulty.equals("")) {
            fillTable();
            mathTableView.setItems(mathCourses);
        } else {
            for (Course course : courseController.getCourseList()) {
                if ("MATH".equals(course.getScience()) && matchesDifficulty(course, selectedMathDifficulty)) {
                    filteredMathCourses.add(course);
                }
            }
            mathTableView.setItems(filteredMathCourses);
        }

        if (selectedProgrammingDifficulty == null || selectedProgrammingDifficulty.equals("")) {
            fillTable();
            programmingTableView.setItems(programmingCourses);
        } else {
            for (Course course : courseController.getCourseList()) {
                if ("PROGRAMMING".equals(course.getScience()) && matchesDifficulty(course, selectedProgrammingDifficulty)) {
                    filteredProgrammingCourses.add(course);
                }
            }
            programmingTableView.setItems(filteredProgrammingCourses);
        }
    }

    public void fillTable(){
        mathCourses.clear();
        programmingCourses.clear();
        for (Course course : courseController.getCourseList()) {
            if ("MATH".equals(course.getScience())) {
                mathCourses.add(course);
            } else if ("PROGRAMMING".equals(course.getScience())) {
                programmingCourses.add(course);
            }
        }
    }

    @FXML
    public void sendTree(ActionEvent actionEvent) {
        updateDataMath();
        updateDataProgramming();
        //System.out.println(courseController.temp());
        System.out.println("---------------------------------------------------------------------------------------");
        courseController.assignCredits();


        for(Course course : courseController.getCourseList()) {
            System.out.println("nombre del curso-->"+course.getName());
            System.out.println("interes-->"+course.getInterest());
            System.out.println("creditos-->"+ course.getCredits());
        }
        // Implementar funcionalidad para enviar datos
    }

    private boolean matchesDifficulty(Course course, String difficulty) {
        switch (difficulty) {
            case "Principiante":
                return course.getScore() == 1|| course.getScore() == 2;

            case "Intermedio":
                return course.getScore() == 3 || course.getScore() == 4;
            case "Avanzado":
                return course.getScore() >= 5;
            default:
                return true;
        }
    }

    public void addCourse(ActionEvent actionEvent) throws IOException {
        //llama la nueva ventana
        CourseView courseView = new CourseView(courseController);
        courseView.start(new Stage());

    }



}
