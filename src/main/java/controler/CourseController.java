package controler;

import com.google.gson.reflect.TypeToken;
import model.Course;
import persistence.JsonStorageUtilities;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CourseController {


    private JsonStorageUtilities jsonStorageUtilities;
    private ArrayList<Course> courseList;

    private static  final Type COUSERTYPE   = new TypeToken<List<Course>>(){}.getType();

    public CourseController() {
        courseList = new ArrayList<>();
        jsonStorageUtilities = new JsonStorageUtilities();
    }

    // Cursos precargados en memoria
    public void loadCoursesReadFile(String nameFile) {

        List<Course> coursesList = jsonStorageUtilities.readContentFromFile(nameFile , COUSERTYPE);
        //Convertir la lista de cursos  a un ArrayList<Course>, nuevo array poruqe se llama una vez
        this.courseList = new ArrayList<>(coursesList);


    }

    public void addCourse(int id_Course, String name_Course, int code_Curse, int credits, int cluster, int score, String description, String science) {
        Course course = new Course(id_Course, name_Course, code_Curse, credits, cluster, score, description, science);
        courseList.add(course);
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }


}
