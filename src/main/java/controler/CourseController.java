package controler;

import model.Course;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CourseController {

    private ArrayList<Course> courseList;


    public CourseController() {
        courseList = new ArrayList<>();
    }

    //Cursos precargados en memoria
    public void loadCourses(){
        addCourse(1, "Calculo I", 101, 4, 1, 90);
        addCourse(2, "Calculo II", 102, 4, 1, 80);
        addCourse(3, "Calculo III", 103, 4, 1, 70);
        addCourse(4, "Programacion I", 104, 4, 2, 60);
        addCourse(5, "Base de Datos ", 105, 4, 2, 50);
        addCourse(6, "Redes", 106, 4, 2, 40);
        addCourse(7, "Ingles", 107, 4, 3, 30);
        addCourse(8, "Frances", 108, 4, 3, 20);
        addCourse(9, "Aleman", 109, 4, 3, 10);
    }

    public  void addCourse(int id_Course, String name_Course, int code_Curse, int credits, int cluster, int score){
        Course course = new Course(id_Course, name_Course, code_Curse, credits, cluster, score);
        courseList.add(course);
    }


    public void deleteCourse(int id_Course){
        for (Course course : courseList) {
            if(course.getId_Course() == id_Course){
                courseList.remove(course);
                break;
            }
        }
    }

    public String nameCourse(int id_Course){
        for (Course course : courseList) {
            if(course.getId_Course() == id_Course){
                return course.getName_Course();
            }
        }
        return null;
    }



    public ArrayList<Course> getCourseList() {
        return courseList;
    }

}
