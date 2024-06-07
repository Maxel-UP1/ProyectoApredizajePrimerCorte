package view;

import controler.CourseController;
import model.BinarySearchTree;
import model.Course;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ArrayList<Course> list = new ArrayList<Course>();
        CourseController courseController = new CourseController();
        courseController.loadCoursesReadFile("courses");
        list = courseController.getCourseList();

        BinarySearchTree<Course> binarySearchTree = new BinarySearchTree<Course>();
        for (Course course : list) {
            System.out.println(course.toString());
            binarySearchTree.insertarElemento(course);

        }
        System.out.println("................................................................................................");
        ArrayList<Course> list2 = binarySearchTree.obtenerElementosOrdenadosAscendentemente();
        for (Course course : list2) {
            System.out.println(course.toString());

        }
    }
}
