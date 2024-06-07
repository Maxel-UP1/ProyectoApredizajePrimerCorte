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

        System.out.println(".....................INSERTAR .................MATH..........................................................");
        //ARBOL MATEMATICAS
        BinarySearchTree<Course> binarySearchTreemMATH = new BinarySearchTree<Course>();

        for (Course course : list) {

            if(course.getScience().equals("MATH")){
                System.out.println(course.getName());
                System.out.println(course.getCredits());
                binarySearchTreemMATH.insertarElemento(course);
            }


        }

        // ARBOL PROGRA
        System.out.println(".....................INSERTAR .................PROGRAMMING..........................................................");
        BinarySearchTree<Course> binarySearchTreemPROGRAMMING = new BinarySearchTree<Course>();

        for (Course course : list) {

            if(course.getScience().equals("PROGRAMMING")){
                System.out.println(course.getName());
                System.out.println(course.getCredits());
                binarySearchTreemMATH.insertarElemento(course);
            }


        }
        System.out.println("......................................MATH..........................................................");
        ArrayList<Course> list2 = binarySearchTreemMATH.obtenerElementosOrdenadosAscendentemente();
        for (Course course : list2) {
            System.out.println(course.getName());
            System.out.println(course.getCredits());

        }

        System.out.println("......................................PROGRAMMING..........................................................");
        ArrayList<Course> list3 = binarySearchTreemMATH.obtenerElementosOrdenadosAscendentemente();
        for (Course course : list3) {
            System.out.println(course.getName());
            System.out.println(course.getCredits());

        }
    }
}
