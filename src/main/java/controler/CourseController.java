package controler;

import model.Course;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CourseController {

    private ArrayList<Course> courseList;


    public CourseController() {
        courseList = new ArrayList<>();
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
