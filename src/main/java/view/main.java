package view;

import controler.CourseController;
import model.BinarySearchTree;
import model.Course;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ArrayList<Course> listMath = new ArrayList<Course>();
        CourseController courseController = new CourseController();
        courseController.loadCoursesReadFile("courses");


        for (Course course : courseController.getCourseList()) {
            if (course.getScience().equals("MATH")) {
                listMath.add(course);
            }
        }

        listMath = courseController.sortCoursesByCredits(listMath);
        int index = courseController.divideNumber(listMath.size());
        System.out.println("......................................LISTA..........................................................sssssssssssssssssssssssssssssssmksdkdsm-------" + index);
        System.out.println(".....................INSERTAR .................MATH..........................................................");
        //ARBOL MATEMATICAS
        BinarySearchTree<Course> binarySearchTreemMATH = new BinarySearchTree<Course>();
        binarySearchTreemMATH.insertarElemento(listMath.get(index));
        for (int i = 0; i < listMath.size(); i++) {


            if (listMath.get(i).getScience().equals("MATH") && i != index) {
                System.out.println(listMath.get(i).getName());
                System.out.println(listMath.get(i).getCredits());
                binarySearchTreemMATH.insertarElemento(listMath.get(i));
            }


        }
        System.out.println("......................................MATH..........................................................");
        ArrayList<Course> list2 = binarySearchTreemMATH.obtenerElementosOrdenadosAscendentemente();
        for (Course course : list2) {
            System.out.println(course.getName());
            System.out.println(course.getCredits());

        }


        System.out.println("......................................MATH..........................................................");
        binarySearchTreemMATH.prettyPrint();


    }
}