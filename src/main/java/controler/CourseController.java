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


    public void writeFileReading(String nameFile, Course course){
        List<Course> courseListTEMP = jsonStorageUtilities.readContentFromFile(nameFile , COUSERTYPE);
        courseListTEMP.add(course);
        jsonStorageUtilities.saveDataToFile(courseListTEMP, nameFile, COUSERTYPE);

    }



    public void addCourse(int id_Course, String name_Course, int code_Curse, int credits, int cluster, int score, String description, String science) {
        Course course = new Course(id_Course, name_Course, code_Curse, credits, cluster, score, description, science);
        writeFileReading("courses", course);

    }

    public void deleteCourseById(int id_Course) {
        List<Course> courseListTEMP = jsonStorageUtilities.readContentFromFile("courses" , COUSERTYPE);
        for (Course course : courseListTEMP) {
            if (course.getId() == id_Course) {
                courseListTEMP.remove(course);
                break;
            }
        }
        //elimina, luego escribe en el archivo
        jsonStorageUtilities.saveDataToFile(courseListTEMP, "courses", COUSERTYPE);
    }

    public void updateCourseById(int id_Course, String name_Course, int code_Curse, int credits, int cluster, int score, String description, String science) {
        List<Course> courseListTEMP = jsonStorageUtilities.readContentFromFile("courses" , COUSERTYPE);
        for (Course course : courseListTEMP) {
            if (course.getId() == id_Course) {
                course.setName(name_Course);
                course.setCode(code_Curse);
                course.setCredits(credits);
                course.setCluster(cluster);
                course.setScore(score);
                course.setDescription(description);
                course.setScience(science);
                break;
            }
        }
        //actualiza, luego escribe en el archivo
        jsonStorageUtilities.saveDataToFile(courseListTEMP, "courses", COUSERTYPE);
    }


    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }


}
